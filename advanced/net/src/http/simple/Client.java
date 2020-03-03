package http.simple;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Scanner;

//HTTP 客户端的功能：组织请求，解析响应
public class Client {
    public static void main(String[] args) throws IOException {
        //组织请求
        String request = "GET / HTTP/1.0\r\nHost:www.baidu.com\r\n\r\n";
        Socket socket = new Socket("www.baidu.com", 80);
        socket.getOutputStream().write(request.getBytes("UTF-8"));
        byte[] bytes = new byte[4096];
        int len = socket.getInputStream().read(bytes); //将输入流写到字符数组里，获得实际占用的长度
        //String response = new String(bytes, 0, len, "UTF-8");
        //System.out.println(response); //打印响应
        //解析响应
        int index = -1; //找到空行
        for (int i = 0; i < len -3; i++) {
            if (bytes[i] == '\r' && bytes[i+1] == '\n'
                && bytes[i+2] == '\r' && bytes[i+3] == '\n') {
                index = i; //932
                break;
            }
        }
        //打印状态行
        ByteArrayInputStream bArris = new ByteArrayInputStream(bytes); //又将字符数组转为输入流
        Scanner sc = new Scanner(bArris, "UTF-8");
        String statusCode = sc.nextLine();
        System.out.println("状态行：" + statusCode);
        String[] group = statusCode.split(" ");
        System.out.println("版本号：" + group[0]);
        System.out.println("状态码：" + group[1]);
        System.out.println("状态码描述：" + group[2]);
        //打印响应报头
        String line;
        int contentLen = 0;
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            System.out.println("响应头：" + key + " = " + value);
            if (key.equalsIgnoreCase("content-length")) {
                contentLen = Integer.valueOf(value);
            }
        }
        //打印响应正文
        byte[] body = new byte[contentLen]; //注意 bytes 的内容不是全部的百度响应内容
        int read = len - index - 4;
        System.arraycopy(bytes, index+4, body, 0, read);  //将 bytes 中已读的正文内容拷到 body 中
        int unread = contentLen - read;
        socket.getInputStream().read(body, read, unread); //继续在 body 中拷贝未读的内容
        String s = new String(body, 0, contentLen, "UTF-8");
        System.out.println(s);

        FileOutputStream files = new FileOutputStream("百度.html");
        files.write(body);
    }
}

import com.sun.source.tree.WhileLoopTree;

import javax.print.DocFlavor;
import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Demo {
    //得到一个输入流
    public static InputStream getInputStream() throws IOException {
        InputStream is;
        //法一：从文件中读
//        is = new FileInputStream("来自霍格沃兹的一封信.txt"); //与 io 同级目录下
//        return is;

        //法二：从网络中读
        Socket socket = new Socket("www.baidu.com", 80);
        OutputStream os = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        PrintWriter pw = new PrintWriter(writer, false);
        pw.printf("GET / HTTP/1.0\r\n\r\n");
        pw.flush();
        is = socket.getInputStream();
        return is;

        //法三：从内存中读
//        byte[] bytes = "我只是内存中的一段空间\r\n第二行\r\n".getBytes("UTF-8"); //将字符串转为字节数组
//        is = new ByteArrayInputStream(bytes);
//        return is;

        //法四：从标准输入读
//        is = System.in;
//        return is;
    }

    //从字节输入流中获得字符数据
    public static String getChars(InputStream is) throws IOException {
        //法一：直接通过字节方式读，然后程序进行字符编码
//        byte[] buffer = new byte[1024];
//        int len = is.read(buffer);  //字节流实际的长度 // 数据在 buffer[0, len)中
//        String message = new String(buffer, 0, len, "UTF-8");
//        return message;

        //法二：把 Stream(字节流) 转为 Reader(字符流)， 然后进行字符形式（直接读，BufferedReader（readLine））读取
        //2.1 直接读
//        Reader reader = new InputStreamReader(is, "UTF-8");
//        char[] buffer = new char[1024];
//        int len = reader.read(buffer);
//        String message = new String(buffer, 0, len);
//        return message;
        //2.1 变形
//        Reader reader = new InputStreamReader(is, "UTF-8");
//        char[] buffer = new char[10];
//        StringBuffer sb = new StringBuffer();
//        int len;
//        while ((len = reader.read(buffer)) != -1) {
//            sb.append(buffer, 0, len);
//        }
//        return sb.toString();
        //2.2 BufferedReader（readLine）
//        Reader reader = new InputStreamReader(is, "UTF-8");
//        BufferedReader br = new BufferedReader(reader);
//        String line;
//        StringBuffer sb = new StringBuffer();
//        while ((line = br.readLine()) != null) {
//            sb.append(line + "\r\n"); //加上\r\n，是因为 BufferReader 在读的时候会去掉 \r\n
//        }
//        return sb.toString();

        //法三：Scanner
        Scanner sc = new Scanner(is, "UTF-8");
//        String s;
//        while ((s = sc.nextLine()) != null) { //输出文件的所有内容
//            System.out.println(s);
//        }
        return sc.nextLine() + sc.nextLine();
    }

    //得到输出流
    public static OutputStream getOutputStream() throws IOException {
        OutputStream os;
        //法一：输出到文件
        os = new FileOutputStream("来自霍格沃兹的一封信.txt");

        //法二：输出到网络
//        Socket socket = new Socket("www.baidu.com", 80);
//        os = socket.getOutputStream();

        //法三：输出到内存
//        os = new ByteArrayOutputStream();

        //法四：标准输出/标准错误 屏幕（终端）

        return os;
    }

    //将字符数据写到字节输出流中
    public static void getChars2(OutputStream os, String message) throws IOException {
        //法一：直接写字节
//        byte[] buffer = message.getBytes("utf-8");
//        os.write(buffer); //若文件已存在则清空文件原本内容，再写入

        //法二：Writer （普通 / PrintWriter）
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        //2.1
//        writer.append(message);
//        writer.flush(); //先输出到缓冲区，刷新后再写到文件里
        //2.2
        PrintWriter pw = new PrintWriter(writer, false);
        pw.printf("%s", message);
        pw.flush();

    }

    public static void main(String[] args) throws IOException {
//        InputStream is = getInputStream();
//        System.out.println(getChars(is));

        OutputStream os = getOutputStream();
        getChars2(os, "小矮脚星");
    }
}

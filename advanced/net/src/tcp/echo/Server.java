package tcp.echo;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept(); //接收消息
            //若接收到消息，则打印客户端的信息
            InetAddress clientAddr = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            System.out.printf("有客户端连接 %s ：%d %n", clientAddr.getHostAddress(), clientPort);
            //获取字节流
            InputStream is = clientSocket.getInputStream();
            //字节流转化为字符流
            InputStreamReader ir = new InputStreamReader(is, "UTF-8");
            //字符流转换为缓冲字符流
            BufferedReader br = new BufferedReader(ir);
            //获取输出字节流
            OutputStream os = clientSocket.getOutputStream();
            PrintStream ps = new PrintStream(os, true, "UTF-8");
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
//                sb.append(line);
                System.out.println(line);
                ps.println("我已收到消息");
            }
//            clientSocket.close();
        }
    }
}

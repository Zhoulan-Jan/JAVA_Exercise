package tcp.echo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket clientSocket = new Socket();
        byte[] ipv4 = {127, 0, 0, 1};
        InetAddress serverAddr = InetAddress.getByAddress(ipv4);
        SocketAddress serverSocketAddr = new InetSocketAddress(serverAddr, 8080);
        clientSocket.connect(serverSocketAddr);

        while (true) {
            System.out.print("请输入 > ");
            String request = sc.nextLine();
            //通过字节流直接写入请求
            OutputStream os = clientSocket.getOutputStream();
            PrintStream ps = new PrintStream(os, true, "utf-8");
            ps.println(request);

            //通过字节流，直接读取数据
            InputStream is = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String response = br.readLine();
            System.out.println(response);
        }

//        clientSocket.close();

    }
}

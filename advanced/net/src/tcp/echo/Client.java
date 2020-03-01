package tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket();
        byte[] ipv4 = {127, 0, 0, 1};
        InetAddress serverAddr = InetAddress.getByAddress(ipv4);
        SocketAddress serverSocketAddr = new InetSocketAddress(serverAddr, 8080);
        clientSocket.connect(serverSocketAddr);

        while (true) {
            //通过字节流直接写入请求
            OutputStream os = clientSocket.getOutputStream();
            os.write("哈利波特\r\n".getBytes("UTF-8"));

            //通过字节流，直接读取数据
            InputStream is = clientSocket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = is.read(buffer);
            String response = new String(buffer, 0, len, "UTF-8");
            System.out.println(response);
        }

//        clientSocket.close();

    }

}

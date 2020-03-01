package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.新建一个 DatagramSocket
        DatagramSocket serverSocket = new DatagramSocket(9898);
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        //2.等待客户端传来消息
        serverSocket.receive(receivePacket);
        InetAddress clientAddr = receivePacket.getAddress();
        //3.打印消息
        System.out.printf("我从 %s ：%d 收到了消息%n",
                clientAddr.getHostAddress(), receivePacket.getPort());
        System.out.printf("我一共收到了 %d 字节的数据%n", receivePacket.getLength());
        String message = new String(receivePacket.getData(),
                0, receivePacket.getLength(), "UTF-8"); //字节 -> 字符输出
        System.out.println(message);

        //向客户端发消息
        byte[] sendBuffer = message.getBytes("UTF-8");
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddr, 9898);
        serverSocket.send(sendPacket);

        serverSocket.close();
    }

}

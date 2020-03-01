package udp.echo;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        String message = "霍格沃茨发了一封信";
        byte[] sendBuffer = message.getBytes("UTF-8");
        byte[] serverIP = {127, 0, 0, 1};
        InetAddress serverAddr = InetAddress.getByAddress(serverIP);
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                sendBuffer.length, serverAddr, 9898);
        clientSocket.send(sendPacket);

        //接收对方回应的消息
        byte[] recvBuffer = new byte[1024];
        DatagramPacket recvPacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        clientSocket.receive(recvPacket); // 错误 ❌  System.out.println("hahah ");
        String response = new String(recvPacket.getData(),0, recvPacket.getLength(), "UTF-8");

        System.out.println("已收到：" + response);

        clientSocket.close();
    }
}

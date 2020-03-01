package tcp.threads;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.*;

//线程池
public class Server {
    public static class TalkRunnable implements Runnable {
        private Socket clientSocket;

        public TalkRunnable(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
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
                while (true) {
                    String line = br.readLine();
                    System.out.println("好友说：" + line);
                    System.out.println("请回复>");
                    String response = "收到" + System.currentTimeMillis();
                    ps.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        ExecutorService pool = new ThreadPoolExecutor(
                100,
                100,
                0,
                TimeUnit.MILLISECONDS,
                queue
        );
        Scanner sc = new Scanner(System.in);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            pool.execute(new TalkRunnable(clientSocket));
        }
    }
}

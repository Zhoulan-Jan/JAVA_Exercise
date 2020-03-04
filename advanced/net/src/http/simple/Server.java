package http.simple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static class Task implements Runnable {
        public Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                //获取客户端的输入流
                InputStream is = socket.getInputStream();
                //获取输出流
                OutputStream os = socket.getOutputStream();
                //1.读取并解析请求 了解客人的请求
                Request request = Request.parse(is);
                System.out.println(request);
//                if (request.path.equalsIgnoreCase("/")) {
//                    String body = "<h1>hello world!</h1>";
//                    byte[] bodyBytes = body.getBytes("UTF-8");
//                    StringBuffer response = new StringBuffer();
//                    response.append("HTTP/1.1 200 OK\r\n");
//                    response.append("Content-Type: text/html; charset=UTF-8\r\n");
//                    response.append("Content-Length:"); //响应体长度
//                    response.append(bodyBytes.length);
//                    response.append("\r\n");
//                    response.append("\r\n");
//
//                    os.write(response.toString().getBytes("UTF-8"));
//                    os.write(bodyBytes);
//                    os.flush();
//                } else if (request.path.equalsIgnoreCase("/move")){
//                    StringBuffer response = new StringBuffer();
//                    response.append("HTTP/1.1 307 Temporary Redirect\r\n");
//                    response.append("Location: /\r\n");
//
//                    os.write(response.toString().getBytes("UTF-8"));
//                    os.flush();
//                } else {
//                    StringBuffer response = new StringBuffer();
//                    response.append("HTTP/1.1 404 NOT FOUND\r\n");
//                    response.append("\r\n");
//
//                    os.write(response.toString().getBytes("UTF-8"));
//                    os.flush();
//                }
//            //2.处理业务 处理客人请求
//            String body = "<h1> hello world! </h1>";
//            //3.拼接响应 说让客人能理解的话
//            Response response = Response.build(os);
//            //4.发送响应 把话说出去
//            response.println(body);
//            response.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //创建一个监听Socket
        ServerSocket serverSocket = new ServerSocket(80);
        //创建线程池，相当于一个只有 10 人的公司
        ExecutorService pool = Executors.newFixedThreadPool(10);

        //不断地接待客人
        while (true) {
            //等待客人到达，若有客人到达，返回一个 socket
            Socket socket = serverSocket.accept();
            //主线程负责前台任务
            //对接客户全部交给工作线程处理
            pool.execute(new Task(socket));
        }
    }
}

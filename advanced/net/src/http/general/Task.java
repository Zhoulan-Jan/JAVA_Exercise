package http.general;


import java.io.IOException;
import java.net.Socket;

public class Task implements Runnable {
    public Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1.读取并解析请求
            Request request = Request.parse(socket.getInputStream());
            System.out.println(request);
            Response response = new Response();

            //2.处理业务
            Servlet servlet = null;
            if (request.path.equals("/")) {
                servlet = new MainServlet();
            } else if (request.path.equals("/js")) {
                servlet = new JSServlet();
            } else if (request.path.equals("/move")) {
                servlet = new TmpRedirect();
            } else if (request.path.equals("/login")) {
                servlet = new LoginServlet();
            }
            else {
                servlet = new NotFoundServlet();
            }
            servlet.doGet(request, response);

            //3.组装并发送响应
            response.build(socket.getOutputStream());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

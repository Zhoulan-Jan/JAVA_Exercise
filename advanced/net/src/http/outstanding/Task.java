package http.outstanding;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Task implements Runnable {
    public Socket socket;
    public Map<String, Servlet> urlMap = new HashMap<>();

    public Servlet notFoundServlet = new NotFoundServlet();
    public Servlet staticServlet = new StaticServlet();

    public Task(Socket socket) {
        this.socket = socket;
        urlMap.put("/", new MainServlet());
        urlMap.put("/login", new LoginServlet());
        urlMap.put("/hello", new HelloServlet());
    }

    @Override
    public void run() {
        try {
            Request request = Request.parse(socket.getInputStream());
            System.out.println(request);
            Response response = new Response();

            //先在 map 中找，如果没有则在 file 中找，如果没有则返回404
            Servlet servlet = urlMap.get(request.path);
            if (servlet == null) {
                String filename = "docBase" + request.path;
                File file = new File(filename);
                if (file.exists()) {
                    servlet = staticServlet;
                } else {
                    servlet = notFoundServlet;
                }
            }

            servlet.doGet(request, response);
            response.write(socket.getOutputStream());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

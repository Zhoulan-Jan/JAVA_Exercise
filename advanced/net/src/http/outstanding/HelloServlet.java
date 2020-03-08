package http.outstanding;

public class HelloServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) {
        response.setHeaders("Content-Type", "text/plain;charset=utf-8");
        response.setBody("<h1> 这是个人界面 </h1>");
    }
}

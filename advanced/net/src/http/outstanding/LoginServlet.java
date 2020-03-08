package http.outstanding;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) {
        response.setBody("<h1> 这是登录界面 </h1>");
    }
}

package http.outstanding;

public class MainServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) {
        response.setBody("<h1> 这是主界面 </h1>");
        response.setBody("<p> 王俊凯好帅 </p>");
    }
}

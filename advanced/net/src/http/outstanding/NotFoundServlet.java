package http.outstanding;

public class NotFoundServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) {
        response.setStatus("404 NOT FOUND");
        response.setBody("<h1> 无此页面 </h1>");
    }
}

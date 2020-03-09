package http.acceptable;

public class JSServlet extends Servlet{
    @Override
    void doGet(Request req, Response resp) {
        resp.setStatus("200 OK");
        resp.setHeaders("Content-Type", "application/javascript;charset=UTF-8");
        resp.println("alert('great');");
    }
}

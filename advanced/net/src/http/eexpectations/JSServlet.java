package http.eexpectations;

public class JSServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "application/javascript;charset=utf-8");
        resp.println("alert('sheep');");
    }
}

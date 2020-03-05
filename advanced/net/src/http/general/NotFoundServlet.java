package http.general;

public class NotFoundServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("404 NOT FOUND");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.println("<h1> 该页面不存在 </h1>");
    }
}

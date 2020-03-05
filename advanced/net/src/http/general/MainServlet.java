package http.general;

public class MainServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.println("<h1> hello world </h1>");
        resp.println("<p> 王俊凯最帅 </p>");
    }
}

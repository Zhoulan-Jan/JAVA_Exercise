package http.general;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) {
        //resp.setStatus("");
        String username = (req.parameter.get("user"));
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        if (username == null) {
            resp.setStatus("401 Unauthorized");
            resp.println("<h1> 请登录 <h1>");
            return;
        }

        resp.setHeader("Set-Cookie", "username="+username);
        resp.println("<h1> 欢迎 " + username + " 光临</h1>");
    }
}

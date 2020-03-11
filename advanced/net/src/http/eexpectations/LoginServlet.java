package http.eexpectations;

import java.io.IOException;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        //不带Session
//        String user = (req.parameter.get("user"));
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
//        if (user == null) {
//            resp.setStatus("401 Unauthorized");
//            resp.println("<h1> 请登录 <h1>");
//            return;
//        }
//
//        resp.setStatus("200 OK");
//        resp.setHeader("Set-Cookie", "user="+user+"; expires=Tue,07-Apr-2020 08:46:16 GMT； Max-Age=8640000");
//        resp.println("<h1> 欢迎 " + user + " 光临</h1>");

        //带有Session
        String username = req.parameter.get("user");
        if (username == null) {
            resp.setStatus("401 Unauthorized");
            resp.setHeader("Content-Type", "text/html;charset=utf-8");
            resp.println("<h1> 请登录 <h1>");
            return;
        }
        User user = User.fineUser(username);
        if (user == null) {
            resp.setStatus("401 Unauthorized");
            resp.setHeader("Content-Type", "text/html;charset=utf-8");
            resp.println("<h1> 该用户不存在 <h1>");
            return;
        }
        String sessionId = SessionServer.put(user);

        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.setHeader("Set-Cookie", "user="+sessionId+"; expires=Tue,07-Apr-2020 08:46:16 GMT； Max-Age=8640000");
        resp.println("<h1> 欢迎 " + username + " 光临</h1>");
    }
}

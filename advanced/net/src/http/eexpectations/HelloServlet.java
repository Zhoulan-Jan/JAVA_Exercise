package http.eexpectations;

import java.io.IOException;

public class HelloServlet extends Servlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("X-Teacher", "peixin");
        resp.setHeader("X-Room", "201");

        //不带Session
//        String user = "未登录";
//        String cookie = req.header.get("Cookie");
//        if (cookie != null) { //cookie存的内容是 user=dn
//            user = cookie.split("=")[1];
//        }
//        resp.println("你好" + req.parameter.get("target"));
//        resp.println("当前用户是：" + user);

        //带有Session
        String sessionId = null;
        String cookie = req.header.get("Cookie");
        if (cookie != null) {
            sessionId = cookie.split("=")[1];
        }
        User user = SessionServer.get(sessionId);
        if (user == null) {
            resp.setStatus("401 Unauthorized");
            resp.setHeader("Content-Type", "text/html;charset=utf-8");
            resp.println("<h1> 该用户不存在 <h1>");
            return;
        }
        resp.println("hello " + user.name);
        resp.println("Your account has " + user.balance);
    }
}

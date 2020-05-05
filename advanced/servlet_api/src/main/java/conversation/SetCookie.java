package conversation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-cookie")
public class SetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
//        //方式一：手动种
//        resp.setHeader("Set-Cookie", "name=x");
//        resp.setHeader("Set-Cookie", "age=18");
//        resp.setHeader("Set-Cookie", "name=y; age=18");
//        resp.getWriter().println("<h3> 手动种cookie </h3>"); //只显示了最后一个的cookie，以及分号后面的内容没有显示

        //方式二
        Cookie namex = new Cookie("namex", req.getParameter("name"));
        resp.addCookie(namex);
        Cookie age = new Cookie("age", req.getParameter("age"));
        resp.addCookie(age);
        Cookie namey = new Cookie("namey", req.getParameter("namey"));
        resp.addCookie(namey);
        resp.getWriter().println("<h3> 法二 </h3>");

    }
}

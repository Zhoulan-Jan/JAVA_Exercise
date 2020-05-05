package conversation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-cookie")
public class GetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/txt;charset=utf-8");

//        //方式一：
//        String cookie = req.getHeader("Cookie");
//        resp.getWriter().println("从请求的请求体获得cookie值："+ cookie );

        //方式二
        Cookie[] cookies =  req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            resp.getWriter().println("cookie 名称：" + cookie.getName());
            resp.getWriter().println("cookie 值：" + cookie.getValue());
        }
    }
}

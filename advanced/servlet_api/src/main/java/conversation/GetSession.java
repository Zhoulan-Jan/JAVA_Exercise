package conversation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/get-session")
public class GetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("session");

        HttpSession session = req.getSession();
        String now = (String) session.getAttribute("now");
        String name = (String) session.getAttribute("name");

        resp.getWriter().println("<h3> now = " + now + " name = " + name + " </h3>");
    }
}

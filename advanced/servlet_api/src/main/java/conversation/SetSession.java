package conversation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/set-session")
public class SetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String now = format.format(date);

        String name = "xxx";

        HttpSession session = req.getSession();
        session.setAttribute("now", now);
        session.setAttribute("name", name);

        resp.getWriter().println("<h3> session 写入成功 </h3>");
    }
}

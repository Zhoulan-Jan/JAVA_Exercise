package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Project;
import dao.ProjectDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllRankServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        String date = req.getParameter("date");
        if (date == null || date.equals("")) {
            resp.setStatus(404);
            resp.getWriter().write("date 参数错误");
            return;
        }
        ProjectDao projectDao = new ProjectDao();
        List<Project> projects = projectDao.selectProjectByDate(date); //date不要加双引号啊

//        List<Project> projects2 = projectDao.selectProjectByDate("20200401");
//        resp.getWriter().write(String.valueOf(projects2)); //对的

//        List<Project> projects3 = new ArrayList<>();
//        projects3.add(new Project("hello"));
//        resp.getWriter().write(String.valueOf(projects3)); //对的

        String  respStr = gson.toJson(projects);
        resp.getWriter().write(respStr);
    }
}

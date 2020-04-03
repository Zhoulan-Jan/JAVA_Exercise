package api;

import searcher.Result;
import searcher.Searcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DocSearcherServlet extends HttpServlet {
    private Searcher searcher = new Searcher();

    public DocSearcherServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        resp.setContentType("application/json; character=utf-8");
        String query = req.getParameter("query");
        List<Result> results = searcher.search(query);

    }
}

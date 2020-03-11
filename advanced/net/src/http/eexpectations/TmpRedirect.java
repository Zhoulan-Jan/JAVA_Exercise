package http.eexpectations;

public class TmpRedirect extends Servlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("307 Temporary Redirect");
        resp.setHeader("Location", "https://www.qq.com/");
    }
}

package http.simple;

public abstract class Servlet {
    abstract void doGet(Request req, Response resp);
}

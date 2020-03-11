package http.eexpectations;

import java.io.IOException;

public abstract class Servlet {
    public abstract void doGet(Request req, Response resp) throws IOException;
}

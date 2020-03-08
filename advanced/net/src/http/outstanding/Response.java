package http.outstanding;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private String version = "HTTP/1.0 ";
    private String status = "200 OK";
    Map<String, String> headers = new HashMap<>();
    StringBuffer body = new StringBuffer();

    public Response() {
        headers.put("Content-Type", "text/html;charset=utf-8"); //可重置
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeaders(String key, String value) {
        headers.put(key, value);
    }

    public void write(OutputStream os) throws IOException {
        StringBuffer response = new StringBuffer();
        response.append(version);
        response.append(status);

        int contentLen = body.toString().getBytes("UTF-8").length;
        headers.put("Content-Length", String.valueOf(contentLen));
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            response.append(entry.getKey());
            response.append(":");
            response.append(entry.getValue());
            response.append("\r\n");
        }

        response.append("\r\n");
        response.append(body);
        os.write(response.toString().getBytes("UTF-8"));
        os.flush();
    }

    public void setBody(String s) {
        body.append(s);
        body.append("\r\n");
    }

}

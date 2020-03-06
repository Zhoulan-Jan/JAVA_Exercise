package http.general;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
    public String version = "HTTP/1.1 ";
    public String status;
    Map<String, String> header = new HashMap<>();
    StringBuffer body = new StringBuffer();

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeader(String key, String value) {
        this.header.put(key, value);
    }

    //拼接并输出响应
    public void build(OutputStream os) throws IOException {
        StringBuffer response = new StringBuffer();
        response.append(version);
        response.append(status);
        response.append("\r\n");

        int contentLen = body.toString().getBytes("UTF-8").length;
        header.put("Content-Length", String.valueOf(contentLen));
        for (Map.Entry<String, String> entry : header.entrySet()) {
            response.append(entry.getKey());
            response.append(":");
            response.append(entry.getValue());
            response.append("\r\n");
        }

        response.append("\r\n");

        response.append(body.toString());

        os.write(response.toString().getBytes("UTF-8"));
        os.flush();
    }

    public void println(String s) {
        body.append(s);
        body.append("\r\n");
    }
}

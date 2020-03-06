package http.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
    //版本号
    public String version = "HTTP/1.1 ";

    //状态 200 OK
    public String status;

    //响应报头
    Map<String, String> headers = new HashMap<>();

    //响应正文
    StringBuffer body = new StringBuffer();

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeaders(String key, String value) {
        this.headers.put(key, value);
    }

    //组装（拼接）响应 写到 os
    public void build(OutputStream os) throws IOException {
        //Response response = new Response();
        StringBuffer responseBuild = new StringBuffer();
        //组装状态
        responseBuild.append(version);
        responseBuild.append(status);
        responseBuild.append("\r\n");
        //组装响应头
        if (body.length() != 0) {
            int contentLen = body.toString().getBytes("UTF-8").length;
            setHeaders("Content-Length", String.valueOf(contentLen));
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            responseBuild.append(entry.getKey());
            responseBuild.append(":");
            responseBuild.append(entry.getValue());
            responseBuild.append("\r\n");
        }
        //responseBuild.append("Content-Length:"); 上面一大段可以用这两个代替吗
        //responseBuild.append(String.valueOf(cotentLen));
        //空行
        responseBuild.append("\r\n");
        //组装响应正文
        responseBuild.append(body);

        os.write(responseBuild.toString().getBytes("UTF-8"));
        os.flush();
    }

    public void println(String s) {
        body.append(s);
        body.append("\r\n");
    }

    public void flush() {

    }
}

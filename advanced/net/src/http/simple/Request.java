package http.simple;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    //请求方法
    public String method;

    //请求路径
    public String path;

    //请求版本
    public String version;

    //请求头
    Map<String, String> header = new HashMap<>();

    //请求正文（忽略）


    public static Request parse(InputStream is) {
        Request request = new Request();
        Scanner sc = new Scanner(is, "UTF-8");
        //解析请求行
        parseRequestLine(request, sc.nextLine());
        //解析请求头
        String line;
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0];
            String value = kv[1];
            request.header.put(key, value);
        }
        //解析正文（略）
        return request;
    }

    public static void parseRequestLine(Request request, String s) {
        String[] group = s.split(" ");
        request.method = group[0];
        request.path = group[1];
        request.version = group[2];
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", header=" + header +
                '}';
    }
}

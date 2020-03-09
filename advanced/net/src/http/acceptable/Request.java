package http.acceptable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    //请求方法
    public String method;

    //URL：/c%2B%2B?name=hello
    //path = c++; parameter = {name = hello}
    //请求路径
    public String path;
    //请求参数
    Map<String, String> parameter = new HashMap<>();

    //请求版本
    public String version;

    //请求头
    Map<String, String> header = new HashMap<>();

    //请求正文（忽略）


    public static Request parse(InputStream is) throws IOException {
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

    //详细解析请求行
    public static void parseRequestLine(Request request, String s) throws IOException {
        String[] group = s.split(" ");
        request.method = group[0];
        //从 group[1] 分离出路径和查询字符串
        String[] group2 = group[1].split("\\?");
        request.path = group2[0];
        if (group2.length != 1) {
            String[] group3 = group2[1].split("&");
            for (String kvStr : group3) {
                String[] group4 = kvStr.split("=");
                String key = URLDecoder.decode(group4[0], "UTF-8");
                String value = "";
                if (group4.length != 1) {
                    value = URLDecoder.decode(group4[1], "UTF-8");
                }
                request.parameter.put(key, value);
            }
        }
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

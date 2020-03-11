package http.eexpectations;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    public String method;
    public String path;
    Map<String, String> parameter = new HashMap<>();
    public String version;
    Map<String, String> header = new HashMap<>();

    //解析请求
    public static Request parse(InputStream is) throws IOException{
        Request request = new Request();
        Scanner sc = new Scanner(is, "UTF-8");
        //解析请求行
        parseRequestLine(request, sc.nextLine());
        //解析请求报头
        parseRequestHead(request, sc);
        return request;
    }

    //解析请求行
    private static void parseRequestLine(Request request, String s) throws IOException {
        String[] group = s.split(" ");
        request.method = group[0];
        String[] team = group[1].split("\\?");
        request.path = team[0];
        if (team.length != 1) {
            String[] crew = team[1].split("&");
            for (String kvs : crew) {
                String[] kv = kvs.split("=");
                String key = URLDecoder.decode(kv[0], "UTF-8") ;
                String value ="";
                if (kv.length != 1) {
                    value = URLDecoder.decode(kv[1], "UTF-8");
                }
                request.parameter.put(key, value);
            }
        }
        request.version = group[2];
    }

    //解析请求报头
    private static void parseRequestHead(Request request, Scanner sc) {
        String line;
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] group = line.split(":");
            String key = group[0];
            String value = group[1];
            request.header.put(key, value);
        }
    }




    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", parameter=" + parameter +
                ", version='" + version + '\'' +
                ", header=" + header +
                '}';
    }
}

package http.outstanding;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    public String method;
    public String path;
    Map<String, String> parameter = new HashMap<>();
    public String version = "HTTP/1.1";
    Map<String, String> headers = new HashMap<>();

    public static Request parse(InputStream is) {
        Request request = new Request();
        Scanner sc = new Scanner(is, "UTF-8");
        parseRequestLine(request, sc.nextLine());
        parseRequestHeader(request, sc);
        return request;
    }

    private static void parseRequestLine(Request request, String s) {
        String[] group = s.split(" ");
        request.method = group[0];

        String[] team = group[1].split("\\?");
        request.path = team[0];
        if (team.length != 1) {
            String[] crew = team[1].split("&");
            for (String kvs : crew) {
                String[] kv = kvs.split("=");
                String key = kv[0].trim();
                String value = "";
                if (kv.length != 1) {
                    value = kv[1].trim();
                }
                request.parameter.put(key, value);
            }
        }
        request.version = group[2];
    }

    private static void parseRequestHeader(Request request, Scanner sc) {
        String line;
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] group = line.split(":");
            String key = group[0];
            String value = group[1];
            request.headers.put(key, value);
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", parameter=" + parameter +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }
}



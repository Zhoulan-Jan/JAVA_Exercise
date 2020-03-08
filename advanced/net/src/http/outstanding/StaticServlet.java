package http.outstanding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class StaticServlet extends Servlet{
    @Override
    public void doGet(Request request, Response response) {
        //1.根据 url 找到本地文件
        String filename = "docBase" + request.path;
        //2.读取文件并写入 response
        try {
            InputStream is = new FileInputStream(filename);
            Scanner sc = new Scanner(is, "UTF-8");
//            String line;  //这个写法是错误的
//            while (!(line = sc.nextLine()).isEmpty()) {
//                response.setBody(line);
//            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                response.setBody(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

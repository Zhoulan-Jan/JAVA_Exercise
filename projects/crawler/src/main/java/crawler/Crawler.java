package crawler;

import dao.Project;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Crawler {
    private HashSet<String> urlBlackList = new HashSet<>();
    private OkHttpClient okHttpClient = new OkHttpClient();

    {
        urlBlackList.add("https://github.com/events");
        urlBlackList.add("https://github.com/site/terms");
        urlBlackList.add("https://github.com/site/privacy");
        urlBlackList.add("https://github.com/security");
        urlBlackList.add("https://github.com/contact");
        urlBlackList.add("https://github.com/pricing");
        urlBlackList.add("https://github.com/about");
        urlBlackList.add("https://github.community");
    }

    public static void main(String[] args) throws IOException {
        Crawler crawler = new Crawler();
        String respBody = crawler.getPage("https://github.com/akullpp/awesome-java/blob/master/README.md");
        //System.out.println(respBody);
        List<Project> projects = crawler.parseProjectList(respBody);
        System.out.println(projects);
    }

    //通过 OkHttp 这个库获取到 HTML 形式的页面内容
    public String getPage(String url) throws IOException{
        //1.创建 Client 对象
        // OkHttpClient 只要一个程序包含一个实例即可
        //2.创建一个 Request 对象 （new、某个静态的工厂方法）
        Request request = new Request.Builder().url(url).build();
        //3.创建一个 Call 对象 （负责进行一次网络访问操作）
        Call call = okHttpClient.newCall(request);
        //4.发送请求给服务器，获取到 Response 对象
        Response response = call.execute();
        //5.判定响应是否成功
        if (!response.isSuccessful()) {
            System.out.println("请求失败！");
            return null;
        }
        return response.body().string();
    }

    //使用 Jsoup 分析页面结构，得到项目的 name、url、description
    public List<Project> parseProjectList(String html) {
        List<Project> res = new ArrayList<>();
        //1.创建 Document 对象（相当于一个树形结构）：把 html 字符串转换成 Document 对象
        Document document = Jsoup.parse(html);
        //2.使用 getElementByTag 方法获取到所有的 li 标签
        //  elements 相当于一个集合类，包含很多 Element 对象
        Elements elements = document.getElementsByTag("li");
        for (Element li : elements) {
            //3.再获取里面的 a 标签
            Elements allLink = li.getElementsByTag("a");
            //若不存在 a 标签，则抛弃该 li 标签
            if (allLink.size() == 0) {
                continue;
            }
            //得到第一个 a 标签
            Element link = allLink.get(0);
//            //输出 a 标签的内容 即项目名字
//            System.out.println(link.text());
//            //输出 a 标签的链接 即项目链接
//            System.out.println(link.attr("href"));
//            //输出 li 标签的内容 即项目描述
//            System.out.println(li.text());
//            System.out.println("================");
            //如果这个项目的 url 不是以https://github.com 开头，则抛弃
            String url = link.attr("href");
            if (!url.startsWith("https://github.com")) {
                continue;
            }
            if (urlBlackList.contains(url)) {
                continue;
            }
            Project project = new Project();
            project.setName(link.text());
            project.setUrl(link.attr("href"));
            project.setDescription(li.text());
            res.add(project);
        }
        return res;
    }

    //调用 GitHub API 获取指定的仓库信息
    //repoName 形如 doov-io/doov
    public String getRepoInfo(String repoName) throws IOException {
        String userName = "Zhoulan-Jan";
        String passwd = "Nina752426";
        //进行身份认证，将用户名密码加密（base64）之后，得到字符串，把这个字符串放到 HTTP header 中
        String credent = Credentials.basic(userName, passwd);
        String url = "https://api.github.com/repos" + repoName;
        //okHttpClient 对象前面已创建， 请求对象、Call对象、响应对象需要重新创建
        Request request = new Request.Builder().url(url).header("Authorization", credent).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (!response.isSuccessful()) {
            System.out.println("访问 GitHub API 失败， url = " + url);
            return null;
        }
        return response.body().string();
    }

    public String getRepoName(String    )
}

package crawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.Project;
import dao.ProjectDao;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Crawler {
    private HashSet<String> urlBlackList = new HashSet<>();
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Gson gson = new GsonBuilder().create();

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
        long startTime = System.currentTimeMillis();

        //1.获取入口页面
        Crawler crawler = new Crawler();
        String respBody = crawler.getPage("https://github.com/akullpp/awesome-java/blob/master/README.md");
        //System.out.println(respBody);

        long finishTime = System.currentTimeMillis();
        System.out.println("获取入口页面时间：" + (finishTime - startTime) + " ms");

        //2.解析入口页面，获取项目列表
        List<Project> projects = crawler.parseProjectList(respBody);
        //System.out.println(projects);

        System.out.println("获取项目列表时间：" + (System.currentTimeMillis() - finishTime) + " ms");
        finishTime = System.currentTimeMillis();

        //3.遍历项目列表，调用 GitHub api 获取项目信息
        ProjectDao projectDao = new ProjectDao();
        for (int i = 0; i < projects.size(); i++) {
            try {
                Project project = projects.get(i);
                System.out.println("crawling... " + project.getName()+ " ...");
                String repoName = crawler.getRepoName(project.getUrl());
                String jsonStr = crawler.getRepoInfo(repoName);
                //System.out.println(jsonStr);

                //4.解析 JSON 数据，得到 star 等信息
                crawler.parseRepoInfo(jsonStr, project);
                System.out.println("crawling "+ project.getName() + " done~");
//            System.out.println(project);
//            System.out.println("===================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("获取项目信息：" + (System.currentTimeMillis() - finishTime) + " ms");
        finishTime = System.currentTimeMillis();

        //5.把 project 保存到数据库中
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            projectDao.save(project);
        }

        System.out.println("保存到数据库时间：" + (System.currentTimeMillis() - finishTime) + " ms");
        finishTime = System.currentTimeMillis();
        System.out.println("总时间：" + (finishTime - startTime) + " ms");
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

    //从一个 url 提取出仓库名和作者名
    //https://github.com/repos/doov-io/doov => doov-io/doov
    //特殊情况 ： https://github.com/networknt/light-4j/
    //https://github.com/codenameone/CodenameOne/tree/master/vm  等
    public String getRepoName(String url) {
        int lastOne = url.lastIndexOf("/");
        int lastTwo = url.lastIndexOf("/", lastOne - 1);
        if (lastOne == -1 || lastTwo == -1) {
            System.out.println("当前的 url 不是一个标准的项目 url： " + url);
            return null;
        }
        return url.substring(lastTwo + 1);
    }

    //调用 GitHub API 获取指定的仓库信息
    //repoName 形如 doov-io/doov
    public String getRepoInfo(String repoName) throws IOException {
        String userName = "Zhoulan-Jan";
        String passwd = "Nina752426";
        //进行身份认证，将用户名密码加密（base64）之后，得到字符串，把这个字符串放到 HTTP header 中
        String credential = Credentials.basic(userName, passwd);
        String url = "https://api.github.com/repos/" + repoName;
        //okHttpClient 对象前面已创建， 请求对象、Call对象、响应对象需要重新创建
        Request request = new Request.Builder().url(url).header("Authorization", credential).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (!response.isSuccessful()) {
            System.out.println("访问 GitHub API 失败， url = " + url);
            return null;
        }
        return response.body().string();
    }

    //解析仓库的相关信息，并保存到 project 对象中
    public void parseRepoInfo(String jsonStr, Project project) {
        //把 JSON 数据转为 键值对 数据
        //借助 TypeToken 这个类获取到 HashMap 所对应的类对象
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> map = gson.fromJson(jsonStr, type);
        Double starCnt = (Double) map.get("stargazers_count");
        project.setStarCnt(starCnt.intValue());
        Double forkCnt = (Double)map.get("forks_count");
        project.setForkCnt(forkCnt.intValue());
        Double issuesCnt = (Double)map.get("open_issues_count");
        project.setIssuesCnt(issuesCnt.intValue());
    }

}

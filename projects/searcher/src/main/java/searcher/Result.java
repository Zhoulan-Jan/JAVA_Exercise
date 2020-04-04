package searcher;

//表示一条搜索结果，根据 DocInfo
public class Result {
    private String title;
    private String showUrl;
    private String clickUrl; //实际浏览器中，点击URL 会把请求打到搜狗服务器上，服务器会重定向到展示URL
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Result{" +
                "title='" + title + '\'' +
                ", showUrl='" + showUrl + '\'' +
                ", clickUrl='" + clickUrl + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

package dao;

//描述一个项目
public class Project {
    private String name; //名字，对应 a 标签内容
    private String url; //链接，对应 a 标签的 href 内容
    private String description; //描述，对应 li 标签内容

    private int starCnt;
    private int forkCnt;
    private int issuesCnt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarCnt() {
        return starCnt;
    }

    public void setStarCnt(int starCnt) {
        this.starCnt = starCnt;
    }

    public int getForkCnt() {
        return forkCnt;
    }

    public void setForkCnt(int forkCnt) {
        this.forkCnt = forkCnt;
    }

    public int getIssuesCnt() {
        return issuesCnt;
    }

    public void setIssuesCnt(int issuesCnt) {
        this.issuesCnt = issuesCnt;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", starCnt=" + starCnt +
                ", forkCnt=" + forkCnt +
                ", issueCnt=" + issuesCnt  +
                '}';
    }
}

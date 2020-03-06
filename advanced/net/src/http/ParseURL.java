package http;

public class ParseURL {
    public static void main(String[] args) {
        String url = "https://www.baidu.com/s?cl=3&tn=baidutop10&fr=top1000&";
        String[] marks = {"://", "/", "?", "#"};
        String[] des = {"协议名", "主机名", "资源路径", "查询字符串", "片段标识符"};
        int startIdx = 0;
        for (int i = 0; i < marks.length; i++) {
            if (url.substring(startIdx).contains(marks[i])) {
                int endIdx = url.substring(startIdx).indexOf(marks[i])+startIdx; //url.substring(startIdx).indexOf(marks[i])
                                                                                 // 得到的值是子串下标
                System.out.println(des[i] + " " + url.substring(startIdx, endIdx));
                startIdx = endIdx + marks[i].length();
            } else {
                System.out.println("wu");
            }
        }
    }

}

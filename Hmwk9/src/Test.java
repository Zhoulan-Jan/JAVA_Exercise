import java.security.spec.RSAOtherPrimeInfo;

public class Test {
    public static void main(String[] args) {
        String idNum = "331082199201025877";
        printInfo(idNum);
    }

    //根据一个人的身份证号，输出xxxx年x月x日，是个x生
    public static void printInfo (String num) {
        String year = num.substring(6,10);
        int month = (num.charAt(10)-'0') * 10 + num.charAt(11)-'0';
        int day = (num.charAt(12)-'0') * 10 + num.charAt(13)-'0';
        int sexNum = (num.charAt(16)-'0') % 2;
        String sex;
        if (sexNum == 0) {
            sex = "女";
        } else {
            sex = "男";
        }
        System.out.println("此人是 " + year +" 年 " + month + " 月 " + day
        + " 日 "+ ", 是个" + sex + "生 ");
    }
}

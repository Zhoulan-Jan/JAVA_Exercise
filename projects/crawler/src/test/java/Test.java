import crawler.Crawler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Test {
    public static void main(String[] args) {
//        Crawler crawler = new Crawler();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String res = simpleDateFormat.format(new Date().getTime());
        String res2 = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(res);
        System.out.println(res2);
    }

}

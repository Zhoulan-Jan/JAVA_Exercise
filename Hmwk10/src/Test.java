import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //test
//        FileReader fileReader = new FileReader("reader.txt");
//        int len = 0;
//        while ( (len = fileReader.read()) != -1) {
//            System.out.print((char)len);
//        }
//        fileReader.close();
        System.out.println("根据出版社名称查找书籍数量和总价格:");
        int[] ans1 = findNumAndPriceOnPublisher("上海译文出版社");
        System.out.println("书籍的数量为：" + ans1[0]);
        System.out.println("书籍的总价格为：" + ans1[1]);

        System.out.println("根据ISBN查找书名、作者、出版社:");
        String[] ans2 = findTitleAndAutrAndPubOnISBN("438-1-256-55547-9");
        System.out.println("书名为：" + ans2[0]);
        System.out.println("作者为：" + ans2[1]);
        System.out.println("出版社为：" + ans2[2]);

        System.out.println("统计页码值不少于某个值的书籍数量:");
        int ans3 = num(550);
        System.out.println("大于指定页数的书籍数量有：" + ans3);
    }

    //根据出版社名称查找书籍数量和总价格
    public static int[] findNumAndPriceOnPublisher(String publisher) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("reader.txt"));
        int[] ans = new int[2]; //ans[0]记录书籍数量；ans[1]记录总价格
        String str = null;
        while ((str = rd.readLine()) != null) {  //每次读取一行
            String[] res = str.split(" ");
            if (res[3].equals(publisher)) {
                ans[0]++;
                ans[1] += Integer.parseInt(res[4]); //字符串变成int
            }
        }
        rd.close();
        return ans;
    }

    //根据ISBN查找书名、作者、出版社
    public static String[] findTitleAndAutrAndPubOnISBN(String ISBN) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("reader.txt"));
        String[] ans = new String[3];
        String str = null;
        while ((str = rd.readLine()) != null) {  //每次读取一行
            String[] res = str.split(" ");
            if (res[1].equals(ISBN)) {
                ans[0] = res[0];
                ans[1] = res[2];
                ans[2] = res[3];
            }
        }
        rd.close();
        return ans;
    }

    //统计页码值不少于某个值的书籍数量
    public static int num(int page) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("reader.txt"));
        int ans = 0;
        String str = null;
        while ((str = rd.readLine()) != null) {
            String[] res = str.split(" ");
            if (Integer.parseInt(res[5]) >= page) {
                ans++;
            }
        }
        return ans;
    }
}

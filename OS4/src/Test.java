import java.util.Arrays;
import java.util.Random;

public class Test {
    int cur = 100; //当前磁头在100号磁道上
    //生成随机数 （0，200）
    //磁盘调度算法 //先向外移动
    public static void scan(int[] arr) {
        int[] b = new int[arr.length];
        int cnt = 0;
        boolean flg = false;
        //找到 > 100的数字 保存递增排序
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 100) {
                b[cnt++] = arr[i];
                flg = true;
            }
        }
        increaseSort(b,0,cnt);
        int left = cnt;
        //找到 < 100的数字 保存递减排序
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 100) {
                b[cnt++] = arr[i];
            }
        }
        decreaseSort(b,left, arr.length);
        System.out.println("磁道请求次序:" + Arrays.toString(b));
        double avg = 0.0;
        if (!flg) {
            //表示磁道序列均小于100  即不存在 > 100的磁道
            avg = (100 - b[arr.length - 1] * 1.0) / arr.length;
        } else {
            avg = (2 * b[left - 1] - 100 - b[arr.length - 1] * 1.0) / arr.length;
        }
        System.out.println("平均寻道长度:" + avg);
    }

    //冒泡排序 递增
    public static void increaseSort(int[] arr, int left, int right) {
        for (int i = left; i < right - 1; i++) {
            for (int j = left; j < right - i - 1; j++) {
                if (arr[j+1] < arr[j]) {
                    int t = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    //冒泡排序 递减
    public static void decreaseSort(int[] arr, int left, int right) {
        int len = right - left;
        for (int i = 0; i < len; i++) { //表示比较的次数呀
            for (int j = left; j < right - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int t = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        //生成随机数
        Random ra = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(200);
        }
        System.out.println(Arrays.toString(arr));
        scan(arr);
//        int[] arr0 = {55,58,39,18,90,160,150,38,184};
//        int[] arr1 = {195,165,155,102,136,145,188,120};
//        int[] arr2 = {98,15,23,35,45,55,77,20,66};
//        scan(arr0);
//        scan(arr1);
//        scan(arr2);
    }
}

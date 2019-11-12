import java.util.Arrays;

public class Sort {

    //插入排序
    public static void insertSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (arr[bound] < arr[cur]) {
                    arr[cur + 1] = arr[cur];
                } else {
                    break;
                }
            }
            arr[cur + 1] = tmp;
        }
    }

    //希尔排序

    //选择排序
    public static void main(String[] args) {
        int[] array = {4,5,7,9,1,2,10,3,6};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}

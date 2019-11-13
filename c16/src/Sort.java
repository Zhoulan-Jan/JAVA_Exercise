import java.util.Arrays;

public class Sort {

    //插入排序
    public static void insertSort(int[] arr) {
        for (int bound = 1; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (tmp < arr[cur]) {
                    arr[cur + 1] = arr[cur];
                } else {
                    break;
                }
            }
            arr[cur + 1] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            shellSortGap(arr, gap);
            gap /= 2;
        }
        shellSortGap(arr,1);
    }
    public static void shellSortGap(int[] arr, int gap) {
        for (int bound = 0; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (tmp < arr[cur]) {
                    arr[cur + gap] = arr[cur];
                } else {
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            int cur = bound + 1;
            for (; cur < arr.length; cur++) {
                if (arr[bound] > arr[cur]) {
                    swap(arr, bound, cur);
                }
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4,5,7,9,1,2,10,3,6};
        //insertSort(array);
        //shellSort(array);
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}

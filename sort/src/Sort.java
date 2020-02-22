import java.util.Arrays;

public class Sort {
    //选择排序
    //冒泡排序
    //插入排序
    //希尔排序
    //合并排序
    //堆排序
    public static void HeapSort(int[] nums) {

    }
    //快速排序
    public static void QuickSort(int[] nums) {
        QuickSortHelper(0, nums.length - 1, nums);
    }

    private static void QuickSortHelper(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }

        int pivotInx = Partirion(left, right, nums);
        QuickSortHelper(left, pivotInx - 1, nums);
        QuickSortHelper(pivotInx + 1, right, nums);

    }

    //一次快排
    private static int Partirion(int left, int right, int[] nums) {
        int pivote = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivote) {
                right--;
            }
            while (left < right && nums[left] < pivote) {
                left++;
            }
            swap(left, right, nums);
        }
        nums[left] = pivote;
        return left;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,1,4,6,3,7,9,5};
        int[] nums2 = {6,1,2,7,9,3,4,5,10,8};
        QuickSort(nums);
        System.out.println(Arrays.toString(nums));
        QuickSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

}

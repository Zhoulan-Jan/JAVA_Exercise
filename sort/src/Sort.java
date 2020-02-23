import java.util.Arrays;

public class Sort {
    //选择排序
    //冒泡排序
    public static void BubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(j, j+1, nums);
                }
            }
        }
    }
    //插入排序
    public static void InsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > v; j--) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = v;
        }
    }
    //希尔排序
    public static void HillSort(int[] nums) {
        int gap = nums.length;
        while (gap > 1) {
            HillSortHelper(nums, gap);
            gap = gap / 2;
        }
        HillSortHelper(nums, gap);
    }

    private static void HillSortHelper(int[] nums, int gap) {
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            int j = i - gap;
            for (; j >= 0 && nums[j] > v; j--) {
                nums[j+gap] = nums[j];
            }
            nums[j+gap] = v;
        }
    }

    //合并排序 错误的
    public static void MergeSort(int[] nums) {
        MergeSortHelper(0, nums.length - 1, nums);
    }

    private static void MergeSortHelper(int low, int high, int[] nums) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        MergeSortHelper(low, mid, nums);
        MergeSortHelper(mid + 1, high, nums);
        merge(low, mid, high, nums);
    }

    //合并
    private static void merge(int low, int mid, int high, int[] nums) {
        int i = low;
        int j = mid;
        int len = high - low;
        int[] extra = new int[len];
        int k = 0;
        while (i < mid && j < high) {
            if (nums[i] <= nums[j]) {
                extra[k++] = nums[i++];
            } else {
                extra[k++] = nums[j++];
            }
        }

        while (i < mid) {
            extra[k++] = nums[i++];
        }
        while (j < high) {
            extra[k++] = nums[j++];
        }

        for (int t = 0; t < len; t++) {
            nums[low+t] = extra[t];
        }
    }
    //堆排序
    public static void HeapSort(int[] nums) {
        createHeap(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            swap(0, nums.length - i - 1, nums);
            shiftDown(nums.length - 1 - i, 0, nums);
        }
    }

    //建堆
    private static void createHeap(int[] nums) {
        for (int i = (nums.length - 1 - 1) /2; i >= 0; i--) {
            shiftDown(nums.length, i, nums);
        }
    }

    //向下调整 (大根堆）
    private static void shiftDown(int size, int index, int[] nums) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && nums[child] < nums[child + 1]) {
                child = child + 1;
            }

            if (nums[parent] < nums[child]) {
                swap(parent, child, nums);
            } else {
                break;
            }

            parent = child;
            child = 2 * parent + 1;
        }
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
//        QuickSort(nums);
//        QuickSort(nums2);
//        HeapSort(nums);
//        HeapSort(nums2);
//        MergeSort(nums);
//        MergeSort(nums2);

//         BubbleSort(nums);
//         BubbleSort(nums2);
//        InsertSort(nums);
//        InsertSort(nums2);
        HillSort(nums);
        HillSort(nums2);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }

}

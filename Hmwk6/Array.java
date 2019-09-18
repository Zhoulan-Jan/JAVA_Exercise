import java.util.Arrays;

public class Array{
    public static void main(String[] args) {
        int[] arr = {5,9,2,16,4,13,8,1};
        //数组转字符串
        String new_strarr1 = my_toString(arr);
        System.out.println("my_toString: " + new_strarr1);
        String new_strarr2 = Arrays.toString(arr);
        System.out.println(new_strarr2);
        //数组拷贝
        int[] new_copyarr1 = my_copyOf (arr);
        System.out.println("my_copyOf: " + Arrays.toString(new_copyarr1));
        int[] new_copyarr2 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(new_copyarr2));
        //找数组中的最大元素
        int mx = max(arr);
        System.out.println("max = " + mx);
        //求数组的平均值
        double avg = average(arr);
        System.out.println("avg = "+ avg);
        //顺序查找
        int toFind = 13;
        int index = SequeSearch(arr,toFind);
        System.out.println("顺序查找该数字的下标："+ index);
        //二分查找
        int toFind2 = 14;
        int index2 = BinarySearch(arr,toFind2);
        System.out.println("二分查找该数字的下标："+ index2);
        //检查有序性
        int[] arr2 = {1,2,3,5,8,9};
        System.out.print(isSorted(arr) + " ");
        System.out.println(isSorted(arr2));
        //冒泡
        // Arrays.sort(arr); //java内置高效的排序算法
        // System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序：" + Arrays.toString(arr));
        //逆序
        revArr(arr);
        System.out.println("数组逆序：" + Arrays.toString(arr));
        //偶前奇后
        transform(arr);
        System.out.println("偶前奇后：" + Arrays.toString(arr));
    }

    //偶前奇后
    public static void transform(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            while (arr[left] % 2 == 0 && left < right) {
                left = left + 1;
            }
            while (arr[right] % 2 != 0 && left < right) {
                right = right - 1;
            }
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
        }
    }

    //逆序
    public static void revArr(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left = left + 1;
            right = right - 1;
        }
    }

    //冒泡
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        //return arr;  //arr已经改变 是的
    }

    //检查有序性
    public static boolean isSorted(int[] arr){
        for (int i = 0;i < arr.length - 1; i++){
            if (arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    //二分查找
    public static int BinarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if (arr[mid] > target ) right = mid - 1;
            else if (arr[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }

    //顺序查找
    public static int SequeSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++){
            if ( target == arr[i]){
                return i;
            }
        }
        return -1;
    }

    //求数组的平均值
    public static double average(int[] arr){
        double avg = 0.0;
        int sum = 0;
        for (int i = 0;i < arr.length; i++){
            sum += arr[i];
        }
        return ((double) sum/(double) arr.length);
    }

    //找数组中的最大元素
    public static int max(int[] arr){
        int mx = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (mx < arr[i]){
                mx = arr[i];
            }
        }
        return mx;
    }

    //数组拷贝 
    public static int[] my_copyOf(int[] arr){
        int[] newArr =  new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    //数组转字符串
    public static String my_toString(int[] arr){
        String ret = "[";  //双引号 //String  S是大写的
        for (int i = 0; i < arr.length; i++){
            ret += arr[i];
            if (i != arr.length - 1){
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
}
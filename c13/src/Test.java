import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = {4,5,23,2,10,9,1,3};
        heap.createHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

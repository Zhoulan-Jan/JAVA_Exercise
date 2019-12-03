import java.util.ArrayList;
import java.util.Arrays;

public class Try {
     int[] nums = {1,5,9,2,7};

    public Try(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,5,2};
        int[] nums2 = {5,6,3,4};
        int[] nums3 = {8,2,6,3};
        ArrayList<Try> trys = new ArrayList<>();
        Try t1 = new Try(nums1);
        Try t2 = new Try(nums2);
        Try t3 = new Try(nums3);
        trys.add(t1);
        trys.add(t2);
        trys.add(t3);
        System.out.println(Arrays.toString(trys.get(0).nums));
        System.out.println(Arrays.toString(trys.get(1).nums));
        System.out.println(Arrays.toString(trys.get(2).nums));
    }
}


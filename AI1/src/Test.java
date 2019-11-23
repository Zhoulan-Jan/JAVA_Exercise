import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] initial = {2, 8, 3, 1, 6, 4, 7, 0, 5}; //初始状态
        int[] destination = {1, 2, 3, 8, 0, 4, 7, 6, 5}; //目的状态
        EightDigital ed = new EightDigital();
        Status parent = new Status();
        ArrayList<Status> child = new ArrayList<>();
        parent.nums = initial;
        parent.init(parent);
        //System.out.println(ed.getZero(parent.nums)); //正确
        int zeroPosition = ed.getZero(parent.nums);

//        System.out.println(ed.isMoveLeft(zeroPosition)); //正确
//        System.out.println(ed.isMoveDown(zeroPosition));
//        System.out.println(ed.isMoveRight(zeroPosition));
//        System.out.println(ed.isMoveUp(zeroPosition));

//        Status tmp = ed.move(parent, 3, zeroPosition); //正确
//        ed.printProcess(tmp.nums);
        child = ed.getChild(parent);
        for (int i = 0; i < child.size(); i++) {
            ed.printProcess(child.get(i).nums); //牵一发而动全身了2 8 3 1 0 4 0 5 0
        }






        //测试
        //int[] arr = {1,9,7,5,2,6};
//        int i =0;
//        for (; i < arr.length; i++) {
//            if (arr[i] != arr[i+1]) {
//                break;
//            }
//        }
//        System.out.println(i);
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                }
//            }
//        }
//        System.out.print(Arrays.toString(arr));

//        ArrayList<Integer> array = new ArrayList<>();
//        array.add(5);
//        array.add(2);
//        array.add(7);
//        array.add(4);
//        array.add(10);
//        System.out.println(array);
//        for (int i = 0; i < array.size() - 1; i++) {
//            for (int j = 0; j < array.size() - i - 1; j++) {
//                if (array.get(j) > array.get(j+1)) {
////                    tmp = array.get(j);
////                    array.get(j) = array.get(j+1); // 无法交换
////                    array.get(j+1) = tmp;
//                    Integer tmp = array.get(j);
//                    array.set(j, array.get(j + 1));
//                    array.set(j+1, tmp);
//                }
//            }
//        }
//        System.out.println(array);
//        int[] nums = arr;
//        System.out.println(Arrays.toString(nums));
    }
}

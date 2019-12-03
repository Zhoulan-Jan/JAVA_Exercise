import java.util.ArrayList;
import java.util.Arrays;

public class EightDigital{
//    int[] initial = {2, 8, 3, 1, 6, 4, 7, 0, 5}; //初始状态
//    int[] destination = {1, 2, 3, 8, 0, 4, 7, 6, 5}; //目的状态

    //EightDigital parent; //当前状态的父状态
    ArrayList<Status> result = new ArrayList<>(); //记录数码移动序列

    ArrayList<Status> open = new ArrayList<>();
    ArrayList<Status> closed = new ArrayList<>();
    //判断是否为目标状态


    //操作 传入open closed parent destination
    //描述不恰当 从父状态得到下一个状态 父状态
    public void operation(ArrayList<Status> open, ArrayList<Status> closed) {
        //对open表排序
        sortOpen(open);
        //从已排好序的open表中取出估价函数值最小（最前面）的状态扩展，（状态可能多个）
        int index = 0;
        for (; index < open.size() ; index++) {
            if (open.get(index).valuation != open.get(index + 1).valuation) {
                break;
            }
        } //循环结束后，index为最后一个的估价函数值较大的状态的下标
        //扩展open表里下标范围为[0,index]的状态 并将得到的子状态插入到open表里
        //
//        for (int i = 0; i <= index; i++) {
//            getChild(open.get(i), open,);
//        }

    }

    //在open表里判断是否有目标状态
//    private boolean isTarget(ArrayList<Status> open) {
//        for (int i = 0; i < open.size(); i++) {
//
//        }
//    }


    //根据一个父状态，得到子态 true
    public void getChild(Status parent, ArrayList<Status> child) {
        //ArrayList<Status> child = new ArrayList<>();
        int[] tmp = parent.nums;
        //找到父状态 0 的位置
        int position = getZero(parent.nums);
        //在允许移动的情况下，根据 0 的位置移动
        if (isMoveUp(position)) { //注意移动之后，parent.nums已经修改了 //怎么改回来啊啊啊 //能够成功修改了 但是存到child表里又发生变化，只有最后一个
            child.add(move(parent, 0, position)); // parent.nums是正确的结果了
        }
        //parent.nums = tmp;
        if (isMoveDown(position)) {
            child.add(move(parent, 1, position));
        }
        if (isMoveLeft(position)) {
            child.add(move(parent, 2, position));
        }
        if (isMoveRight(position)) {
            child.add(move(parent, 3, position));
        }
        //return child;
    }

    //移动 true
    public Status move(Status parent, int x, int zeroPosition) {
        Status res = new Status(); //这才是深拷贝
        //res = parent;  //这是浅拷贝 造成了牵一发而动全身
        //int[] resNums = parent.nums;
        int[] resNums = new int[9];
        for (int i = 0; i < parent.nums.length; i++) {
            resNums[i] = parent.nums[i];
        }
        res.nums = resNums; //可能错误 //res的数组初始化为父状态的数组
        int p = 0; //p 为与 0 交换的数组下标
        switch (x) {
            case 0: //上移
                p = zeroPosition - 3;
                break;

            case 1://下移
                p = zeroPosition + 3;
                break;

            case 2://左移
                p = zeroPosition - 1;
                break;

            case 3://右移
                p = zeroPosition + 1;
                break;
        }
        //交换 0 与 元素
        res.nums[zeroPosition] = parent.nums[p];
        res.nums[p] = 0;
        res.initChild(parent, res.nums);
        return res;
    }

    //允许移动的情况 true
    //在第一排
    public boolean isMoveUp(int position) {
        if (position <= 2) {
            return false;
        }
        return true;
    }
    //在最后一排
    public boolean isMoveDown(int position) {
        if (position >= 6) {
            return false;
        }
        return true;
    }
    //在最左边
    public boolean isMoveLeft(int position) {
        if (position % 3 == 0) {
            return false;
        }
        return true;
    }
    //在最右边
    public boolean isMoveRight(int position) {
        if ((position % 3) == 2) {
            return false;
        }
        return true;
    }

    //找到 0 的位置 true
    public int getZero(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    //对open表排序 //使用冒泡排序以估价函数值从小到大排列
    private void sortOpen(ArrayList<Status> open) {
        for (int i = 0; i < open.size() - 1; i++) {
            for (int j = 0; j < open.size() - i - 1; j++) {
                if (open.get(j).compareTo(open.get(j+1)) > 0) {
                    Status tmp = open.get(j);
                    open.set(j, open.get(j+1));
                    open.set(j+1, tmp);
                }
            }
        }
    }

    //打印答案

    //打印过程数组
    public void printProcess(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
            if (i % 3 == 2) {
                System.out.println();
            }
        }
        //System.out.println();
    }


    //求逆序值判断是否有解，逆序值同奇或同偶才有解
}

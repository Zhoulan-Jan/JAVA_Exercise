import java.util.ArrayList;
import java.util.Collections;

public class Storage {
    ArrayList<Node> mainSpace = new ArrayList<>(); //主存空间

    //初始化空闲分区说明表 题目要求：初始时主存中没有作业
    public void init() {
        Node node = new Node();
        node.start = 0;
        node.len = 512;
        node.end = 512;
        node.isAllocated = false;
        mainSpace.add(node);
    }

    //最先适应分配
    public void distribution(String name, int len) {
        Collections.sort(mainSpace);
        Node newNode = new Node(name, len);
        for (int i = 0; i < mainSpace.size(); i++) { //遍历主存空间
            Node node = mainSpace.get(i);
            //找到空闲分区 并且空闲分区的长度大于需要量
            if (!node.isAllocated && node.len >= len) {
                //先规定新分区的值
                newNode.start = node.start;
                newNode.end = node.start + len;
                newNode.isAllocated = true;
                //再修改该分区的内容
                node.start += len;
                node.len -= len;
                //新增一个Node
                mainSpace.add(newNode);
                break; //很重要！
            }
        }
    }

    //回收
    public void recycling(String name) {
//        for (int i = 0; i < mainSpace.size(); i++) {
//            Node node = mainSpace.get(i);
//
//            if (node.name != null && node.name.equals(name)) {
//                node.isAllocated = false;
//                node.name = null;
//            }
//        }

        Collections.sort(mainSpace);
        for (int i = 0; i < mainSpace.size(); i++) {
            Node curNode = mainSpace.get(i);
            Node preNode = null;
            Node nextNode = null;
            if (i != 0) {
               preNode = mainSpace.get(i-1);
            }
            if (i < mainSpace.size() - 1) {
                nextNode = mainSpace.get(i+1);
            }

            //先找到要回收的分区
            if (curNode.name != null && curNode.name.equals(name)) {
                //是否能与前一个空闲分区合并 (即前一个是否为空闲分区，是合并）
                if (i != 0 && preNode != null && !preNode.isAllocated) { //为空闲分区
                    //是否能与后一个空闲分区合并
                    if (nextNode != null && !nextNode.isAllocated) {
                        //三个分区合并
                        preNode.len = preNode.len + curNode.len + nextNode.len;
                        preNode.end = preNode.end + curNode.len + nextNode.len;
                        mainSpace.remove(curNode);
                        mainSpace.remove(nextNode);
                    } else {
                        //与前一个合并
                        preNode.end += curNode.len;
                        preNode.len += curNode.len;
                        mainSpace.remove(curNode);
                    }
                } else {
                    if (nextNode != null && !nextNode.isAllocated) {
                        //与后一个分区合并
                        curNode.end += nextNode.len;
                        curNode.len += nextNode.len;
                        curNode.isAllocated = false;
                        mainSpace.remove(nextNode);
                    } else {
                        //不合并
                        curNode.isAllocated = false;
                        curNode.name = null;
                    }
                }
            }
        }
    }

    //打印空闲分区说明表
    public void Print() {
        Collections.sort(mainSpace);
        System.out.println("起址\t" + "长度\t" + "终址\t" + "状态\t");
        for (int i = 0; i < mainSpace.size(); i++) {
            Node node = mainSpace.get(i);
//            if (!node.isAllocated) { //为空闲分区
//                System.out.printf("%3d     ",node.start);
//                System.out.printf("%3d     ",node.len);
//                System.out.printf("%3d     ",node.end);
//                System.out.print(node.isAllocated + "     ");
//                System.out.println();
//            }
            System.out.printf("%3d     ",node.start);
            System.out.printf("%3d     ",node.len);
            System.out.printf("%3d     ",node.end);
            System.out.print(node.isAllocated + "     ");
            System.out.println();
        }
    }
}

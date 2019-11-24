import java.util.Random;

public class Scheduling {
    //初始化 //且确定初始队列
    public void initNode(PCB head) {
        //List<PCB> list = new LinkedList<>(); //使用内置的list 不知道next如何表达
        //建立带头结点的链表
        //使用随机数
        Random ra = new Random();
        PCB K1 = new PCB("P1",ra.nextInt(50),ra.nextInt(50),"R");
        PCB K2 = new PCB("P2",ra.nextInt(50),ra.nextInt(50),"R");
        PCB K3 = new PCB("P3",ra.nextInt(50),ra.nextInt(50),"R");
        PCB K4 = new PCB("P4",ra.nextInt(50),ra.nextInt(50),"R");
        PCB K5 = new PCB("P5",ra.nextInt(50),ra.nextInt(50),"R");

        //使用固定数值
//        PCB K1 = new PCB("P1",2,1,"R");
//        PCB K2 = new PCB("P2",3,5,"R");
//        PCB K3 = new PCB("P3",1,3,"R");
//        PCB K4 = new PCB("P4",2,4,"R");
//        PCB K5 = new PCB("P5",4,2,"R");

//        //用指针指出队列连接情况
//        head.next = K2;
//        K2.next = K4;
//        K4.next = K3;
//        K3.next = K5;
//        K5.next = K1;
//        K1.next = null;

        //用链表连接
        build(head, K1);
        build(head, K2);
        build(head, K3);
        build(head, K4);
        build(head, K5);
        //return list;
    }

    //队列首次排列，在插入进程的同时排序 正确
    public void build(PCB head, PCB pnode) {
        //空链表
        if (head.next == null) {
            head.next = pnode;
            return;
        }
        //非空链表
        PCB prev = findPrevValue(head, pnode.priority);
        pnode.next = prev.next;
        prev.next = pnode;
    }

    //模拟进程进行 优先数，运行时间改变 状态
    public void run(PCB head) {
        PCB first = head.next;
        first.priority--;
        first.time--;
        resort(head, first);
    }

    //队列重排列
    public void resort(PCB head, PCB changed) { //changed表示已修改的进程 即是head后的第一个元素
        //如果changed的运行时间为零，则其退出队列
        if (changed.time == 0) {
            changed.status = "E";
            head.next = head.next.next;
            return;
        }
        //只有一个进程的时候，不需要重排列
        if (head.next.next == null) {
            return;
        }
        //运行时间不为零就要进行队列重排列 根据changed.priority的值确定插入位置
        PCB cur = head.next;
        PCB node = changed; //根据changed创建一个新节点，防止后面混乱
        //仍在第一个，则无需改变队列
        if (node.priority >= cur.next.priority ) {
            return;
        }
//        while (node.priority < cur.next.priority) { //<=说明changed排在了与其相等的优先级后面
//            cur = cur.next;
//        }
        head.next = head.next.next;
        PCB prev = findPrevValue(head, node.priority);
        //在最后一个
        if (prev == null) {
            prev.next = node;
        } else {
            //在中间
            node.next = prev.next;
            prev.next = node;
        }
    }

    //根据元素值找前一个结点
    private PCB findPrevValue(PCB head, int val) {
        PCB cur = head;
        while (cur.next != null && cur.next.priority > val) {
            cur = cur.next;
        }
        return cur;
    }

    //打印一次进程后的队列状况
    public void print(PCB head) {
        PCB cur = head.next;
        System.out.print("被选中的进程：" + cur + ",  ");
        for (; cur != null; cur = cur.next) {
            System.out.print(cur + " ");
        }
        System.out.println();
    }

}

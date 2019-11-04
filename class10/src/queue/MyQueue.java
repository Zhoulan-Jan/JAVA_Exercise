package queue;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyQueue {
    private Node head = null;
    private Node tail = head;
    private int size = 0;

    //入队 尾插法
    public void offer(int elem) {
         Node node = new Node(elem);
         if (head == null) {
             head = node;
         } else {
             tail.next = node;
         }
         tail = node; //tail = tail.next
         size++;
    }

    //出队
    public int poll() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        Node oldHead = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return oldHead.val;
    }

    //取队首元素
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }

    //判断队是否空
    public boolean isEmpty() {
        return size == 0;
    }

    //长度
    public int size() {
        return size;
    }
}

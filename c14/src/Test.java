import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(3);
        queue.offer(7);
        queue.offer(1);
        queue.offer(8);
        queue.offer(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(Arrays.toString(queue.arr));
    }
}

public class Test {
    public static void main(String[] args) {
        Scheduling scheduling = new Scheduling();
        PCB head = new PCB("P0");
//        System.out.println("队首进程为：" + scheduling.initNode(head));
        scheduling.initNode(head);
        scheduling.print(head);
        while (head.next != null) {
            scheduling.run(head);
            scheduling.print(head);
        }
//        scheduling.run(head);  scheduling.print(head);

    }
}

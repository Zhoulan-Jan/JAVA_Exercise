import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage();
        storage.init();
        storage.distribution("作业1",300);
        storage.distribution("作业2",100);
        storage.recycling("作业1");
        storage.distribution("作业3",150);
        storage.distribution("作业4",30);
        storage.distribution("作业5",40);
        storage.distribution("作业6",60);
        storage.recycling("作业4");
        storage.Print();

//        storage.distribution("A",200);
//        storage.distribution("B",150);
//        storage.recycling("A");
//        storage.distribution("C",100);
//        storage.distribution("D",50);
//        storage.distribution("E",30);
//        storage.distribution("F",70);
//        storage.Print();

//        System.out.print("请输入你的选择(申请 1，回收 2，退出 0)：> ");
//        storage.init();
//        do {
//            int choice = sc.nextInt();
//            if (choice == 1) {
//                storage.distribution("作业1",300);
//                storage.distribution("作业2",100);
//                storage.Print();
//            } else if (choice == 2){
//                storage.recycling("作业1");
//            } else {
//                System.exit(0);
//            }
//            System.out.print("请输入你的选择(申请 1，回收 2，退出 0)：> ");
//        } while (sc.hasNextInt());
    }
}

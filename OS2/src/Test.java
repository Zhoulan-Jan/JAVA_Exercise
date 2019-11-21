import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Banker banker = new Banker();
        //输入数据 初始化
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入进程数量： ");
        banker.setProcessNum(sc.nextInt());
        System.out.print("请输入资源数量： ");
        banker.setResourceNum(sc.nextInt());
        //System.out.println(banker.resourceNum);
        //输入max allocation available
        for (int row = 0; row < banker.processNum; row++) {
            System.out.println("请输入进程P" + row + "的max");
            for (int col = 0; col < banker.resourceNum; col++) {
                banker.max[row][col] = sc.nextInt();
            }
        }
        for (int row = 0; row < banker.processNum; row++) {
            System.out.println("请输入进程P" + row + "的allocation");
            for (int col = 0; col < banker.resourceNum; col++) {
                banker.alloction[row][col] = sc.nextInt();
            }
        }
        System.out.println("available");
        for (int col = 0; col < banker.resourceNum; col++) {
            banker.available[col] = sc.nextInt();
        }

        banker.getNeed(banker.max, banker.alloction);

        //打印T0时刻状态
        System.out.print("T0时刻的");
        banker.printAllocateRes(banker.max, banker.alloction, banker.need, banker.available);
        System.out.print("T0时刻的");
        banker.SecurityAlgorithm();

        //进程请求资源
        System.out.print("> 是否请求资源：y/n  ");
        while (sc.hasNext()) {
            String intput = sc.next();
            if (intput.equals("y")) {
                banker.BankerAlgorithm();
            } else {
                break;
            }
            System.out.print("> 是否请求资源：y/n  ");
        }
    }
}

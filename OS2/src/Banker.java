import java.util.Scanner;

public class Banker {
    int processNum = 0;
    int resourceNum = 0;

    public void setProcessNum(int processNum) {
        this.processNum = processNum;
    }
    
    public void setResourceNum(int resourceNum) {
        this.resourceNum = resourceNum;
    }
    //    int[] available = {3,3,2}; //可利用资源向量
//    int[][] max = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}}; //最大需求矩阵
//    int[][] alloction = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}}; //分配矩阵
//    int[][] need = new int[5][3]; //需求矩阵 need = max - alloction

    int[][] max = new int[processNum][resourceNum];
    int[][] alloction = new int[processNum][resourceNum];
    int[][] need = new int[processNum][resourceNum];
    int[] available = new int[resourceNum];

    //int[][] request = new int[3][3]; //请求向量
    //int[] work = new int[3]; //工作向量

    //max alloction available由输入得到

    //得到need矩阵 need = max - alloction
    public void getNeed(int[][] max, int[][] alloction) {
        //int[][] need = null;
        for (int row = 0; row < max.length; row ++) {
            for (int col = 0; col < max[row].length; col++) {
                need[row][col] = max[row][col] - alloction[row][col];
            }
        }
    }

    //安全性算法
    public void SecurityAlgorithm() {
        //初始化
        //int[] work = available;
        int[] work = new int[resourceNum]; //长度为available.length,表示资源个数
        for (int i = 0; i < resourceNum; i++) {
            work[i] = available[i];
        }
        boolean[] finish = new boolean[processNum]; //长度为进程的个数
        int[] security = new int[processNum]; //记录安全序列
        //找到满足要求的进程
        System.out.println("安全性检查：");
        System.out.println("Work      " + "Need     " + "Allocation     " +  "Work + Allocation");
        int cnt = 0; //加入安全序列的进程数
        int circle = 0; //循环圈数
        while (cnt < processNum) { //利用 max.length代表进程的个数
            for (int i = 0; i < processNum; i++) { //找到一个
                if (!finish[i] && meetDemand(need[i], work) ) {
                    //先打印该进程的安全序列
                    printSecuritySeq(work, need[i], alloction[i]);
                    //找到进程则可更新work，finish
                    for (int j = 0; j < resourceNum; j++) {
                        work[j] = work[j] + alloction[i][j];
                    }
                    finish[i] = true;
                    security[cnt++] = i;
                }
            }
            circle++;
            if (cnt == max.length) {
                System.out.print("存在安全序列：");
                for (int i = 0; i < security.length; i++) {
                    System.out.print(" P" + security[i] + " ");
                }
                System.out.println();
                break;
            }
            if (cnt < circle) {
                System.out.println("当前不存在安全序列");
                break;
            }
        }
    }

    //银行家算法
    public void BankerAlgorithm() {
        System.out.print("请输入需请求资源的进程编号：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.print("请输入各资源的请求数量：");
        int[][] request = new int[processNum][resourceNum];
        for (int i = 0; i < resourceNum; i++) {
            request[num][i] = sc.nextInt();
        }
        //算法检查
        if (meetDemand2(request[num], need[num], available)) {
            //可以为该进程分配资源了
            for (int j = 0; j < resourceNum; j++) {
                available[j] -= request[num][j];
                alloction[num][j] += request[num][j];
                need[num][j] -= request[num][j];
            }
            printAllocateRes(max,alloction,need,available);
            SecurityAlgorithm();
        } else {
            System.out.println("资源分配不足");
        }
    }

    //判断request <= need; request <= available
    public boolean meetDemand2(int[] request, int[] need, int[] available) {
        for (int i = 0; i < resourceNum; i++) {
            if (request[i] > need[i] || request[i] > available[i]) {
                return false;
            }
        }
        return true;
    }

    //判断need <= work
    public boolean meetDemand(int[] need, int[] work) {
        for (int i = 0; i < work.length; i++) {
            if (need[i] > work[i]) {
                return false;
            }
        }
        return true;
    }

    //打印资源分配表
    public void printAllocateRes(int[][] max, int[][] alloction, int[][] need, int[] available) {
        System.out.println("资源分配表：");
        System.out.println("Max      " + "Allocation     " + "Need      " );
        //row行 col列
        for (int row = 0; row < processNum; row++) {
            //打印max
            for (int col = 0; col < resourceNum; col++) {
                System.out.print(max[row][col] + "  ");
            }
            System.out.print("   ");
            //打印allocation
            for (int col = 0; col < resourceNum; col++) {
                System.out.print(alloction[row][col] + "  ");
            }
            System.out.print("    ");
            //打印need
            for (int col = 0; col < resourceNum; col++) {
                System.out.print(need[row][col] + "  ");
            }
            System.out.println();
        }
        //打印available
        System.out.print("available: ");
        for (int col = 0; col < resourceNum; col++) {
            System.out.print(available[col] + " ");
        }
        System.out.println();
    }

    //打印进程的安全序列
    public void printSecuritySeq(int[] work, int[] need, int[] allocation) {
        //打印work
        for (int i = 0; i < resourceNum; i++) {
            System.out.print(work[i] + " ");
        }
        System.out.print("   ");
        //打印need
        for (int i = 0; i < resourceNum; i++) {
            System.out.print(need[i] + " ");
        }
        System.out.print("     ");
        //打印allocation
        for (int i = 0; i < resourceNum; i++) {
            System.out.print(allocation[i] + " ");
        }
        System.out.print("        ");
        //打印work+allocation
        for (int i = 0; i < resourceNum; i++) {
            int wa = work[i] + allocation[i];
            System.out.print(wa + " ");
        }
        System.out.println();
    }

}

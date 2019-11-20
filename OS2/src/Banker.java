public class Banker {
    int[] available = {10, 8, 7}; //可利用资源向量
    int[][] max = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}}; //最大需求矩阵
    int[][] alloction = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}}; //分配矩阵
    int[][] need = new int[5][3]; //需求矩阵 need = max - alloction

    int[][] request = new int[3][3]; //请求向量
    int[] work = new int[3]; //工作向量

    //得到need矩阵 need = max - alloction
    public void getNeed(int[][] max, int[][] alloction) {
        //int[][] need = null;
        for (int row = 0; row < max.length; row ++) {
            for (int col = 0; col < max[row].length; col++) {
                need[row][col] = max[row][col] - alloction[row][col];
                //System.out.print(need[row][col] + " ");
            }
            //System.out.println();
        }
        //return need;
    }

    //打印矩阵
    public static void print(int[][] need) {
        for (int row = 0; row < need.length; row ++) {
            for (int col = 0; col < need[row].length; col++) {
                System.out.print(need[row][col] + " ");
            }
            System.out.println();
        }
    }

}

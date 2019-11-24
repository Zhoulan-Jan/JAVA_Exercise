public class Status implements Comparable{
    char name;
    int[] nums = new int[9]; //使用一维数组更方便 （移动）
    Status parent;

    int[] destination = {1, 2, 3, 8, 0, 4, 7, 6, 5};

    int valuation = 0; //估价函数值 valuation = depth + measure
    int depth = 0; //代表状态的深度
    int measure = 0; //以不在位的数码作为度量

    public Status(Status parent) {
        for (int i = 0; i < nums.length; ++i) {
            this.nums[i] = parent.nums[i];
        }
        int tmp = 0; //记录数码
        for (int i = 0; i < 9; i++) {
            if (nums[i] != destination[i]) {
                tmp++;
            }
        }
        this.measure = tmp;
        if (this.parent == null) {
            this.depth = 0;
        } else {
            this.depth = this.parent.depth + 1; //该状态的深度为父状态的深度+1
        }
        this.valuation = this.depth + this.measure;
    }

    public Status() {
    }

    //得到状态的估价函数 //初始化
    public int init(Status destination) {
        int tmp = 0; //记录数码
        for (int i = 0; i < 9; i++) {
            if (nums[i] != destination.nums[i]) {
                tmp++;
            }
        }
        this.measure = tmp;
        if (this.parent == null) {
            this.depth = 0;
        } else {
            this.depth = this.parent.depth + 1; //该状态的深度为父状态的深度+1
        }
        return this.valuation = this.depth + this.measure;
    }

    //比较两个状态 //可以以估价函数值的大小对open表进行排序
    @Override
    public int compareTo(Object o) {
        Status c = (Status) o;
        return this.valuation - c.valuation;
    }
}

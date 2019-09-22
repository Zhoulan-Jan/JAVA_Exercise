import java.util.Arrays;

public class SeqList {
    private int[] data = new int[10];
    private int size = 0;

    //打印顺序表
    public void display(){
        //System.out.println(Arrays.toString(data));
        //打印有效数组
        System.out.print("[");
        for (int i = 0; i < this.size; i++){
            System.out.print(this.data[i]);
            if (i != this.size - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //扩容
    public void realloc() {  //不能用static 静态方法不能使用this
        int[] newData = new int[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++){
            newData[i] = this.data[i];
        }
        this.data = newData; //为什么这么直接赋值就可以了
    }

    //在pos位置新增元素
    public void add(int pos, int elem){
        //不合法情况
        if (pos < 0 || pos > this.size) return;
        if (this.size >= this.data.length){
            realloc();
        }
        //尾插
        else if (pos == this.size ) {
            this.data [this.size] = elem;
            this.size++;
        }
        //任意位置插入
        else if (pos < this.size) {
            for (int i = this.size - 1; i >= pos; i--) {
                this.data[i + 1] = this.data[i];
            }
            this.data[pos] = elem;
            this.size++;
        }
    }

    //判断是否包含某元素
    public boolean contains(int toFind) {
        if (search(toFind) != -1) return true;
        else return false;
    }

    //查找某个元素的位置
    public int search(int toFind) {
        for (int i = 0; i < this.data.length; i++) {
            if (data[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos > this.size) return -1;
        else return this.data[pos];
    }

    //给pos位置的元素设为value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos > this.size) return;
        this.data[pos] = value;
    }

    //删除第一次出现的关键字key

    //获取顺序表长度

    //清空顺序表

}


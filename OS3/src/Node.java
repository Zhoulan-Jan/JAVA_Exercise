public class Node implements Comparable{
    //定义空闲分区表的每个结点
    public String name; //结点名称 ABCD
    public int start; //结点起址
    public int end; //结点状态
    public int len; //结点长度
    public boolean isAllocated; //true表示已分配 //false表示为空闲分区

    public Node(String name, int len) {
        this.name = name;
        this.len = len;
    }

    public Node() {
    }

    @Override
    public int compareTo(Object o) {
        Node t = (Node) o;
        if (start <= t.start) {
            return -1;
        }
        return 1;
    }
}

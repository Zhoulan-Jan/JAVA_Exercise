public class PCB {
    public String name; //进程名
    public PCB next; //指针
    public int time; //运行时间
    public int priority; //优先数
    public String status; //状态

    public PCB(String name,int time, int priority, String status) {
        this.name = name;
        this.time = time;
        this.priority = priority;
        this.status = status;
    }

    public PCB(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + " " + time + " " + priority + "]";
    }

}

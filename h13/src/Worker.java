public class Worker extends Human {
    private String workNum;
    private int workAge;

    public Worker(String name, int age, String sex, String workNum, int workAge) {
        super(name, age, sex);
        this.workNum = workNum;
        this.workAge = workAge;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
}

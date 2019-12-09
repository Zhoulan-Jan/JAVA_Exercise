public class ThreadTest extends Thread {
    public String name; //线程名
    public long sleepTime;

    public ThreadTest(String name, long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    public void run() {
        for (int i = 1; i <=100; i++) {
            System.out.println(name + i + "循环");
            try {
                sleep(sleepTime); //以毫秒做单位
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

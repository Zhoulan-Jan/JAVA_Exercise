public class CreateTreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("我的线程");
        //1
        myThread.run(); //会当作一个实例方法，而不是真实地启动一个线程
       //2
        myThread.start(); //启动了一个线程1 线程1和线程2 同时进行，（并发和并发都有可能）
        //重新启动jconsole 需要新建连接
        while (true) {} //线程2
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println();
    }
}



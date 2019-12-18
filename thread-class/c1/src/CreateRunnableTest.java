public class CreateRunnableTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(),"MyRunnable");
        t.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
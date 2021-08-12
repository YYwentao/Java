package 线程练习;

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
           System.out.println("通过继承 Thread 类创建线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Thread01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (true) {
            System.out.println("我是主线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

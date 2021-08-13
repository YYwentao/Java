package 线程练习;

//演示 wait() 和 notify() 方法
public class ThreadDemo8 {
    static public Object Locker = new Object();
    // 用来等待的线程
    static class waitTask implements Runnable {
        @Override
        public void run() {
            synchronized (Locker) {
                while (true) {
                    try {
                        System.out.println("wait 开始");
                        Locker.wait();
                        System.out.println("wait 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    // 用来通知的线程
    static class notifyTask implements Runnable {
        @Override
        public void run() {
            synchronized (Locker) {
                System.out.println("notify 开始");
                Locker.notify();
                System.out.println("notify 结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new waitTask());
        Thread t2 = new Thread(new notifyTask());
        t1.start();
        Thread.sleep(3000);
        t2.start();
    }
}

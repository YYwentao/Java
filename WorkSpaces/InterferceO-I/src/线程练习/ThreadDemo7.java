package 线程练习;

public class ThreadDemo7 {
    static class Counter {
        volatile public int count = 0;
        // 对方法进行加锁
//        synchronized void inCrease() {
//            count++;
//        }
        // 对操作进行加锁
        void inCrease() {
            synchronized(this) {
                count++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                     counter.inCrease();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.inCrease();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}

package 线程练习;

// 线程中断
public class ThreadDemo3 {
    static boolean flg = true;
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (flg) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        // 因为线程 t 和主线程是并发执行，所以 5 秒后 flg == false,run方法就结束了
        try {
            Thread.sleep(5000);
            flg = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

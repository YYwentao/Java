package 线程练习;

/**
 * ClassName: ThreadDemo4
 * Description:
 * date: 2021/8/12 16:22
 *
 * @author wt
 * @since JDK 1.8
 */
public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t.start();  // 执行线程

        Thread.sleep(5000);
        t.interrupt();  // 中断线程
    }
}

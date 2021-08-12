package 线程练习;

//查看线程 NEW 、 RUNNABLE 、 TERMINATED 状态的转换
public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                }
            }
        };
        System.out.println("线程创建前："+t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println("线程执行中："+t.getState());
        }
        System.out.println("线程执行结束："+t.getState());
    }
}

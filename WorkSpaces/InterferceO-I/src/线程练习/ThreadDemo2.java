package 线程练习;

class  MyTask implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
//        // 通过 Runnable 接口来创建一个线程
//        Runnable myTask = new MyTask();
//        Thread t = new Thread(myTask);
//        t.start();
        // 通过 Thread 的匿名内部类来实现
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
//        t.start();
        // 通过 Runnable 的匿名内部类来实现
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        });
//        t.start();

        //通过 lambda 表达式创建线程
        Thread t = new Thread(()->{
            System.out.println("hello");
        });
        t.start();

    }
}

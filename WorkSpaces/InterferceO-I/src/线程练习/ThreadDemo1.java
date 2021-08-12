package 线程练习;

/**
 * ClassName: ThreadDemo1
 * Description:
 * date: 2021/8/10 23:14
 *
 *      使用多线程提高效率,把一个long类型数据自增10亿次
 */
public class ThreadDemo1 {

    private static  long  count = 10_0000_0000l;

    public static void serial() {
        long start = System.currentTimeMillis();

        long a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }

        long b = 0;
        for (int i = 0; i < count; i++) {
            b++;
        }

        long end = System.currentTimeMillis();
        System.out.println("时间："+(end - start)+"ms");
    }

    // 创建两个线程,分别完成两个变量的自增效果
    public  static void concurrency() {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                long a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                long b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t2.start();
        //等待结束
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //计时
        long end = System.currentTimeMillis();
        System.out.println("时间："+(end - start)+"ms");
        System.out.println();
    }
    public static void main(String[] args) {
        serial();
        concurrency();
    }
}

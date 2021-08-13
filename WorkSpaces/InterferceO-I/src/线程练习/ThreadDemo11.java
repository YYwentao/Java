package 线程练习;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 阻塞队列
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        // 创建生产者模型
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        queue.put(i);
                        System.out.println("producer 生产数字"+i);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        // 创建消费者模型
        Thread customer = new Thread() {
            @Override
            public void run() {
                while (true){
                    try {
                        int elem = queue.take();
                        System.out.println("customer 消费数字"+elem);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        customer.start();
        producer.join();
        customer.join();
    }
}

package Queue;

/**
 * ClassName: TestMyQueue
 * Description:
 * date: 2021/4/28 19:50
 *  链式队列测试
 * @author wt
 * @since JDK 1.8
 */
public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("入队打印:");
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.display();
        System.out.print("出队:");
        System.out.println(myQueue.poll());
        System.out.print("获取现在的队头:");
        System.out.println(myQueue.peek());
    }
}

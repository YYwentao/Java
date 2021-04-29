package Queue;

/**
 * ClassName: TestMyCircularQueue
 * Description: 测试循环队列
 * date: 2021/4/29 22:52
 *
 * @author wt
 * @since JDK 1.8
 */
public class TestMyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println("入队");
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println("出队");
        System.out.println(myCircularQueue.deQueue());
        System.out.println("显示队头");
        System.out.println(myCircularQueue.Front());
        System.out.println("显示队尾");
        System.out.println(myCircularQueue.Rear());
    }
}

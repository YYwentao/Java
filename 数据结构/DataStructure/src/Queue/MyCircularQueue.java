package Queue;

/**
 * ClassName: MyCircularQueue
 * Description:
 * date: 2021/4/29 22:06
 *  循环队列
 * @author wt
 * @since JDK 1.8
 */
public class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
    }

    /**
     * 1.入队
     * 队尾插入
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1)%this.elem.length;
        return true;
        }

    /**
     * 2.出队
     * 队头删除
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        return true;
    }

    /**
     * 3.得到队头元素 但是不删除
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    /**
     * 4.得到队尾元素
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (this.rear == 0) {
            return this.elem[this.elem.length-1];
        } else {
            return this.elem[this.rear-1];
        }
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     *  判断是否满了
     *  (this.rear+1)%this.elem.length 判rear的下一个是否等于front
     */
    public boolean isFull() {
        if (((this.rear+1)%this.elem.length == this.front)){
            return true;
        }
        return false;
    }
}

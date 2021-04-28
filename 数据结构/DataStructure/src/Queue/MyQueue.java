package Queue;

/**
 * ClassName: MyQueue
 * Description:
 * date: 2021/4/28 19:22
 *  链式队列
 *  1.队列都是从队尾进，对头出。
 *  2.进队列使用链表尾插法，时间复杂度为O(1)。
 *  3.出队列从对头出，时间复杂度为O(1)。
 * @author wt
 * @since JDK 1.8
 */
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {
    public Node front;//对头
    public Node rear;//队尾

    public int usedSize;

    /**
     * 1.offer()入队
     * 采用尾插法
     * @param val
     */
    public void offer(int val) {
        Node node = new Node(val);
        //第一次插入
        if (this.rear == null) {
            this.front = node;
            this.rear = node;
        } else {
            //尾插法
            this.rear.next = node;
            this.rear = node;
        }
        usedSize++;
    }
    /**
     * 2.poll() 出队
     *  取出队头元素，返回其值
     */
    public int poll() throws UnsupportedOperationException{
        if (isempty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        //拿出队头，即链表的头的值返回，front指向下一位，有效个数减一
        int old = this.front.val;
        this.front = this.front.next;
        this.usedSize--;
        return old;
    }
    public boolean isempty() {
        return this.usedSize == 0;
    }

    /**
     * 3.peek()
     * 获取队头元素 但是不删除
     */
    public int peek() {
        if (isempty()) {
            throw new UnsupportedOperationException("队列为空");
        }
//        int old = this.front.val;
//        return old;
        return this.front.val;
    }
    /**
     * 4.size()
     *
     */
    public int size(){
        return this.usedSize;
    }
    /**
     * 5.display
     * 打印队列
     */
    public void display() {
        if (isempty()) {
            return;
        }
        Node cur = this.front;
        while (cur != null) {
            System.out.println(cur.val +" ");
            cur = cur.next;
        }
    }
}

package Linked.List;

/**
 * ClassName: DoubleLinkedList
 * Description: 2、无头双向链表实现
 * date: 2021/4/12 12:07
 *
 * @author wentao
 * @since JDK 1.8
 */
class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class DoubleLinkedList {

    public ListNode head;//头
    public ListNode tail;//尾巴

    public DoubleLinkedList() {
        ListNode listNode = new ListNode(-1);
        this.head = listNode;
        this.tail = listNode;
    }


    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            this.tail = node;
            return;
        }
        node.next = this.head.next;
        this.head.next = node;
        node.next.prev = node;
        node.prev = this.head;
    }


    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head.next == null ) {
            this.head.next = node;
            node.prev = this.head;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
    }


    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index >size()) {
            System.out.println("index位置不合法！！！");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index ==size()) {
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        //找前驱
        ListNode cur = searchIndex(index);
        if (cur == null){
            return;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    private ListNode searchIndex(int index) {
        ListNode cur = this.head.next;
        if (index < 0 || index >size()) {
            return null;
        }
        int count = 0;
        while (count != index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    //有bug,
    public void remove(int key){
        ListNode cur = this.head.next;
        while ( cur != null) {
            if (cur.val == key) {
                //如果是傀儡节点的下的第一个节点
                if (this.head.next.val ==key) {
                        this.head.next = cur.next;
                        cur.next.prev = this.head;
                } else {
                    if (cur.next != null) {
                        //中间节点
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    } else {
                        //尾节点
                        cur.prev.next = cur.next;
                        this.tail = cur.prev;
                    }
                }
                return;
            } else {
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head.next;
        while ( cur != null) {
            if (cur.val == key) {
                //如果是傀儡节点的下的第一个节点
                if (this.head.next.val ==key) {
                    this.head.next = cur.next;
                    cur.next.prev = this.head;
                } else {
                    if (cur.next != null) {
                        //中间节点
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    } else {
                        //尾节点
                        cur.prev.next = cur.next;
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }

    }
    //得到双向链表的长度
    public int size(){
        ListNode cur = this.head.next;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return  count;
    }
    //打印双向链表
    public void display(){
        ListNode cur = this.head.next;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        head.next = null;
        this.tail = null;

    }

}
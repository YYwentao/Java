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

    //头插法
    public void addFirst(int data) {
        ListNode listNode = this.head;
        if (this.head == null) {
            this.head = listNode;
            this.tail = listNode;
        } else {
            listNode.next = this.head;
            head.prev = listNode;
            head = listNode;
        }
    }
    //尾插法
    public void addLast(int data) {

    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        return false;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的长度
    public int size(){
        return -1;
    }
    public void display(){
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){

    }

}
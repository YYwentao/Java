package Linked.List;

/**
 * ClassName: TestDoubleList
 * Description:
 * date: 2021/4/18 12:56
 *
 * @author wentao
 * @since JDK 1.8
 */
public class TestDoubleList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("===================头插法======================");
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.display();
        System.out.println("===================尾插法======================");
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        doubleLinkedList.display();
        System.out.println("===================指定位置插入======================");
        doubleLinkedList.addIndex(0,200);
        doubleLinkedList.addIndex(1,100);
        doubleLinkedList.display();
        System.out.println("============查找是否包含关键字key是否在单链表当中==========");
        System.out.println(doubleLinkedList.contains(100));
        System.out.println("============删除第一次出现关键字为5的节点==========");
        doubleLinkedList.remove(5);
        doubleLinkedList.display();
        System.out.println("============删除多次出现关键字为1的节点==========");
        doubleLinkedList.removeAllKey(1);
        doubleLinkedList.display();
        System.out.println("============清空==========");
        doubleLinkedList.clear();
        doubleLinkedList.display();
    }
}

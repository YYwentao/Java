package Linked.List;

/**
 * ClassName: TestSingList
 * Description:测试单链表
 * date: 2021/4/12 16:37
 *
 * @author wentao
 * @since JDK 1.8
 */

public class TestSingList {
    public static void main(String[] args) {
        SingleLinkedList myLinkList = new SingleLinkedList();
        System.out.println("===================尾插法=====================");
          myLinkList.addLast(14);
          myLinkList.addLast(15);
          myLinkList.addLast(16);
          myLinkList.addLast(17);
          myLinkList.addLast(18);
          myLinkList.display();
        System.out.println("===================头插法=====================");
          myLinkList.addFirst(18);
          myLinkList.display();
        System.out.println("===================在1位置插入=====================");
          myLinkList.addIndex(1,2);
          myLinkList.display();
        System.out.println("===================删除删除值为2的节点=====================");
          myLinkList.remove(2);
          myLinkList.display();
        System.out.println("===================删除删除所有值为18的节点=====================");
         myLinkList.removeAllKey(18);
         myLinkList.display();

    }
}

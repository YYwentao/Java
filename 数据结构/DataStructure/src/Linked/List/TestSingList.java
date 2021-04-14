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
//        myLinkList.addFirst(10);
//        myLinkList.addFirst(11);
//        myLinkList.addFirst(12);
//        myLinkList.addFirst(13);
        myLinkList.addLast(14);
        myLinkList.addLast(14);
        myLinkList.addLast(14);
        myLinkList.addLast(14);
        myLinkList.addLast(14);
        //System.out.println(myLinkList.size());
//        myLinkList.display();
////        myLinkList.addIndex(0,10);
////        myLinkList.display();
////        myLinkList.addIndex(5,100);
        System.out.println(myLinkList.contains(18));
        myLinkList.removeAllKey(14);
        myLinkList.display();
    }
}

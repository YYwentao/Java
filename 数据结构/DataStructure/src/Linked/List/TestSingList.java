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
    //1.输入两个链表，找出它们的第一个公共结点
    public  static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        //1.求长度
        int lenA = 0;
        int lenB = 0;
        Node pl = headA;
        Node ps = headB;
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        //循环过后，都指向了null,得重新指回来
        pl = headA;
        ps = headB;
        int len = lenA-lenB;
        if (len<0) {
            //如果小于0，交换
            pl = headB;
            ps = headA;
            len = Math.abs(lenA-lenB);//求绝对值
        }
        //此时plong一定是长，pshort一定是短
        while ( len != 0) {
            pl = pl.next;
            len--;
        }
        //一起走
        while (pl != ps)  {
            pl =pl.next;
            ps = ps.next;
        }
        //如果没交点
        if ( pl==null) {
            return null;
        }
        return pl;
    }
    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     public  static Node mergeTwoLists(Node head1, Node head2) {
        Node newHead = new Node(-1); //傀儡节点
        Node tmphead = newHead;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tmphead.next = head1;
                tmphead = head1;
                head1 =head1.next;
            } else {
                tmphead.next = head2;
                tmphead = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            tmphead.next = head1;
        }
        if (head2 != null) {
            tmphead.next = head2;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        SingleLinkedList myLinkList = new SingleLinkedList();
        SingleLinkedList myLinkList1 = new SingleLinkedList();
//        System.out.println("===================尾插法=====================");
//          myLinkList.addLast(14);
//          myLinkList.addLast(17);
//          myLinkList.addLast(19);
//          myLinkList.addLast(21);
//          myLinkList.addLast(23);
//          myLinkList.display();
//        System.out.println("===================头插法=====================");
//          myLinkList.addFirst(18);
//          myLinkList.display();
//        System.out.println("===================在1位置插入=====================");
//          myLinkList.addIndex(1,2);
//          myLinkList.display();
//        System.out.println("===================删除删除值为2的节点=====================");
//          myLinkList.remove(2);
//          myLinkList.display();
//        System.out.println("===================删除删除所有值为18的节点=====================");
//         myLinkList.removeAllKey(18);
//         myLinkList.display();
        myLinkList.addLast(14);
        myLinkList.addLast(17);
        myLinkList.addLast(19);
        myLinkList.addLast(21);
        myLinkList.addLast(23);
        myLinkList.addIndex(0,1);
        myLinkList.addIndex(1,2);
        myLinkList.display();
    }
}

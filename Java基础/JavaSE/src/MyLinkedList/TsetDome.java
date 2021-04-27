package MyLinkedList;

/**
 * ClassName: TsetDome
 * Description:
 * date: 2021/4/27 16:57
 *
 * @author wt
 * @since JDK 1.8
 */
public class TsetDome {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.get(1));

        myLinkedList.display();
    }
}

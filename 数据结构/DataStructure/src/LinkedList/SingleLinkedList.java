package LinkedList;

/**
 * ClassName: SingleLinkedList
 * Description: 1.无头单向非循环链表实现
 * date: 2021/4/12 12:05
 *
 * @author wentao
 * @since JDK 1.8
 */
class Node {
    //节点类型
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SingleLinkedList {

    public Node head;   //保存单链表的头节点的引用
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
//        if (this.head == null) {
//            //第一次插入节点
//            this.head=node;
//            return;
//        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        Node node = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
            return;
        }
        //先找到 index位置的前一个节点的地址
        Node cur = searchIndext(index);
        //进行插入
        node.next = cur.next;
        cur.next = node;
    }
    private Node searchIndext(int index) {
        //1.检查index的合法性
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index位置不合法");
        }
        Node cur = this.head;
        while (index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        //删除的是不是头节点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //调用找到删除节点的前驱
        Node prev = searckkey(key);
        if (prev == null) {
            System.out.println("没有节点");
            return;
        }
        Node del = prev.next;
        //开始删除
        prev.next = del.next;
    }
    private Node searckkey(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                //找到前驱
                return prev;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        //prev前驱节点
        //cur代表要删除的节点
        Node prev = this.head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.data == key) {
                //删除元素
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.data == key) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印单链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //根据指定节点打印
    public void display1(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }



    //释放内存
    public void clear() {
        this.head = null;
    }



    //2.给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间节点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //3.反转一个单链表(头插法)
    public Node reverseList() {
        if (this.head == null || this.head.next == null) {
            return head;
        }
        //cur表示的是当前要翻转或者头插的一个节点
        Node cur = this.head;
        Node curNext = cur.next;
        //头节点
        cur.next = null;
        cur = curNext;
        while (cur != null) {
            curNext = cur.next; //如果cur不为空。cueNext往后移一步
            cur.next = this.head;
            this.head = cur;
            cur = curNext;
        }
        return this.head;
    }
    //4.输入一个链表，输出该链表中倒数第k个结点。
    public Node FindKthToTail(int k) {
        if (k<=0 || this.head==null) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k-1 != 0) {
            if (fast.next!=null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("k太大了");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //6.编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        Node cur = this.head;
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    //第一次插入
                    bs = cur;
                    be = cur;
                } else {
                    //尾插法
                    be.next = cur;
                    be = be.next;
                }
            } else {
               if (as == null) {
                   //第一次插入
                   as = cur;
                   ae = cur;
               } else {
                   //尾插法
                   ae.next = cur;
                   ae = ae.next;
               }
            }
            cur = cur.next;
        }
        //第一个区间没有数据的时候
        if(bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            //预防最后一个区间的最后一个节点 他的next不是null.
            //不预防的话  可能就死循环了
            ae.next =null;
        }
        this.head = bs;
        return head;
    }
    //7.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public Node deleteDuplication() {
        Node cur = this.head;
        Node tmphead = new Node(-1);
        Node newhead = tmphead;
        while (cur!= null) {
            if (cur.next != null && cur.data == cur.next.data) {
                //找到重复节点
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                //没有找到重复节点
                tmphead.next = cur;
                tmphead = tmphead.next;
                cur = cur.next;
            }
        }
        tmphead.next = null;//防止尾节点为空
        return newhead.next;
    }
    //8.链表的回文结构
    public boolean chkPalindrome() {
        if (this.head == null) return false;
        if (this.head.next ==null) return true;
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow位置一定是中间位置
        //2.翻转
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //slow在最后了
        //两边往中间走判断是否回文结构
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }
            //偶数情况下
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return  true;
    }
    //9.给定一个链表，判断链表中是否有环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                break;
            }
        }
        if (fast == null || fast.next == null){
            return false;
        }
        return true;
    }
    //10.给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while (slow != fast) {
            slow = slow.next;
            fast =fast.next;
        }
        return slow;
    }

}
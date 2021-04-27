package MyLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

 class MyLinkedList {
    public ListNode head;


    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    if (index<0 || index>=this.size()){
        return -1;
    }
    ListNode cur = this.head;
    while (index!=0) {
        index--;
        cur = cur.next;
    }
    return cur.val;
    }

     public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur !=null) {
            count++;
            cur =cur.next;
        }
        return count;
     }

     /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = this.head;
        this.head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index ==0 ) {
            addAtHead(val);
            return;
        }
        if (index == size()) {
            addAtTail(val);
            return;
        }
        //获取index位置前驱
        ListNode node = new ListNode(val);
        ListNode cur = searchIndext(index);
        node.next = cur.next;
        cur.next = node;
    }

     private ListNode searchIndext(int index) {
         //1.检查index的合法性
         if (index < 0 || index > this.size()) {
             throw new RuntimeException("index位置不合法");
         }
         ListNode cur = this.head;
         while (index - 1 != 0) {
             cur = cur.next;
             index--;
         }
         return cur;
     }

     /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0 || index >= size()) {
            throw new RuntimeException("index位置不合法");
        }

        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode prev = searchIndext(index);
        if (prev.next == null) {
            prev.next = null;
        }
        prev.next = prev.next.next;

    }

    //打印
     public void display() {
         ListNode cur = this.head;
         while (cur != null) {
             System.out.print(cur.val + " ");
             cur = cur.next;
         }
         System.out.println();
     }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

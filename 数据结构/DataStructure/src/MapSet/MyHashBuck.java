package MapSet;

import javax.xml.soap.Node;

/**
 * ClassName: MyHashBuck
 * Description:
 * date: 2021/5/19 17:02
 *
 * @author wt
 * @since JDK 1.8
 */
public class MyHashBuck {
    public Node[] elem;
    public int usedSize;

    class Node {
        public int key;
        public int value;
        public Node next;
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashBuck() {
        this.elem = new Node[8];
    }

    //put
    public void put(int key,int value) {
        int index = key % this.elem.length;
        Node cur = elem[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
            }
            cur = cur.next;
        }
        //头插法
        Node node = new Node(key,value);
        node.next = elem[index];
        elem[index] = node;
        this.usedSize++;
        //判断负载因子
        if (loadFactor() >= 0.75) {
            //扩容，重新哈希一遍哈希表
            resize();
        }
    }

    public void resize() {
        Node[] newElem = new Node[this.elem.length*2];
        //重新遍历一遍数组里的每一个节点,进行重新的哈希
        for (int i = 0; i < this.elem.length ; i++) {
            Node cur = elem[i];
            while (cur != null) {
                int index = cur.key % newElem.length;
                //头插法
                //注意:代码意思好像是头插法第一个节点,curNext记录第二个节点的地址，while循环也只进入一次，就连接了所有节点
                Node curNext = cur.next;
                cur.next = newElem[index];
                newElem[index] = cur;
                cur = curNext;
            }
        }
        this.elem = newElem;
    }

    public double loadFactor() {
        return this.usedSize*1.0/elem.length;
    }

    public static void main(String[] args) {
        MyHashBuck hashBuck = new MyHashBuck();
        hashBuck.put(9,99999);
        hashBuck.put(11,111111);
        hashBuck.put(3,3333333);
        hashBuck.put(5,7777777);
        hashBuck.put(2,2222222);
        hashBuck.put(1,1111111111);
        System.out.println("==========");
    }
}

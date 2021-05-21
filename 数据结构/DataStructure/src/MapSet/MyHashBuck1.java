package MapSet;

import java.util.Objects;

/**
 * ClassName: MyHashBuck1
 * Description:
 * date: 2021/5/20 15:01
 *
 * @author wt
 * @since JDK 1.8
 */
class Student {
    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class MyHashBuck1<K, V> {
    //结点
    static class Node<K,V> {
        public K key;
        public V value;
        public Node<K,V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node<K,V>[] array;
    public int usedSize;

    public MyHashBuck1() {
        this.array = (Node<K,V>[])new Node[8];
    }

    /**
     * put方法
     */
    public void put(K key,V value) {
        //找到key的位置 下标
        //int index = k /this.array.length;
        //用hashCode,相当一个哈希函数，把引用类型转变成合法数字
        int hash = key.hashCode();
        int index = hash % this.array.length;

        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        //头插法
        Node<K,V> node = new Node<>(key,value);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }

    /**
     * get方法
     */
    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % this.array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashBuck1<Student,String> map = new MyHashBuck1<>();
        Student student1 = new Student("9304");
        Student student2 = new Student("9303");
        map.put(student1,"wentao");
        map.put(student2,"xuanzhi");
        System.out.println(map.get(student1));
    }
}

package Heap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: TestBigHead
 * Description:
 * date: 2021/5/11 15:35
 * @author wt
 * @since JDK 1.8
 */
class Student implements Comparable<Student>{
    public int age;

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }
}
public class TestBigHead {
    //

    //创建一个带大小为10的大堆
    public static void main5(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public static void main4(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Student());
        priorityQueue.offer(new Student());
     }

    public static void main3(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.offer(3);
        priorityQueue.offer(30);
        priorityQueue.offer(300);
        priorityQueue.offer(3000);
        System.out.println(priorityQueue.peek());
    }
    //默认小堆存储，想要使用大堆new一个构造器
    public static void main2(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(30);
        priorityQueue.offer(300);
        priorityQueue.offer(3000);
        System.out.println(priorityQueue.peek());
    }
    public static void main1(String[] args) {
        BigHeap bigHeap = new BigHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        bigHeap.createHeap(array);
        bigHeap.push(50);
        bigHeap.pop();
        System.out.println(Arrays.toString(bigHeap.elem));
    }
}

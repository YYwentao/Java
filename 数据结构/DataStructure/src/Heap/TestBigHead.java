package Heap;


import java.util.*;

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
        bigHeap.heapSort();
        System.out.println(Arrays.toString(bigHeap.elem));
    }

    public static void main(String[] args) {
       
    }
    /**
     * 1046. 最后一块石头的重量
     */
//    public int lastStoneWeight(int[] stones) {
//        //创建一个大堆
//        PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        //把石头放入大堆之中
//        for (int stone: stones) {
//            maxheap.offer(stone);
//        }
//        while (maxheap.size() > 1) {
//            int a = maxheap.poll();
//            int b = maxheap.poll();
//            if (a > b) {
//                maxheap.offer(a-b);
//            }
//        }
//        return maxheap.size()>0? maxheap.poll(): 0;
//    }

    /**
     *373. 查找和最小的K对数字
     */
//        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//            PriorityQueue<List<Integer>> maxheap = new PriorityQueue<>(k,(o1,o2)-> {
//                    return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
//            });
//            for (int i = 0; i <Math.min(nums1.length,k) ; i++) {
//                for (int j = 0; j <Math.min(nums2.length,k) ; j++) {
//                    if (maxheap.size() == k && (maxheap.peek().get(0) + maxheap.peek().get(1)) < (nums1[i] + nums2[j])) {
//                        break;
//                    }
//                    if (maxheap.size() == k) {
//                        maxheap.poll();
//                    }
//                    List<Integer> pair = new ArrayList<>();
//                    pair.add(nums1[i]);
//                    pair.add(nums2[j]);
//                    maxheap.offer(pair);
//                }
//            }
//            List<List<Integer>> res = new ArrayList<>();
//            for (int i = 0; i <maxheap.size() && !maxheap.isEmpty()  ; i++) {
//                res.add(maxheap.poll());
//            }
//            return res;
//        }
}
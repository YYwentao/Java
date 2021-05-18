package Heap;

import Sort.HeapSort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: TopK
 * Description:topk问题
 * date: 2021/5/11 21:18
 *
 * @author wt
 * @since JDK 1.8
 */
public class TopK {
    /**
     * 前K个最大的
     *  思路:
     *     1.创建一个大小为K的小堆
     *     2.遍历数组，将前K个元素放入小队中
     *     3.从第k+1个元素开始，与 堆顶元素比较
     *     4.当前元素比堆大，那么，先出 后入
     */
    public static void topK(int[] array,int k) {

        PriorityQueue<Integer> minTopK = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i = 0; i<array.length ;i++) {
            if (k>0) {
                minTopK.offer(array[i]);
                k--;
            } else {
                Integer top = minTopK.peek();
                if (top < array[i]) {
                    minTopK.poll();
                    minTopK.offer(array[i]);
                }
            }
        }
        System.out.println(minTopK);

    }

    public static void main(String[] args) {
        int[] array = {3,6,77,88,99,22,34,545,543,32,45,111,3434};
        topK(array,7);
    }
}

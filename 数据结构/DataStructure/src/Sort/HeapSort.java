package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: HeapSort
 * Description: 堆排序
 * date: 2021/5/12 23:15
 *  1.排升序要建大堆；排降序要建小堆。
 *
 *  注意:时间复杂度： O(n*log(n))
 *      空间复杂度：O(1)
 *      稳定性：不稳定
 */
public class HeapSort {
    public static void heapSort(int[] array) {
        //1.创建大堆
        createHeap(array);
        //2.排序
        int end = array.length - 1;
        while (end > 0) {
                int tmp = array[0];
                array[0] = array[end];
                array[end] = tmp;
                adjustDown(array,0,end);
                end--;
        }
    }

    public static void createHeap(int[] array) {
        //定义p表示每颗子树的根节点
        for(int p = (array.length-1-1)/2 ;p >= 0 ;p--) {
            //向下调整每一棵树
            adjustDown(array,p,array.length);
        }
    }

    public static void adjustDown(int[] array, int parent, int len) {
        int child = parent*2 + 1;
        while (child < len) {
            if (child+1 < len && array[child+1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
                parent = child;
                child = parent*2 + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100)+1;
        }
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));

    }
}

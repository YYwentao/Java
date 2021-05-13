package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: QuickSort
 * Description: 快速排序算法(难)
 * date: 2021/5/13 21:51
 *
 * @author wt
 * @since JDK 1.8
 */
public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100)+1;
        }
        //System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void quick(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        //找基准值
        int par = partion(array,low,high);
        quick(array,low,par-1);
        quick(array,par+1,high);
    }

    public static int partion(int[] array, int start, int end) {
        int tmp = array[start];

        while (start < end) {
            while (array[end] >= tmp && start < end) {
                end--;
            }
            if (start >= end) {
                //tmp放回去
                array[start] = tmp;
                break;
            } else {
                array[start] = array[end];
            }

            while (array[start] <= tmp && start < end) {
                start++;
            }
            if (start >= end) {
                //tmp放回去
                array[start] = tmp;
                break;
            } else {
                array[end] = array[start];
            }
        }
        return start;
    }
}

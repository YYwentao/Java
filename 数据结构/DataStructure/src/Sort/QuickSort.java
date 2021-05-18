package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: QuickSort
 * Description: 快速排序
 * date: 2021/5/13 21:51
 * 时间复杂度：
 *       最好：O(n*logn)
 *       最坏：O(N^2)   数据有序的时候
 * 空间复杂度：
 *     最好：O(logn)
 *     最坏：O(n)
 * 稳定性：
 *      不稳定
 */
public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000)+1;
            //array[i] = i;
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
        /**
         * 优化2.直接插入排序
         */
        if (high - low + 1 < 100) {
            insertSort(array,low,high);
            return;
        }
        /**
         * 优化1.三位取中法
         */
        int mid = (low+high)>>>1;
        medianOfThree(array,low,mid,high);
        //找基准值
        int par = partion(array,low,high);
        quick(array,low,par-1);
        quick(array,par+1,high);
    }
    //直接插入排序
    private static void insertSort(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= start ; j--) {
                if (array[j] > tmp) {
                      array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
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
                array[start] = array[end];//关键代码
            }

            while (array[start] <= tmp && start < end) {
                start++;
            }
            if (start >= end) {
                //tmp放回去
                array[start] = tmp;
                break;
            } else {
                array[end] = array[start];//关键代码
            }
        }
        return start;
    }
    //让start(左边)位置的值是中间值
    private static void medianOfThree(int[] array, int start, int mid, int end) {
        //array[mid] <= array[start] <= array[end]
        if (array[mid] > array[start]) {
            int tmp = array[start];
            array[start] = array[mid];
            array[mid] = tmp;
        }
        if (array[end] < array[start]) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
        }
        if (array[mid] > array[end]) {
            int tmp = array[mid];
            array[mid] = array[end];
            array[end] = tmp;
        }
    }
}

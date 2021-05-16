package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: ShellSort
 * Description: 希尔排序
 * date: 2021/5/12 19:37
 *
 *  时间复杂度：建议：-》 O(n^1.3 - 1.5)
 *  空间复杂度：O(1)
 *  稳定性：不稳定的排序
 *
 */
public class ShellSort {

    private static void shellSort(int[] array) {
        int[] arr = {5,3,1};
        for (int i = 0 ;i <arr.length; i++) {
            shell(array, arr[i]);
        }
        int len = array.length;
        //这样做一般不太好，不一定能得出len都是素数，更不能保证len最后会为1
        while (len>1) {
            shell(array, len);
            len = (len/3) +1;
        }
        //运行这个相当于直接插入排序了
        shell(array, 1);
    }

    private static void shell(int[] array, int k) {
        for (int i = k; i <array.length ; i++) {
            int tmp = array[i];
            int j = i-k;
            for (; j >= 0 ; j=j-k) {
                if (array[j] > tmp) {
                    array[j+k] = array[j];
                } else {
                    break;
                }
            }
            array[j+k] = tmp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100)+1;
        }
        //System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        shellSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(array));
    }
}

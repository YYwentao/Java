package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: SelectSort
 * Description: 选择排序
 * date: 2021/5/13 21:13
 *  时间复杂度：O(n^2)
 *  空间复杂度：O(1)
 *  稳定性：不稳定
 */
public class SelectSort {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <array.length ; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i <array.length ; i++) {
            array[i] = random.nextInt(50)+1;
        }
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}

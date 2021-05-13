package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: BubbleSort
 * Description: 冒泡排序
 * date: 2021/5/13 17:25
 *
 * @author wt
 * @since JDK 1.8
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            boolean fla = false;
            for (int j = 0; j < array.length -1-i ; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    fla = true;
                }
            }
            if (fla == false) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100)+1;
        }
        //System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.toString(array));
    }
}

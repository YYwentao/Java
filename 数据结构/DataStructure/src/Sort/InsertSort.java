package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: InsertSort
 * Description: 直接插入排序
 * date: 2021/5/13 13:24
 * 时间复杂度：
 *    最好情况下：当数据有序的时候，O(n) -》  当数据越有序越快
 *    最坏情况下：当数据逆序的时候，可以达到O(n^2)
 * 空间复杂度：o(1)
 * 稳定性：稳定
 *     任何一个稳定的排序 一定可以变成不稳定的排序
 *     但是如果本身就是不稳定的排序  不可能变成稳定的排序的
 */
public class InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 有序区间: [0, i)
            // 无序区间: [i, array.length)
            int tmp = array[i]; // 无序区间的第一个数
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    //array[j+1] = tmp;
                    break;//遇到break说名j下标的元素已经小于了tmp,于是将tmp放入j+1的下标,后面的循环就没必要进行了
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}

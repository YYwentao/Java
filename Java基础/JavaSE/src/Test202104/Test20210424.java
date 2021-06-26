package Test202104;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Test202104.Test20210424
 * Description:
 * date: 2021/4/24 10:44
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Test20210424 {
    public static int[] reOrderArray (int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left < right) {
            //找偶数,遇到奇数跳过
            while(left < right && array[left]%2 != 0) {
                left++;
            }
            //找奇数，遇到偶数跳过
            while(left < right && array[right]%2 != 1) {
                right--;
            }
            if(left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2 != 0) {
                count++;
            }
        }
        int[] odd = new int[count];
        for(int i = 0; i < odd.length; i++) {
             odd[i] = array[i];
        }
        int[] even = new int[array.length-count];
        for(int i = odd.length; i < array.length; i++) {
            even[i-odd.length] = array[i];
        }
        Arrays.sort(odd);
        Arrays.sort(even);
        for(int i = 0; i < odd.length; i++) {
            array[i] = odd[i];
        }
        for(int i = odd.length; i < array.length; i++) {
            array[i] = even[i-odd.length];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,5,7};
        int[] array = reOrderArray(arr);
        System.out.println(Arrays.toString(array));
    }
}

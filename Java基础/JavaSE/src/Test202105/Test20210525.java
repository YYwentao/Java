package Test202105;

import java.util.Scanner;

/**
 * ClassName: Test20210525
 * Description:
 * date: 2021/5/26 19:32
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210525 {
    //子序列个数 -- 错误版
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();    //数组赋值
        }
        int number = childNumber(nums,n);
        System.out.println(number);
    }
    public static int childNumber(int[] array,int n) {
        int i = 0;
        int j = 1;
        int count = 0;
        if(n == 1 || n == 2) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }
        if(j < n) {
            if(array[i] < array[j]) {
                while(array[i] < array[j]) {
                    i++;
                    j++;
                }
                count++;
                i++;
                j++;
            } else {
                while(array[i] >= array[j]) {
                    i++;
                    j++;
                }
                count++;
                i++;
                j++;
            }
        }
        return count;
    }

    //字符串反转
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] array = str.toCharArray();

        int statr = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == ' ') {
                reverse(array,statr,i-1);
                statr = i+1;
            }
        }
        reverse(array,statr,array.length-1);
        reverse(array,0,array.length-1);

        System.out.println(new String(array));
    }
    public static void reverse(char[] array,int start,int end) {
        while(start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }
}

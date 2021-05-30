package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day05
 * Description:
 * date: 2021/5/30 16:35
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day05 {
    /**
     *   统计回文
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        int count = 0;
        for(int i = 0; i <= str1.length(); i++) {
            String str = str1.substring(0,i) + str2 + str1.substring(i);
            if(reverse(str)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean reverse(String str) {
        int  statr = 0;
        int  end = str.length()-1;
        while(statr < end) {
            if(str.charAt(statr) != str.charAt(end)) {
                return false;
            }
            statr++;
            end--;
        }
        return true;
    }

    /**
     *     连续最大和
     */

    public static int GetMax(int a, int b){  //得到两个数的最大值
        return (a) > (b) ? (a) : (b);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] array = new int[size];
        for(int i = 0; i< size;i++) {
            array[i] = sc.nextInt();
        }

        int sum = array[0];
        int max = array[0];

        for(int i = 1;i < size;i++) {
            sum = GetMax(sum + array[i], array[i]); //状态方程
            if (sum >= max)
                max = sum;
        }
        System.out.println(max);
    }
}

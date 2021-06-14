package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day15
 * Description:
 * date: 2021/6/14 12:55
 *
 * @author wt
 * @since JDK 1.8
 */

public class Day15 {
    /**
     *
     查找输入整数二进制中1的个数
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int num = scan.nextInt();
            int count = 0;
            while(num != 0) {
                num = num&(num-1);
                count++;
            }
            System.out.println(count);
        }
    }

    /**
     *
     手套
     */
    public static int findMinimum(int n, int[] left, int[] right) {
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(left[i] * right[i] == 0) {
                sum += left[i] + right[i];
            } else {
                leftSum += left[i];
                if(left[i] < leftMin) {
                    leftMin = left[i];
                }
                rightSum += right[i];
                if(right[i] < rightMin) {
                    rightMin = right[i];
                }
            }
        }
        return Math.min(leftSum-leftMin+1,rightSum-rightMin+1)+1+sum;
    }
    public static void main1(String[] args) {
        int[] a1 = {0,7,1,6};
        int[] a2 = {1,5,0,6};
        System.out.println(findMinimum(4,a1,a2));
    }
}

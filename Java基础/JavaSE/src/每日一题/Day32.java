package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day32
 * Description:
 * date: 2021/7/26 10:42
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day32 {
    //[编程题]斐波那契凤尾
    public static void main(String[] args) {
        int border = -1;
        long[] ans = new long[100000];
        ans[0] = 1;
        ans[1] = 2;
        for (int i = 2; i < 100000; i++) {
            long next = ans[i - 1] + ans[i - 2];
            if (border == -1 && next >= 1000000) {
                border = i + 1;
            }
            ans[i] = next % 1000000;
        }

        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            long f = ans[n - 1];

            if (n < border) {
                System.out.printf("%d\n", f);
            } else {
                System.out.printf("%06d\n", f);
            }
        }
    }
    //题目ID：858 淘宝网店
}

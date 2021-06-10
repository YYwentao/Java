package Test202106;

import java.util.Scanner;

/**
 * ClassName: Test20210609
 * Description:
 * date: 2021/6/9 15:12
 *
 * @author wt
 * @since JDK 1.8
 */


public class Test20210609 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(isFullNum(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
    //判断一个数是否是完全数
    public static boolean isFullNum(int n) {
        int sum = 0;
        for(int i = 1; i < n; i++) {
            if(n%i == 0) {
                sum += i;
            }
        }
        if(sum == n) {
            return true;
        }
        return false;
    }
}

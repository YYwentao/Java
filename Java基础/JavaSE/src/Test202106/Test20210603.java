package Test202106;

import java.util.Scanner;

/**
 * ClassName: Test20210603
 * Description:
 * date: 2021/6/4 23:25
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210603 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n%2 != 0 || n <= 2) {
            System.out.println(0);
        }
        int min = n;
        int tmp = 0;
        for(int i =1;i <= n/2; i++) {
            int j = n-i;
            if(isPrime(i) && isPrime(j)) {
                tmp = Math.abs(i-j);
                if(tmp <= min) {
                    min = tmp;
                }
            }
        }
        System.out.println((n-min)/2);
        System.out.println(n - (n-min)/2);
    }
    //判断素数
    public static boolean isPrime(int n) {
        if(n == 1 || n == 0) {
            return false;
        }
        int count = 0;
        for(int i = 1; i <=n; i++) {
            if(n%i == 0) {
                count++;
            }
        }
        if(count == 2) {
            return true;
        }
        return false;
    }
}

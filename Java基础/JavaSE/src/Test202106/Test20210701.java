package Test202106;

import java.util.Scanner;

/**
 * ClassName: Test20210701
 * Description:
 * date: 2021/7/8 15:31
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210701 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int[] ns = new int[n];
            for(int i = 0; i < n; i++) {
                ns[i] = scan.nextInt();
            }

            //最后的武力值
            System.out.println( finalN(a,ns));
        }
    }

    public static int finalN(int a,int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(a >= arr[i]) {
                a = a + arr[i];
            } else {
                a = a + gcd(a,arr[i]);
            }
        }
        return a;
    }

    public static int gcd(int a,int b) {
        for(int i = b; i >=1; i--) {
            if(b % i == 0 && a % i == 0) {
                return i;
            }
        }
        return 0;
    }
}

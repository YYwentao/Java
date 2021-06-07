package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day12
 * Description:
 * date: 2021/6/7 17:32
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day12 {
    /**
     * 1.二进制插入
     */
    public int binInsert(int n, int m, int j, int i) {
        m = m<<j;
        return n|m;
    }
    /**
     * 2.查找组成一个偶数最接近的两个素数
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int half = n/2;
            for(int i = half; i >=0; i--) {
                if(isPrime(i) && isPrime(n-i)) {
                    System.out.println(i);
                    System.out.println(n-i);
                    break;
                }
            }
        }
    }
    public static boolean isPrime(int num) {
        for(int i = 2; i <num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

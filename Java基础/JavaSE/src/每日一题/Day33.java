package 每日一题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * ClassName: Day33
 * Description:
 * date: 2021/7/26 10:53
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day33 {
    //[编程题]剪花布条
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String s = scan.nextLine();
            String t = scan.nextLine();
            int sLen = s.length();
            int tLen = t.length();
            int count = 0;
            if(sLen < tLen) {
                System.out.println(0);
                return;
            }
            int i = 0;
            String s1 = s;
            while(i < sLen) {
                if((s1.substring(i,tLen+i)).equals(t)) {
                    count++;
                    i += tLen;
                    s1 = s;
                } else{
                    i++;
                }
            }
            System.out.println(count);
        }
    }
    //[编程题]客似云来
    public static void  main2(String[] args) {
        BigInteger[] fib = new BigInteger[81];
        fib[1] = new BigInteger("1");
        fib[2] = new BigInteger("1");
        for(int i = 3; i < fib.length; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
        }
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            BigInteger result = new BigInteger("0");
            for(int i = from; i<= to; i++) {
                result =  result.add(fib[i]);
            }
            System.out.println(result);
        }
    }
}

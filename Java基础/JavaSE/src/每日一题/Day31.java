package 每日一题;

import java.util.*;

/**
 * ClassName: Day31
 * Description:
 * date: 2021/7/25 22:30
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day31 {
    //美国节日

    //分解因式
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int a = scan.nextInt();
            List<String> factors = factorization(a);
            System.out.printf("%d = %s\n",a,String.join(" * ",factors));
        }
    }

    private static List<String> factorization(int a) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; a > 1 && i*i<=a ; i++) {
            while (a%i == 0) {
                ans.add(String.valueOf(i));
                a /= i;
            }
        }
        if (a > 1) {
            ans.add(String.valueOf(a));
        }
        return ans;
    }
}

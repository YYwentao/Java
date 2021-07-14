package Test202107;

import java.util.Scanner;

/**
 * ClassName: Test20210712
 * Description:
 * date: 2021/7/14 10:52
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210712 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();
        double r = scan.nextDouble();
        double pai = 3.14;
        System.out.println(isInBowl(n,r,pai));
    }
    public static String isInBowl(double n,double r,double pai) {
        double d = 2 * r * pai;
        if (n < d ) {
            return "Yes";
        } else {
            return "No";
        }
    }
}

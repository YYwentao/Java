package 每日一题;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * ClassName: Day26
 * Description:
 * date: 2021/7/16 21:15
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day26 {
    //[编程题]快到碗里来
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            BigDecimal catLen = scan.nextBigDecimal();
            BigDecimal r = scan.nextBigDecimal();
            BigDecimal bowLen = new BigDecimal("6.28").multiply(r);
            System.out.println(bowLen.compareTo(catLen)==1?"Yes":"No");
        }
    }
    //[编程题]跳台阶扩展问题
    public int jumpFloorII(int target) {
        return 1 << --target;
    }
}

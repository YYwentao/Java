package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day29
 * Description:
 * date: 2021/7/24 21:01
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day29 {
    //[编程题]有假币
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int count = 0;
            if(n == 0) return;
            while(n >=2) {
                count++;
                n = (int)Math.ceil(((double)n)/3);
            }
            System.out.println(count);
        }
    }
}

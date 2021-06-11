package Test202106;

import java.util.Scanner;

/**
 * ClassName: Test20210611
 * Description:
 * date: 2021/6/11 15:51
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210611 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            long sum1 = 0;
            long sum2 = 0;
            for(int i = 0; i < str1.length(); i++) {
                sum1 = sum1* 10 + (str1.charAt(i)-'0');
            }
            for(int i = 0; i < str2.length(); i++) {
                sum2 = sum2* 10 + (str2.charAt(i)-'0');
            }
            long sum = sum1+sum2;

            StringBuffer sb = new StringBuffer();
            while(sum != 0) {
                sb.append(sum%10);
                sum = sum/10;
            }
            System.out.println(sb.reverse());
        }
    }
}

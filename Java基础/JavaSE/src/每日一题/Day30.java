package 每日一题;

import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: Day30
 * Description:
 * date: 2021/7/24 21:01
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day30 {
    //day30-761 因子个数
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            HashSet<Integer> set =  new HashSet<>();
            int i = 2;
            while(i <= n) {
                if(n%i == 0) {
                    set.add(i);
                    n = n/i;
                    i = 2;
                } else {
                    i++;
                }
            }
            System.out.println(set.size());
        }
    }
    //[编程题]最难的问题
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch ==' ') {
                    sb.append(ch);
                } else {
                    sb.append((char)(ch>'E' ? ch-5:ch+21));
                }
            }
            System.out.println(sb);
        }
    }
}

package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day34
 * Description:
 * date: 2021/7/26 10:57
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day34 {
    //[编程题]养兔子
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            long f1 = 1;
            long f2 = 1;
            long ret = 1;
            for(int i = 2; i <= n; i++) {
                ret = f1 + f2;
                f1 = f2;
                f2 = ret;
            }
            System.out.println(f2);
        }
    }
    //[编程题]收件人列表
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = Integer.parseInt(scan.nextLine());
            for(int i = 0; i < n; ++i) {
                String str = scan.nextLine();
                if(str.contains(",") || str.contains(" ")) {
                    System.out.print("\""+str+"\"");
                }else {
                    System.out.print(str);
                }
                if(i ==  n-1) {
                    System.out.println();
                } else {
                    System.out.print(", ");
                }
            }
        }
    }
}

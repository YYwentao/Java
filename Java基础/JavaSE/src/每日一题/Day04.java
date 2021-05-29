package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day04
 * Description:
 * date: 2021/5/29 22:10
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day04 {
    //主要使用回溯思想
    /**
     *  买苹果
     *
     小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
     可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(count(num));
    }
    //返回袋子的数量
    public static int count(int n) {
        //一定是偶数（6，8都是）,最小是6，10以上偶数都可以；
        if(n%2 != 0 || n < 6|| n == 10) {
            return -1;
        }
        //如果拿八个拿完最好
        if(n%8 == 0){
            return n/8;
        }
        //对于10以上的偶数，只要对8取余数不为0，就要从前面的1或者2个8中拿出2个，
        //把余数补为6（本来余数就是6，就不用拿）。所以+1；
        return 1 + n/8;
    }

    /**
     * 46579 --计算糖果(易)
     */
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        int n4 = scan.nextInt();
        int A = (n1 + n3) / 2;
        int B1 = (n3 - n1) / 2;
        int B2 = (n2 + n4) /2;
        int C = (n4 - n2) /2;
        if(B1 == B2 ) {
            System.out.println(A + " " + B1 + " " + C);
        } else {
            System.out.println("No");
        }
    }
    /**
     * 进制转换(易)
     * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        //遍历字符串每一位就可以得到每个小标代表的字符
        String table = "0123456789ABCDEF";
        StringBuffer sb = new StringBuffer();
        boolean flg = false;
        if(m < 0) {
            m = -m;
            flg = true;
        }
        while(m != 0) {
            sb.append(table.charAt(m%n));
            m  = m / n;
        }
        if(flg == true) {
            sb.append('-');
        }
        sb.reverse();
        System.out.println(sb);
    }

}

package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day09
 * Description:
 * date: 2021/6/4 14:19
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day09 {
    //另类加法
    public int addAB(int A, int B) {
        // write code here
        if(B == 0) {
            return A;
        }
        int sum = 0;
        int array = 0;
        while(B != 0) {
            sum = A ^ B;
            array = (A&B)<<1;
            A = sum;
            B = array;
        }
        return A;
    }
    //36915-求路径总数
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int sum = allSum(n,m);
            System.out.println(sum);
        }
    }

    public static int allSum(int n,int m) {
        //递归结束条件是n == 1 或者 m == 1
        if(n == 1 || m == 1) {
            return n + m;
        }
        return allSum(n-1,m) + allSum(n,m-1);
    }

}

import java.util.Scanner;

public class Test20210405 {
    //求第n位的斐波那契数
    public static void main(String[] args) {
        //1 1 2 3 5 8 13 21 34
        //fib(n) = fib(n-1) + fib(n-2)
        //递归调用
        System.out.println(fibrecurrence(1));
        System.out.println(fibrecurrence(2));
        System.out.println(fibrecurrence(3));
        System.out.println(fibrecurrence(4));
        //迭代方法
        Scanner scanner = new Scanner(System.in);
        System.out.println(iteration(scanner.nextInt()));

    }

    public static int iteration(int i) {
        //1 1 2 3 5 8 13 21 34
        if(i==1 || i==2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int j = 3; j <=i; j++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static int fibrecurrence(int i) {
        if (i==1 || i==2) {
            return 1;
        } else {
            return fibrecurrence(i-1) + fibrecurrence(i-2);
        }
    }

    //水仙花进阶版
    public static void main1(String[] args) {
        int i = 1;
        for (i = 1; i<=999999; i++) {
            int tmp = i;
            //1.判断为几位数
            int count = 0;
            while (tmp!=0) {
                //123
                tmp = tmp/10;
                count++;
            }
            tmp = i;
            int sum = 0;
            //2.每位数幂次方的和
            while (tmp!= 0) {
                sum+= Math.pow(tmp%10,count);
                tmp = tmp/10;
            }
            tmp = i;
            //3，判断是否和是否相等
            if (sum == tmp) {
                System.out.println(tmp);
            }
        }

    }
}

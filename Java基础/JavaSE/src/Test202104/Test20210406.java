package Test202104;

import java.util.Scanner;

public class Test20210406 {

    public static void main(String[] args) {

    }



    //递归求 N 的阶乘
    public static void main5(String[] args) {
        System.out.println(recurrenceMul(5));
    }
    public static int recurrenceMul(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*recurrenceMul(n-1);
        }
    }


    //递归求和
    public static void main4(String[] args) {
        System.out.println(recurrenceSum(10));
    }
    public static int recurrenceSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n+recurrenceSum(n-1);
        }
    }


    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void main3(String[] args) {
    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
        int n = 1234;
        fun(n);
    }
    public static void fun(int n) {
        if (n>9) {
            fun(n/10);
        }
        System.out.println(n%10); ;
    }


    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static void main2(String[] args) {

        System.out.println(sum(12351));

    }
    public static int sum(int num) {
        if(num > 9){
            return num%10+ sum(num/10);
        }else{
            return  num;
        }

    }

    //多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
    public static void main1(String[] args) {
        //多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            for (int i = 0; i < a ; i++) {
                for (int j = 0; j < a ; j++) {
                    if (i == j) {
                        System.out.print("*");
                    } else if (i == a-1-j) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}

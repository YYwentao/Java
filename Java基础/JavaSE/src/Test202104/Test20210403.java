package Test202104;

import com.sun.javaws.IconUtil;

import java.util.Objects;
import java.util.Scanner;

public class Test20210403 {
    public static void main1(String[] args) {
//        int i =1;
//        int sum =0;
//        while (i<=100) {
//            sum+=i;
//            i+=2;
//        }
//        System.out.println(sum);
//
//        i = 2;
//        int sum1 =0;
//        while (i<=100) {
//            sum1+=i;
//            i+=2;
//        }
//        System.out.println(sum1);
//        //1.编写程序数一下 1到 100 的所有整数中出现多少个数字9
//        int count =0;
//        for (int i = 1;i<=100;i++) {
//            if (i / 10 == 9) {
//                //计数90 91 92...99 共10个
//                count++;
//            }
//            if (i % 10 == 9) {
//                //计数9 19 29...99 共10个
//                count++;
//            }
//        }
//        System.out.println(count+"个包含9的数字");

        //2.输出 1000 - 2000 之间所有的闰年
//        for (int year = 1000;year<=2000;year++) {
//            if (year%100==0) {
//                    if (year%400==0) {
//                        System.out.println("闰年有"+year);
//                    }
//            }else {
//                if (year%4==0) {
//                    System.out.println("闰年有"+year);
//                }
//            }
//        }
        //3.给定一个数字，判定一个数字是否是素数
//        Scanner scanner = new Scanner(System.in);
//        int isPrime = scanner.nextInt();
//        int i =2;
//        int count = 0;
//        for (; i < isPrime; i++) {
//            if (isPrime%i ==0 ) {
//                System.out.println("不是素数");
//                break;
//            }
//
//        }
//        if (i==isPrime) {
//            System.out.println("是素数");
//        }

        //4.打印 1 - 100 之间所有的素数
//        for (int k=1;k<=100;k++){
//            int isPrime = k;
//            int i =2;
//            int count = 0;
//            for (; i < isPrime; i++) {
//                if (isPrime%i ==0 ) {
//                    //System.out.println(k+"不是素数");
//                    break;
//                }
//            }
//            if (i==isPrime) {
//                System.out.println(k+"是素数 ");
//            }
//        }

        //7.计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
//        double i = 1;
//        double sum = 0;
//        for (i = 1;i<=100;i+=2) {
//            sum+=1/i -1/(i+1);
//        }
//        System.out.println(sum);


    }


//    public static void main(String[] args) {
    ////最大公约数
//        int num =gcd(18,24);
//        System.out.println(num);
//    }
//    private static int gcd(int a, int b) {
//        int min = min(a,b);
//        for (int i = min;i>=1;i--) {
//            if (a%i == 0 && b%i==0) {
//                return i;
//            }
//        }
//        return 1;
//    }
//
//    private static int min(int a, int b) {
//        if (a>b) {
//            return b;
//        } else {
//            return a;
//        }
//    }

    public static void main2(String[] args) {
        //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入密码:");
//
//        String password ="123456";
//        for (int i = 0;i<3;i++) {
//            String num =scanner.next();
//            if (num.equals(password)) {
//                System.out.println("登陆成功");
//                break;
//            } else {
//                System.out.println("密码错误，请重新输入：");
//            }
//            if (i==2) {
//                System.out.println("退出程序");
//                break;
//            }
//        }

        //11. 求一个整数，在内存当中存储时，二进制1的个数。
//        Scanner sc =new Scanner(System.in);
//        int num = sc.nextInt();
//        int count =0;
//        for (int i =0;i<32;i++) {
//            if (((num>>>i)&1)==1) {
//                count++;
//            }
//        }
//        System.out.println(count);

        //面试题（重点）：
        // //每相邻两个数字按位与一次少一个1；
//        int num = 15;
//        int count = 0;
//        while (num!=0) {
//            count++;
//            num=num&(num-1);
//        }
//        System.out.println(count);

        //输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
//        int num =123;
//        fun(num);

        //1.有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
        //思路：每两个相同数字异或值为0，0和任何数异或为任何数
//        int[] arr = {1,2,1,2,3,4,4,};
//    //int oneNumber = oneNumber(arr);
//        System.out.println(oneNumber(arr));

    }

    public static int oneNumber(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            //前两个数字的值与第三个数字异或
            tmp = tmp ^ arr[i];
            //System.out.println(tmp);
        }
        return tmp;
    }

    public static void fun(int num) {
        if (num > 9) {
            //递归调用
            fun(num / 10);
        }
        System.out.println(num % 10);
    }

    public static void main3(String[] args) {//阶乘半递归求和；

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            //求阶乘的和
            sum += factorial(i);
        }
        System.out.println(sum);
    }

    public static int factorial(int i) {
        //求每个数的阶乘
        if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static void main4(String[] args) {

        System.out.println(add(20,30));

        System.out.println(add(1.5,2.4,1.0));
    }
    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static int add(int a,int b) {
        return a+b;
    }
    public static double add(double a,double b,double c) {
        return a+b+c;
    }

    public static void main(String[] args) {
        //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        int[] arr ={9,2,3,5,1};
        //思路：从前找偶数，后面找奇数，并交换。
        //错误版本，if应该用while循环代替，不然会交换多余数
        int left = 0;
        int right =arr.length-1;
        while (left<right) {
            if ((arr[left]%2)!=0 && left<right) {
                left++;
            }
            if ((arr[right]%2==0 && left<right)) {
                right--;
            }
            if (left<right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]);
        }

    }
}

package Test202107;

import java.util.Scanner;

/**
 * ClassName: Test20210711
 * Description:
 * date: 2021/7/13 15:54
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210711 {

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            for(int i = 0; i <n; i++) {
                System.out.print(printPassWord(arr[i]));
            }
            System.out.println();
        }
    }

    public static String printPassWord(int n) {
        long f1 = 1;
        long f2 = 1;
        long f3 = 0;
        for(int i = 2; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 =f3;
        }
        if(f2 <= 9999) {
            int count = 0;
            long tmp = f2;
            while(tmp != 0) {
                tmp = tmp /10;
                count++;
            }
            if(count == 1) {
                return "000"+f2;

            } else if(count == 2) {
                return "00"+ f2;
            } else if(count == 3) {
                return "0" + f2;
            } else {
                return ""+ f2;
            }
        } else if(f2 > 9999) {
            long tmp = f2;
            StringBuffer sb = new StringBuffer();
            while(tmp != 0) {
                sb.append(tmp%10);
                tmp /= 10;
            }
            sb.reverse();
            return sb.substring(sb.length()-4);
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String num1 = scan.nextLine();
            int num = Integer.parseInt(num1);
            while(num > 9) {
                int tmp = 0;
                while(num != 0) {
                    tmp += num % 10;
                    num /= 10;
                }
                num = tmp;
            }
            System.out.println(num);
        }
    }
}

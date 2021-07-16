package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day22
 * Description:
 * date: 2021/7/13 14:25
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day22 {
    //WY3 小易的升级之路
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            for(int i = 0; i < n; i++) {
                if(arr[i] <= a) {
                    a += arr[i];
                } else {
                    a += gcd(arr[i],a);
                }
            }
            System.out.println(a);
        }
    }

    public static int gcd(int a, int b){
        int c = 0;
        while((c = a%b )!= 0) {
            a = b;
            b = c;
        }
        return b;
    }
    /**
     * HJ59 找出字符串中第一个只出现一次的字符
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            findOneCh(str);
        }
    }
    public static void findOneCh(String str) {
        char[] chars = str.toCharArray();
        int[] count = new int[128];
        //遍历字符，统计次数
        for(int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
        }
        int flog = 1;
        for(int i = 0; i <chars.length; i++) {
            if(count[chars[i]] == 1) {
                System.out.println(chars[i]);
                flog = -1;
                break;
            }
        }
        if(flog == 1) {
            System.out.println(-1);
        }
    }
}

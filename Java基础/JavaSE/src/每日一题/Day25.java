package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day25
 * Description:
 * date: 2021/7/16 21:13
 */
public class Day25 {
    //[编程题]星际密码
    public static void main(String[] args) {
        int[] nums = new int[10001];
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3 ; i <= 10000; i++) {
            nums[i] = nums[i-1] + nums[i-2];
            nums[i] = nums[i] % 10000;
        }

        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            StringBuffer sb = new StringBuffer();
            int n = scan.nextInt();
            for(int i = 0; i < n; i++) {
                int num = scan.nextInt();
                sb.append(String.format("%04d",nums[num]));
            }
            System.out.println(sb);
        }
    }

    //[编程题]数根
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            rootTree(str);
        }
    }
    public static void rootTree(String str) {
        while(str.length() > 1) {
            int sum = 0;
            for(int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            str = sum + "";
        }
        System.out.println(str);
    }
}

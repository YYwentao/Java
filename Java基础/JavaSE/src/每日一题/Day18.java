package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day18
 * Description:
 * date: 2021/6/15 20:10
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day18 {
    /**
     * 题目ID：36861-统计每个月兔子的总数
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int month = scan.nextInt();
            System.out.println(isNum(month));
        }
    }

    public static int isNum(int n) {
        int first = 1;
        int second = 1;
        int num = 0;
        for(int i = 3; i <= n; i++) {
            num = first + second;
            first = second;
            second = num;
        }
        return num;
    }
    /**
     * 题目ID:36895-字符串通配符(测试用例出现问题)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        System.out.println(isAnswer(str1,str2,0,0));
    }

    public static boolean isAnswer(String str1, String str2,int s1,int s2) {
        if(s1 == str1.length() && s2 == str2.length()) {
            return true;
        }
        if (s1 == str1.length() || s2 == str2.length()) {
            return false;
        }
        if(str1.charAt(s1) == str2.charAt(s2)) {
            return isAnswer(str1,str2,s1+1,s2+1);
        } else if(str1.charAt(s1) == '?') {
            return isAnswer(str1,str2,s1+1,s2+1);
        } else if(str1.charAt(s1) == '*') {
            return isAnswer(str1,str2,s1+1,s2) || isAnswer(str1,str2,s1+1,s2+1) || isAnswer(str1,str2,s1,s2+1);
        } else {
            return false;
        }
    }
}

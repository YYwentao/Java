package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day20
 * Description:
 * date: 2021/7/12 11:35
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day20 {
    /**
     * HJ75 公共子串计算(这种题型需要用到动态规划)
     */
    public static void main(String[] aargs) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            if(str1.length() < str2.length()) {
                System.out.println(maxStrLength(str1,str2));
            } else {
                System.out.println(maxStrLength(str2,str1));
            }
        }
    }

    public static int maxStrLength(String str1,String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] count = new int[len1+1][len2+1];
        int max = 0;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    count[i][j] = count[i-1][j-1] + 1;
                    if(max < count[i][j]) {
                        max = count[i][j];
                    }
                }
            }
        }
        return max;
    }
    /**
     * 字符串反转
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            char[] arr = str.toCharArray();
            int s = 0;
            int e = arr.length-1;
            while(s < e) {
                char tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++; e--;
            }
            System.out.println(new String(arr));
        }
    }
}

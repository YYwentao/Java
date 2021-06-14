package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day17
 * Description:
 * date: 2021/6/14 17:24
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day17 {
    /**
     * 题目ID：36877-杨辉三角的变形
     *
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = 2 * n -1;
        int[][] arr = new int[n][m];
        //初始化二维数组为零
        for(int i = 0; i < n; i++) {
            for(int j =0; j < m; j++) {
                arr[i][j] = 0;
            }
        }
        //数组赋值
        //0.第一行为1;
        //1.注意每一行的第一个后最后一个数组的值为1,就是下标arr[i][0] = arr[i][2*i] = 1;
        //2.每一行小标为例数j = 1的位置等于上一行两个位置的值相加 arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
        arr[0][0] = 1;
        for(int i = 1; i < n; i++) {
            arr[i][0] = arr[i][i*2] = 1;
            for(int j = 1; j < m; j++) {
                if(j == 1) {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1] + arr[i-1][j-2];
                }
            }
        }
        int k = 0;
        for(; k < m; k++) {
            if(arr[n-1][k] % 2 == 0) {
                System.out.println(k+1);
                break;
            }
        }
        if(k == m) {
            System.out.println(-1);
        }
    }
    /**
     * 题目ID:36902-超长正整数相加
     */
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            String[] ss = str.split(" ");
            System.out.println(isSum(ss[0],ss[1]));
        }
    }
    //计算两个字符串的和
    public static String isSum(String str1,String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        if(!isLegal(ch1) || !isLegal(ch2)) {
            return "error";
        }
        //始终让ch1更长
        if(ch1.length < ch2.length) {
            char[] tmp = ch1;
            ch1 = ch2;
            ch2 = tmp;
        }
        int jw = 0;
        int i = ch1.length-1;
        int j = ch2.length-1;
        for(; j >= 0; i--,j--) {
            int add = ch1[i] - '0' + ch2[j] - '0' + jw;
            ch1[i] = (char)(add % 10 + '0');
            jw = add/10;
        }
        for(; i >=0; i--) {
            int add = ch1[i] - '0' + jw;
            ch1[i] = (char)(add % 10 + '0');
            jw = add/10;
        }
        StringBuilder sb = new StringBuilder();
        if(jw != 0) {
            sb.append(jw);
        }
        for( i = 0; i < ch1.length; i++) {
            sb.append(ch1[i]);
        }
        return sb.toString();
    }
    //判断字符串是否为全数字
    public static boolean isLegal(char[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] < '0' || array[i] >'9') {
                return false;
            }
        }
        return true;
    }


}

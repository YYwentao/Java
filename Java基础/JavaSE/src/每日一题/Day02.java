package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day02
 * Description:
 * date: 2021/5/27 22:35
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day02 {
    /**
     *  倒置字符串(自己的方法)
     */

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        char[] array = new char[str1.length()];
        for(int i = 0; i < str1.length(); i++) {
            array[i] = str1.charAt(i);
        }
        int n = 0;
        for(int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(ch == ' ') {
                reverse(array,n,i-1);
                n = i+1;
            }
        }
        //当i指向最后一个字符时，i++了，i<str1.length()不满足，循环进不去，所以最后一个字符串要单独处理
        reverse(array,n,array.length-1);
        reverse(array,0,array.length-1);
        System.out.println(new String(array));
    }
    public static void reverse(char[] array,int statr,int end) {
        while(statr < end) {
            char tmp = array[statr];
            array[statr] = array[end];
            array[end] = tmp;
            statr++;
            end--;
        }
    }

    /**
     * 排序子序列
     * @param args
     */
    public static void  main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n+1];
        for(int i = 0;i < n; i++) {
            array[i] = scan.nextInt();
        }
        int count = 0;
        int i = 0;
        while(i < n) {
            if(array[i] < array[i+1]) {
                while(i < n && array[i] < array[i+1]) {
                    i++;
                }
                i++;
                count++;
            } else if(array[i] > array[i+1]) {
                while(i < n && array[i] > array[i+1]) {
                    i++;
                }
                i++;
                count++;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}

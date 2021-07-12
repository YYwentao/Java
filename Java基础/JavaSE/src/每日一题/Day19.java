package 每日一题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ClassName: Day19
 * Description:
 * date: 2021/7/12 11:34
 */
public class Day19 {
    /**
        HJ22 汽水瓶
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int num = scan.nextInt();
            getNum(num);
        }
    }

    public static void getNum(int num) {
        int drink = 0;
        while(num > 1) {
            //兑换的汽水个数
            drink += num/3;
            //剩余的空瓶子数量
            num = num/3 + num%3;
            //最后剩两个瓶子就借一瓶结束
            if(num == 2) {
                drink++;
                break;
            }
        }
        if(drink == 0) {
            return;
        }
        System.out.println(drink);
    }

    /**
     *
     HJ65 查找两个字符串a,b中的最长公共子串
     */
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1;
        String str2;
        while((str1 = reader.readLine()) != null) {
            str2 = reader.readLine();
            if(str1.length() < str2.length()) {
                System.out.println(getMaxLenStr(str1,str2));
            } else {
                System.out.println(getMaxLenStr(str2,str1));
            }
        }
    }

    public static String getMaxLenStr(String str1,String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();
        //最长子串起始位置
        int start = 0;
        //最长子串的长度
        int maxLen = 0;
        //用来记录相同字符的个数和maxLen对比,多增加一行作为辅助状态
        int[][] maxSubLen = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    maxSubLen[i][j] = maxSubLen[i-1][j-1] + 1;
                    //更新
                    if(maxLen < maxSubLen[i][j]) {
                        maxLen = maxSubLen[i][j];
                        start = i - maxLen;
                    }
                }
            }
        }
        return str1.substring(start,start + maxLen);
    }
}

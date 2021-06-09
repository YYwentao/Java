package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Day13
 * Description:
 * date: 2021/6/10 0:05
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day13 {
    /**
     * 跳石板(比较困难型)
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        //初始化一个数组,加1是为了下标和输入的值对应
        int[] array = new int[m+1];
        for(int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        //数组里面为正数的数值表示跳的次数
        array[n] = 0;
        for(int i = n; i < m; i++) {
            if(array[i] == -1) {
                continue;
            }
            //求约数
            List<Integer> list = div(i);
            for(int j = 0; j < list.size(); j++) {
                int k = list.get(j);
                if(i+k <= m && array[i+k] == -1) {
                    array[i+k] = array[i] + 1;
                } else if(i+k <= m && array[i+k] != -1) {
                    array[i+k] = Math.min(array[i+k],array[i] + 1);
                }
            }
        }
        if(array[m] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(array[m]);
        }
    }
    //求约数i
    public static List<Integer> div(int num) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= num/i; i++) {
            if(num%i == 0) {
                list.add(i);
                if(num/i != i) {
                    list.add(num/i);
                }
            }
        }
        return list;
    }
    /**
     * 参数解析
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '"') {
                do{
                    i++;
                } while (str.charAt(i) != '"');
            }
            if(str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(count+1);

        int flg = 1;
        for(int i = 0; i <str.length(); i++) {
            //有双引号flg置为0,分情况打印每个字符
            if(str.charAt(i) == '"') {
                flg^=1;
            }
            //flg==0 说明是在打印双引号里面的字符
            if(str.charAt(i) != '"' && flg == 0) {
                System.out.print(str.charAt(i));
            }
            //打印双引号外面的字符
            if(str.charAt(i) != '"' && flg == 1) {
                System.out.print(str.charAt(i));
            }
            //打印空格
            if(str.charAt(i) == ' ' && flg == 1) {
                System.out.println();
            }
        }
    }
}

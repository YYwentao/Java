package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: Day01
 * Description: 组队竞赛,
 * date: 2021/5/26 16:43
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day01 {
        //组队竞赛, 核心arr[arr.length-2*(i+1)]
        public static void main1(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int[] array = new int[n*3];
            long sum = 0;

            for(int i = 0; i < array.length; i++) {
                array[i] = scan.nextInt();
            }

            Arrays.sort(array);

            for(int i = 0; i < n; i++) {
                sum += array[array.length - 2*(i + 1)];
            }
            System.out.println(sum);
        }
    //删除公共字符
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if(map.get(ch) == null) {
                map.put(ch,1);
            } else {
                map.put(ch,map.get(ch) + 1);
            }
        }

        String sb = "";
        for(int i = 0; i < str1.length(); i++) {
            if(map.get(str1.charAt(i)) == null) {
                sb += str1.charAt(i);
            }
        }
        System.out.println(sb);
    }
}

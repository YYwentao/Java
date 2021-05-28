package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Day03
 * Description:
 * date: 2021/5/28 14:40
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day03 {
    /**
     * 字符串中找出连续最长的数字串
     * 思路 ：
     * 遍历字符串，使用cur去记录连续的数字串，如果遇到不是数字字符，则表示一个连续的数字串结束了，则将数
     * 字串跟之前的数字串比较，如果更长，则更新更长的数字串更新到res
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String cur = "";
        String ret = "";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                cur += ch;
            } else {
                if(cur.length() > ret.length()) {
                    ret = cur;
                    cur = "";
                } else {
                    cur = "";
                }
            }
        }

        if(cur.length() > ret.length()) {
            ret = cur;
        }
        System.out.println(ret);
    }

    /**
     * 数组中出现次数超过一半的数字
     *
     * 思路一：数组排序后，如果符合条件的数存在，则一定是数组中间那个数。这种方法虽然容易理解，但由于涉
     * 及到快排sort，其时间复杂度为O(NlogN)并非最优；
     */
    public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length == 0) {
                return 0;
            }
            Arrays.sort(array);
            int middle = array[array.length/2];
            int count = 0;
            for(int i = 0; i < array.length; i++) {
                if(middle == array[i]) {
                    count++;
                }
            }
            if(count > array.length/2) {
                return middle;
            }
            return 0;
        }
    }
}

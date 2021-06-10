package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day14
 * Description:
 * date: 2021/6/10 13:45
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day14 {
    /**
     *题目ID：36897-计算日期到天数转换
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        int month = scan.nextInt();
        int day = scan.nextInt();
        int[] arrMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(isRun(year)) {
            arrMonth[1] = 29;
        }
        int sumday = 0;
        for(int i = 0 ; i < month-1; i++) {
            sumday += arrMonth[i];
        }
        System.out.println(sumday+day);
    }
    //判断是否是闰年
    public static boolean isRun(int y) {
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            return true;
        } else
            return false;
    }

    /**
     * 题目ID:45839-幸运的袋子(不会)
     */
}

package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day06
 * Description:
 * date: 2021/5/31 22:24
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day06 {
    /**
     * 不要二
     * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
     * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
     * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
     * 小易想知道最多可以放多少块蛋糕在网格盒子里。
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int h = scan.nextInt();
        int[][] array = new int[w][h];
        int count = 0;
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(array[i][j] == 0) {
                    //数组为0可以放蛋糕，为1不能放
                    count++;
                    //按照题意的意思，标记下一个不能放蛋糕的位置
                    if(i+2 < w) {
                        array[i+2][j] = 1;
                    }
                    if(j+2 < h) {
                        array[i][j+2] = 1;
                    }
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 把字符串转换成整数
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     */
    public int StrToInt(String str) {
        int sum = 0;
        int z = 1;
        boolean f = false;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch > '0' && ch <= '9') {
                sum = sum*10 + (ch-'0');
            } else if(ch == '-'){
                f = true;
                z = -1;
            } else if(ch == '+'){
                continue;
            } else {
                return 0;
            }
        }
        return sum*z;
    }
}

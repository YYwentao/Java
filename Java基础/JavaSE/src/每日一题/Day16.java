package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day16
 * Description:
 * date: 2021/6/14 16:04
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day16 {
    /**
     * 完全数计算
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int num = scan.nextInt();
            int count = 0;
            for(int i = 2; i <= num; i++) {
                if(isFullNum(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    //判断一个数是否是完全数
    public static boolean isFullNum(int n) {
        int sum = 0;
        for(int i = 1; i < n ;i++) {
            if(n%i == 0) {
                sum += i;
            }
        }
        if(sum == n) {
            return true;
        }
        return false;
    }

    /**
     * 扑克牌大小
     */
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] st = str.split("-");
        String[] strLeft = st[0].split(" ");
        String[] strRight = st[1].split(" ");
        String tmp = "34567891JQKA2";
        //那边有双王就输出双王
        if(st[0].equals("joker JOKER") || st[1].equals("joker JOKER")) {
            System.out.println("joker JOKER");
        } else if(strLeft.length == strRight.length) {
            //相等情况下，每手牌保证类型一样,比较第一个字符下标谁最大
            if(tmp.indexOf(strLeft[0].substring(0,1)) > tmp.indexOf(strRight[0].substring(0,1))) {
                System.out.println(st[0]);
            } else {
                System.out.println(st[1]);
            }
        } else if(strLeft.length == 4) {
            //不相同情况下那边有炸弹就输出炸弹
            System.out.println(st[0]);
        } else if(strRight.length == 4) {
            System.out.println(st[1]);
        } else {
            //否则就不能比较
            System.out.println("ERROR");
        }
    }
}

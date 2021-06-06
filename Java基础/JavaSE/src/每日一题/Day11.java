package 每日一题;

/**
 * ClassName: Day11
 * Description:
 * date: 2021/6/6 14:31
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day11 {
    /**
     * 最近公共祖先
     */
    public int getLCA(int a, int b) {
        while(a != b) {
            if(a > b) {
                a = a/2;
            } else {
                b = b/2;
            }
        }
        return a;
    }
}

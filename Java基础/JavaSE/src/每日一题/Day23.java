package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Day23
 * Description:
 * date: 2021/7/16 9:52
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day23 {
    //QQ2 微信红包
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int g : gifts) {
            if(map.containsKey(g)) {
                map.put(g,map.get(g) + 1);
            } else {
                map.put(g,1);
            }
            if(map.get(g) > n/2) {
                return g;
            }
        }
        return 0;
    }
    //HJ52 计算字符串的距离

}

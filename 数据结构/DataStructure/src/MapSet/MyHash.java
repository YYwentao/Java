package MapSet;

import java.util.*;

/**
 * ClassName: MyHash
 * Description:
 * date: 2021/5/15 18:24
 *
 * @author wt
 * @since JDK 1.8
 */
public class MyHash {
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        for (int i :nums) {
            if (set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     J中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int i = 0; i <stones.length() ; i++) {
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] array = {2,2,3,3,4};
        int a =singleNumber(array);
        System.out.println(a);
    }
}

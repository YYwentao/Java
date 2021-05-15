package Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Tencent_demo01
 * Description:
 * date: 2021/5/14 16:40
 *
 * 两数之和
 * 题目：给定一个整数数组 nums [3,1,1,1]和一个 整数目标值 target[2]，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 如果你可以提供时间复杂度为 On 那就最好啦O(min(n2)
 *
 * @author wt
 * @since JDK 1.8
 */

public class Tencent_demo01 {
    public static int[] Demo01(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array= new int[]{1,3,1,1,1};
        int[] result = Demo01(array,11);
        System.out.println(Arrays.toString(result));
    }
}


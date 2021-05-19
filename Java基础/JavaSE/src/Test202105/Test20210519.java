package Test202105;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * ClassName: Test20210519
 * Description:
 * date: 2021/5/19 10:21
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210519 {
    public static void main(String[] args) {
        Integer[] array = {3,2,3,1,2,4,5,5,6};
        topK(array,1);
    }

    public static void topK(Integer[] array, int k) {
        if (k<1 || k>array.length) {
            return;
        }
        //排降序
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(array[k - 1]);
    }
}

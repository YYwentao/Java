package Test202105;


import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: Test20210522
 * Description:
 * date: 2021/5/22 21:01
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210522 {
    public static void main(String[] args) {
        char[] array = {'h','e','l','l','o'};
        reverseString(array);
    }
    public static void reverseString(char[] s) {
        int s1 = 0;
        int e1 = s.length-1;
        while (e1>s1) {
            char tmp = s[e1];
            s[e1] = s[s1];
            s[s1] = tmp;
            s1++;
            e1--;
        }
    }

}

package Test20210428;

import java.util.Random;

/**
 * ClassName: TestDemo1
 * Description:
 * date: 2021/4/28 10:34
 *
 * @author wt
 * @since JDK 1.8
 */
public class TestDemo1 {
    public static void main(String[] args) {
        int number = onlyNumber(100,105);
        System.out.println(number);
    }
    public static int onlyNumber(int start,int end) {
        Random random = new Random();
        int a = (int)(Math.random()*(end - start + 1)+start);
        return a;
    }
}

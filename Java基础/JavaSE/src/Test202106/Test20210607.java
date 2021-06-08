package Test202106;

/**
 * ClassName: Test20210607
 * Description:
 * date: 2021/6/7 23:01
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210607 {
    public static void main(String[] args) {
        String str1 = "abc" + "def";
        String str2 = new String(str1);
        if (str1.equals(str2)) {
            System.out.println(1);
        }
        if (str1 == str2) {
            System.out.println(2);
        }
    }
}

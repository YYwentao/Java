package Test202105;

/**
 * ClassName: Test202105.Test20210514
 * Description:
 * date: 2021/5/14 8:48
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210514 {
    public static int triangleTestMethod(int a,int b,int c) {
        if (a+b > c && a+c > b && b+c > a) {
            if (a == b && a == c ) {
                return 3;//等边三角形
            }else if (a == b || b == c || c == a) {
                return 2;//等腰三角形
            } else {
                return 1;//普通三角形
            }
        }else {
            return 0;//不是三角形
        }
    }

    public static void main(String[] args) {
        System.out.println(triangleTestMethod(3, 3, 3));
    }
}

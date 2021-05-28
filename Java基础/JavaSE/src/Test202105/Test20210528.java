package Test202105;

/**
 * ClassName: Test20210528
 * Description:
 * date: 2021/5/28 8:54
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210528 {

}

class HelloA {
    public HelloA() {
        System.out.println("I'm A class ");
    }
    static {
        System.out.println("static A");
    }
}
class HelloB extends HelloA {
    public HelloB() {
        System.out.println("I'm B class");
    }
    static {
        System.out.println("static B");
    }
    public static void main(String[] args) {
        new HelloB();
        //
    }
}

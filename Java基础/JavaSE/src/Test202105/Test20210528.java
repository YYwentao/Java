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
class Base{
    public Base(String s){
        System.out.print("B");
    }
}
class Derived extends Base{
    public Derived (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}
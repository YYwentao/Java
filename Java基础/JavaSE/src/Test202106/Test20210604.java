package Test202106;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: Test20210604
 * Description:
 * date: 2021/6/4 11:15
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210604 {
    //1.
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        int tmp = 0;
        for(int i = 0; i < 32; i++) {
            if(((n>>>i)&1) == 1) {
                count++;
            } else {
                if(count > tmp) {
                    tmp = count;
                    count = 0;
                }
            }
        }
        System.out.println(tmp);
    }
    //2.
    public static void main2(String[] args) {
        String x="fmn";
        x.toUpperCase();//有返回值
        String y=x.replace('f','F');
        y=y+"wxy";
        System.out.println(y);
    }

    //4.
    public static void main(String[] args) {
        String str = "hello";
        String str1 = "he" + new String("llo");
        System.out.println(str.equals(str1));
    }
}
//3.
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super("12");
        empID = id;
    }
}
class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}
abstract class A {
    public int a = 5;
    abstract void B (int a);
}
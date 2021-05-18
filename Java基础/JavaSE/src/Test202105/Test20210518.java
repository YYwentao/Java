package Test202105;

/**
 * ClassName: Test20210518
 * Description:
 * date: 2021/5/18 17:27
 *     1、实例内部类：
 *     2、静态内部类
 *     3、匿名内部类
 *     4、本地内部类(方法内部的)
 */
class OuterClass {
    public int age = 1;
    public int number =2;
    public int data = 3;
    //实例内部内
    class InnerClass {
        public int age = 4;
        public int number =5;
        public int data = 6;
        public void fun() {
            System.out.println(OuterClass.this.age);
            System.out.println(this.age);
        }
    }
}

class OuterClass1 {
    public int age = 1;
    public int number =2;
    public int data = 3;
    //静态内部内
    static class InnerClass1 {
        public int age = 4;
        public int number =5;
        public int data = 6;
        public void fun() {
            System.out.println(new OuterClass1().age);
            System.out.println(this.age);
        }
    }
}

class OuterClass2 {
    public void fun() {
        System.out.println("这是一个匿名内部内");
    }
}
public class Test20210518 {
    public static void main(String[] args) {
        OuterClass2 out = new OuterClass2();
        out.fun();
    }
    public static void main2(String[] args) {
        new OuterClass2(){
            @Override
            public void fun() {
                System.out.println("这匿名内部类的重新方法,当然也可以不重写");
            }
        }.fun();

    }
    public static void main1(String[] args) {
        //实例内部内实例化
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass1 =outerClass.new InnerClass();
        OuterClass.InnerClass innerClass2 =new OuterClass().new InnerClass();
        //静态内部内实例化
        OuterClass1.InnerClass1 innerClass = new OuterClass1.InnerClass1();
        innerClass.fun();
    }
}

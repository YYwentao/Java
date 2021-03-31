public class Test20210331 {
    public static void main(String[] args) {
        //1. 写代码实现: 给定两个 int 变量, 交换变量的值.
//        int a =10;
//        int b =20;
//        int c= a;
//        a=b;
//        b=c;
//        System.out.println(a);
//        System.out.println(b);

        //2. 写代码实现: 给定三个 int 变量, 求其中的最大值和最小值.
        int a = 1;
        int b = 9;
        int c = 3;
        System.out.println("最大值");
        if (a>b&&a>c) {
            System.out.println("a="+a);
        }else if(b>a&&b>c) {
            System.out.println("b="+b);
        }else {
            System.out.println("c="+c);
        }
        System.out.println("最小值");
        if (a<b&&a<c) {
            System.out.println("a="+a);
        }else if(b<a&&b<c) {
            System.out.println("b="+b);
        }else {
            System.out.println("c="+c);
        }
    }
}

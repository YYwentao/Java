package Calculator;

public class Calculator {
    //属性
    public double num1;
    public double num2;
    //方法
    //实现加法
    public void add() {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
    //实现减法
    public void sub() {
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2) );
    }

    //实现乘法
    public void mul() {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2) );
    }

    //实现除法
    public void div() {
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2) );
    }
}

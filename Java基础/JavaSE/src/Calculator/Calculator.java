package Calculator;

public class Calculator {
    //属性
    private double num1;
    private double num2;
    //封装
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

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

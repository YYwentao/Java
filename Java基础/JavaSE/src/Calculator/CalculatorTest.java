package Calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();//计算器

        System.out.println("请输入两个数字：");
        calculator.num1 = scanner.nextDouble();
        calculator.num2 = scanner.nextDouble();

        calculator.add();
        calculator.sub();
        calculator.mul();
        calculator.div();

        //scanner.close();
    }
}

package 每日一题;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: Day07
 * Description:
 * date: 2021/6/2 11:53
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day07 {
    //斐波那契数最近步骤
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 = 1;
        while(number >=f3 ) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        if(Math.abs(f1-number) > Math.abs(f2-number)) {
            System.out.println(Math.abs(f2-number));
        } else{
            System.out.println(Math.abs(f1-number));
        }
    }
    /**
     * 合法括号序列判断
     */
    public boolean chkParenthesis(String A, int n) {
        if(n%2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char ch : A.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')'){
                //栈为空，右括号第一次出现不合法
                if(stack.isEmpty()) {
                    return false;
                } else if(stack.peek() == '('){
                    stack.pop();
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

import java.util.Stack;

/**
 * ClassName: Test20210430
 * Description:
 * date: 2021/4/30 16:58
 *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * *左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 来源：力扣（LeetCode）
 * @author wt
 * @since JDK 1.8
 */
 class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i < s.length() ; i++ ) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.empty()) {
                    System.out.println("右括号多");
                    return false;
                } else{
                    //对比
                    char top = stack.peek();
                    if(top=='(' && ch==')'
                            || top=='[' && ch==']'
                            || top=='{' && ch=='}')
                    {
                        stack.pop();
                    }
                    else {
                        System.out.println("左右括号不匹配");
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()) {
            System.out.println("左括号多");
            return false;
        }
        return true;
    }
}
public class Test20210430{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "[()]";
        System.out.println(solution.isValid(s));
    }
}
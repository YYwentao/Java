package Stack;

import java.util.Stack;

/**
 * ClassName: MinStack
 * Description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * date: 2021/4/30 10:56
 *
 * @author wt
 * @since JDK 1.8
 */
class MinStack {
    //声明两个栈
    public Stack<Integer> stack;
    public Stack<Integer> minStack;
    public MinStack() {
        //构造方法里进行初始化
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    //入栈
    public void push(int val) {
        stack.push(val);
        //如果最小栈为空，说明第一次放
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            int top = minStack.peek(); //获取minStack栈顶元素
            //和最小的栈顶元素比较，取等号是因为防止有两个以上元素相同，
            // stack出栈时，minStack出栈后就没有最小元素了，所以都要放进来
            if (val <= top) {
                minStack.push(val);
            }
        }
    }
    //出栈
    public void pop() {
        if (stack.empty()) {
            return;
        }
        //分别获取两个栈的栈顶元素进行比较
        int top = stack.pop();  //出栈
        int top2 = minStack.peek(); //获取栈顶元素
        if (top == top2) {
            minStack.pop();
        }
    }
    //获取栈顶
    public int top() {
        if (stack.empty()) return -1;
        return stack.peek();
    }
    //获取最小栈
    public int getMin() {
        if (minStack.empty()) return -1;
        return minStack.peek();
    }
}

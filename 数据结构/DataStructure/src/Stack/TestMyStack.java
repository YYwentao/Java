package Stack;

/**
 * ClassName: TestMyStack
 * Description:
 * date: 2021/4/28 11:29
 *
 * @author wt
 * @since JDK 1.8
 */
public class TestMyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println("打印栈：");
        myStack.display();
        System.out.println("返回栈顶元素：");
        System.out.println(myStack.peek());
        System.out.println("出栈：");
        myStack.pop();
        myStack.display();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println("出完：");
        myStack.display();
    }
}


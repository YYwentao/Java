package Stack;

import java.util.Arrays;

/**
 * ClassName: MyStack
 * Description:
 * date: 2021/4/28 11:01
 *  栈的实现
 * @author wt
 * @since JDK 1.8
 */
public class MyStack {
    public int[] elem;
    public int top; //usedSize

    public MyStack() {
        this.elem = new int[10];
        this.top = 0;
    }

    /**
     * 1.push()
     * 压栈，
     * 又称进栈
     */
    public void push(int val) {
        if (this.isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.top] = val;
        top++;
    }
    //判断栈是否满了
    public boolean isFull() {
        if (this.elem.length == this.top) {
            return true;
        }
        return false;
    }

    /**
     * 2.pop()
     * 出栈,
     * 取出并返回出栈元素
     */
    public int pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int old = this.elem[this.top-1];
        this.top--;
        return old;
    }
    //判断栈是否为空
    public boolean isEmpty() {
        return this.top == 0;
    }

    /**
     * 3.peek()
     * 获取栈顶元素
     * 不取出
     */
    public int peek() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        //int old = this.elem[this.top-1];
        return this.elem[this.top-1];
    }
    /**
     * 打印栈
     */
    public void display() {
        for (int i = 0; i <this.top ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}

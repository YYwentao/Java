package SequentialList;
import java.util.Arrays;

/**
 * ClassName: Test20210407
 * Description:
 * date: 2021/4/7 20:25
 *
 * @author lenovo
 * @since JDK 1.8
 */
public class MyArrayList {
    public int[] elem;//存储数据的有效个数
    public int usedsize;//有效数据的个数

    public MyArrayList() {
        this.elem = new int[10];
    }

    //在pos位置插入数据
    public void add(int pos,int data) {
        //0.判断顺序表满了没
        if (isFull()) {
            System.out.println("满了，扩充");
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
            //return;
        }
        //1.判断pos位置的合法性
        if (pos<0 || pos>this.usedsize) {
            System.out.println("不合法");
            return;
        }
        //2.pos==usedsize
        if (pos==this.usedsize) {
            this.elem[pos] = data;
            this.usedsize++;
            return;
        }
        //3.从后往前挪
        for (int i = this.usedsize-1; i >=0; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedsize++;
    }

    private boolean isFull() {
        if (this.elem.length ==this.usedsize) {
            return true;
        } else {
            return false;
        }
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i <this.usedsize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }

}

package SequentialList;
import java.util.Arrays;

/**
 * ClassName: Test20210410
 * Description: 顺序表的实现
 * date: 2021/4/10 20:25
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

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedsize; i++) {
            if (this.elem[i]==toFind) {
                //System.out.println("包含");
                return true;
            }
        }
        //System.out.println("不包含");
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0;i <this.usedsize;i++) {
            if (elem[i] == toFind) {
                return i;
            }
        }return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        //1.判断顺序表
        if (this.usedsize==0) {
            //return -1;
            throw new RuntimeException("顺序表为空");
        }
        //2.pos合法性
        //pos位置 ==this.usedsize为不合法，
        if (pos<0 || pos>=this.usedsize) {
            return -1;
        }
        return this.elem[pos];
    }
    
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (this.usedsize == 0) {
            throw new RuntimeException("顺序表为空");
        }
        //判断pos位置合法性
        if (pos<0 || pos>=this.usedsize) {
            System.out.println("不合法");
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //找下标
        int index =search(toRemove);
        if (index == -1) {
            System.out.println("没有要删除的数字");
            return;
        }
        //主要理解i< this.usedsize-1，画图易懂，比如有三个数，要删除0号下标，i=0;i<2;i++,从后向前覆盖两次。
        for (int i =index; i< this.usedsize-1;i++) {
            this.elem[i] = this.elem[i+1];
        }
        usedsize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedsize;
    }

    // 清空顺序表
    public void clear() {
        this.usedsize=0;
    }

}

package SequentialList.顺序表1;

import java.util.Arrays;

/**
 * ClassName: MyArraylist1
 * Description:
 * date: 2021/4/13 12:18
 *
 * @author wentao
 * @since JDK 1.8
 */
public class MyArraylist1 {
    public int[] elem;//存储数据的有效个数
    public int usedata;//有效数据的个数

    //构造方法
    public MyArraylist1() {
        this.elem = new int[5];
    }
    //添加元素
    public void add(int pos,int data) {
        //1.判断顺序表是否为满
        if (this.elem.length == this.usedata) {
            System.out.println("满了，扩充");
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //2，pos位置有效性
        if (pos<0 || pos>this.usedata) {
            System.out.println("不合法");
            return;
        }
        //3,插入
        for (int i = this.usedata-1; i>=pos  ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        usedata++;
    }

    //打印元素
    public void display() {
        for (int i = 0; i <this.usedata ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    //删除第一次出现的关键字toRemove
    public void remove(int toRemove) {
        //1.判断是否含有这个关键字
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("删除的关键字不存在");
            return;
        }
        //2.删除
        for (int i = index; i < this.usedata-1 ; i++) {
            this.elem[i] = this.elem[i+1];
        }
        usedata--;
    }

    //查找一个元素返回下标
    public int search(int tofind) {
        //1.判断顺序表是否为空
        if (this.usedata == 0) {
            throw new RuntimeException("顺序表为空");
        }
        //2.查找
        for (int i = 0; i < this.usedata ; i++) {
            if (this.elem[i] == tofind) {
                return i;
            }
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        //1.判断顺序表是否为空
        if (this.usedata == 0) {
            throw new RuntimeException("顺序表为空");
        }
        //2.判断pos位置有效性
        if (pos<0 || pos>=this.usedata) {
            return;
        }
        //3.修改值为value
        this.elem[pos] =value;
    }
    

}

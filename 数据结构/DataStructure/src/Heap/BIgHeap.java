package Heap;

import java.util.Arrays;

/**
 * ClassName: BigHeap
 * Description:
 * date: 2021/5/10 11:21
 *  大堆
 * @author wt
 * @since JDK 1.8
 */
public class BigHeap {
    public int [] elem;
    public int usedSize;

    public BigHeap() {
        this.elem = new int[10];
    }

    /**
     * 大根堆
     * 每颗树(向下调整)，整棵树向上调整
     */
    public void adjustDown(int parent,int len) {//parent表示下标，len表示当前数组元素的个数
        int child = parent*2 + 1;
        //满足(child < len)说明有左子树
        //满足(child+1 < len) 说明有左右子树
        while (child < len) {
            if (child+1 < len && this.elem[child] < this.elem[child+1]) {
                child++;
            }
            //child下标是孩子节点最大的下标
            if (this.elem[child] > this.elem[parent]) {
                //交换
                int tmp =this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = parent*2 +1;
            } else {
                break;
            }
        }
    }
    public void createHeap(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //数组里面有了元素
        //从父亲结点parent开始，向上调整每一课树
        for (int p = (usedSize-1-1)/2; p >=0 ; p--) {
            //每棵树的调整方案,
            adjustDown(p,this.usedSize);
        }
    }

    /**
     * 入队列
     * 1. 首先按尾插方式放入数组
     * 2. 比较其和其双亲的值的大小，如果双亲的值大，则满足堆的性质，插入结束
     * 3. 否则，交换其和双亲位置的值，重新进行 2、3 步骤
     * 4. 直到根结点
     */
    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while(parent >= 0)
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            } else {
                break;
            }
    }
    public void push(int key) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[usedSize] = key;
        this.usedSize++;
        adjustUp(usedSize-1);
    }
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    /**
     * 操作-出队列（优先级最高）
     * 为了防止破坏堆的结构，删除时并不是直接将堆顶元素删除，而是用数组的最后一个元素替换堆顶元素，
     * 然后通过向下调整方式重新调整成堆
     */
    public void pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("优先级队列为空");
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize-1];
        this.elem[usedSize-1] = tmp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
    }
    private boolean isEmpty() {
        return this.usedSize==0;
    }
    public int getTop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("优先级队列为空");
        }
        return this.elem[0];
    }
}

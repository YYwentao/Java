package SequentialList;

/**
 * ClassName: Test20210410
 * Description:顺序表测试
 * date: 2021/4/10 20:25
 *
 * @author lenovo
 * @since JDK 1.8
 */
public class Test20210410 {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(0,3);
        myArrayList.add(3,4);
        System.out.println("是否包含："+ myArrayList.contains(1));
        System.out.println("查找数的下标为："+ myArrayList.search(2));
        System.out.println("返回下标元素为："+myArrayList.getPos(3));
        myArrayList.setPos(3,0);
        myArrayList.remove(1);
        //myArrayList.clear();
        myArrayList.display();
    }
}

package SequentialList.顺序表1;

/**
 * ClassName: TestList1
 * Description:
 * date: 2021/4/13 12:40
 *
 * @author wentao
 * @since JDK 1.8
 */
public class TestList1 {
    public static void main(String[] args) {
        MyArraylist1 myArraylist1 = new MyArraylist1();
        myArraylist1.add(0,1);
        myArraylist1.add(0,2);
        myArraylist1.add(0,3);
        myArraylist1.add(0,4);
        myArraylist1.add(0,5);
        System.out.println("========================查找===========================");
        myArraylist1.display();
        System.out.println("查找元素下标为："+myArraylist1.search(1));
        System.out.println("查找元素下标为："+myArraylist1.search(3));
        System.out.println("查找元素下标为："+myArraylist1.search(5));
        System.out.println("========================删除===========================");
        myArraylist1.remove(1);
        myArraylist1.remove(5);
        myArraylist1.display();
        System.out.println("========================修改===========================");
        myArraylist1.setPos(0,2);
        myArraylist1.setPos(2,4);
        myArraylist1.display();
    }
}

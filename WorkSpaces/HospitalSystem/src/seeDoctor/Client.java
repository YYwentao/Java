package seeDoctor;

/**
 * ClassName: Client
 * Description:
 * date: 2021/6/24 20:39

 */
public class Client {
    public static void main(String[] args) {
        //消化内科病人看病流程
        //创建对象
        XiaoHuaNeiKe person = new XiaoHuaNeiKe();
        //调用看病这个方法
        person.seeDoctor();
        System.out.println();
        //骨科病人看病流程
        //创建对象
        GuKe person1 = new GuKe();
        person1.seeDoctor();
    }
}

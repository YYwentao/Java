package seeDoctor;

/**
 * ClassName: Finish
 * Description:
 * date: 2021/6/24 20:39

 */
public class Client extends XiaoHuaNeiKe {
    public static void main(String[] args) {
        //消化内科病人看病流程
        //创建对象
        XiaoHuaNeiKe person = new XiaoHuaNeiKe();
        //调用看病这个方法
        person.seeDoctor();
    }
}

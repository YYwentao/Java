package seeDoctor;

/**
 * ClassName: xiaoHuaNeiKe
 * Description:
 * date: 2021/6/24 20:24
 * 消化内科病人挂消化内科
 */
public class XiaoHuaNeiKe extends AbstractClass {

    @Override
    public void register() {
        System.out.println("  1.挂消化内科,选择消化内科1号医生");
    }
}

class XiaoHuaNeiKe1 extends AbstractClass {

    @Override
    public void register() {
        System.out.println("  1.挂消化内科,选择消化内科2号医生");
    }
}


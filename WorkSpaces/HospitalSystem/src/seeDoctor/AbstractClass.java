package seeDoctor;

/**
 * ClassName: AbstractClass
 * Description: 抽象类 (定义模板方法和基本方法)
 * date: 2021/6/24 17:10
    模板方法模式
 */
public abstract class AbstractClass {
    //模板方法定义
    public final void seeDoctor() {
        register();
        diagnose();
        fee();
        cure();
        finishCure();
    }

    //1.挂号(选择诊疗科目,选择医生)
    public abstract void register();
    //2.医生确诊
    public void diagnose() {
        System.out.println("医生确诊");
    }
    //3.付费
    public void fee() {
        System.out.println("缴纳付费单");
    }
    //4.医生治疗
    public void cure() {
        System.out.println("医生治疗");
    }
    //5.结束治疗
    public void finishCure() {
        System.out.println("结束治疗");
    }
}

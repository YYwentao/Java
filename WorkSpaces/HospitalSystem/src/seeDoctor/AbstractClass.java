package seeDoctor;

import historySheet.CureFee;
import historySheet.Fee;
import historySheet.HistorySheet;
import historySheet.OtherFee;

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
        System.out.println("  2.医生确诊");
    }
    //3.付费
    public void fee() {
        System.out.println("  3.缴纳付费单[装饰器模式]");
        HistorySheets();
    }
    //4.医生治疗
    public void cure() {
        System.out.println("  4.医生治疗");
    }
    //5.结束治疗
    public void finishCure() {
        System.out.println("  5.结束治疗");
    }

    //这个方法的主要目的是实现病历单,病例单是由装饰器模式设计,所以想要加其他上面费用,只需要在上面加就好
    public  void HistorySheets() {
        //基础费用(必定存在)
        HistorySheet fee = new Fee();
        System.out.println("        " + fee.getDesc() +" "+ fee.cost()+"元");
        //基础费用+其他费用
        fee = new OtherFee(fee);
        System.out.println("        " + fee.getDesc() +" "+ fee.cost()+"元");
        //基础费用+其他费用+治疗费用
        fee = new CureFee(fee);
        System.out.println("        " + fee.getDesc() +" "+ fee.cost()+"元");
    }
}

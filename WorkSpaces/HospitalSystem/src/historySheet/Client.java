package historySheet;

/**
 * ClassName: Client
 * Description:
 * date: 2021/6/24 23:26
 *

 */
public class Client {
    public static void main(String[] args) {
        //基础费用(必定存在)
        HistorySheet fee = new Fee();
        System.out.println(fee.getDesc() +" "+ fee.cost()+"元");
        System.out.println("=======================");
        //基础费用+其他费用
        fee = new OtherFee(fee);
        System.out.println(fee.getDesc() +" "+ fee.cost()+"元");
        System.out.println("=======================");
        //基础费用+其他费用+治疗费用
        fee = new CureFee(fee);
        System.out.println(fee.getDesc() +" "+ fee.cost()+"元");
        System.out.println("=======================");
    }
}

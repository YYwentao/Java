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
        BasicFee basicFee = new BasicFee();
        System.out.println(basicFee.getDesc() +" "+ basicFee.cost()+"元");
        System.out.println("=======================");
        //+治疗费用
        CureFee cureFee = new CureFee(basicFee);
        System.out.println(cureFee.getDesc() +" "+ cureFee.cost()+"元");
        System.out.println("=======================");
        //+其他费用
        
    }
}

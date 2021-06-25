package historySheet;

/**
 * ClassName: OtherFee
 * Description:
 * date: 2021/6/24 21:46
 *
    +其他费用类(具体其他装饰者角色)
 */
public class OtherFee extends Type{


    public OtherFee(HistorySheet historySheet) {
        super(historySheet, 50.4f, "+其他费用");
    }

    @Override
    public float cost() {
        //重新计算价格
        return super.getPrice() + getHistorySheet().cost();
    }

    @Override
    public String getDesc() {
        //重新描述
        return  getHistorySheet().getDesc() + super.getDesc();
    }
}

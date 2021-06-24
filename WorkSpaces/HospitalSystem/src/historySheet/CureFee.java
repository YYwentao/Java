package historySheet;

/**
 * ClassName: CureFee
 * Description:
 * date: 2021/6/24 21:44
 *
    + 治疗费用类(具体的装饰者角色)
 */
public class CureFee extends Type {

    public CureFee(HistorySheet historySheet) {
        super(historySheet,50,"+治疗费用");
    }

    @Override
    public float cost() {
        //计算价格
        return getPrice() + getHistorySheet().getPrice();
    }

    @Override
    public String getDesc() {
        //重新描述
        return super.getDesc() + getHistorySheet().getDesc();
    }
}

package historySheet;

/**
 * ClassName: BasicFee
 * Description:
 * date: 2021/6/24 21:37
 *
    基础诊疗费
 */
public class BasicFee extends HistorySheet{

    public BasicFee() {
        super(45, "+基础诊疗费");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}

package historySheet;

/**
 * ClassName: Fee
 * Description: 具体构建角色
 * date: 2021/6/24 21:37
 *
    基础诊疗费
 */
public class Fee extends HistorySheet{

    public Fee() {
        super(45, "基础诊疗费");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}

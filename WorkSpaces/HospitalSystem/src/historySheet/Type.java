package historySheet;

/**
 * ClassName: Type
 * Description: 抽象装饰器类
 * date: 2021/6/24 23:02
    装饰器类
 */
public abstract class Type extends HistorySheet{
    //声明病历单类
    private HistorySheet historySheet;

    public HistorySheet getHistorySheet() {
        return historySheet;
    }

    public void setHistorySheet(HistorySheet historySheet) {
        this.historySheet = historySheet;
    }

    public Type(HistorySheet historySheet,float price, String desc) {
        super(price, desc);
        this.historySheet = historySheet;
    }
}

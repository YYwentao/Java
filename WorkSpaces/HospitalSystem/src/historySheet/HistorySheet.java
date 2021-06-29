package historySheet;

/**
 * ClassName: historySheet.HistorySheet
 * Description: 病历单类
 * date: 2021/6/24 21:20
 *
    装饰器模式
 */
public abstract class HistorySheet {
    private float price; //价格
    private String desc; //描述

    public HistorySheet(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public HistorySheet() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    //计算价格
    public abstract float cost();
}

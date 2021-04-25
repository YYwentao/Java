package book;

/**
 * ClassName: Book
 * Description:书的属性
 * date: 2021/4/23 15:02
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Book {

    private String name;//书名
    private String author;//作者
    private int price; //价格
    private String type; //类型
    private boolean flg; //是否借出

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFlg() {
        return flg;
    }

    public void setFlg(boolean flg) {
        this.flg = flg;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((flg == true)? "以借出" : "未借出")+
                '}';
    }
}

package book;

/**
 * ClassName: BookList
 * Description:
 * date: 2021/4/23 15:03
 *  书架
 * @author wt
 * @since JDK 1.8
 */
public class BookList {
    private Book[] books = new Book[10];
    private int usedSize;

    public BookList() {
        books[0] = new Book("三国演义","罗贯中",56,"小说");
        books[1] = new Book("西游记","吴承恩",77,"小说");
        books[2] = new Book("水浒传","施耐庵",66,"小说");
        this.usedSize = 3;
    }

    public void setBooks(int pos,Book book) {
         this.books[pos] = book;
    }

    public Book getBooks(int pos) {
        return this.books[pos];
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}

package operation;

import book.BookList;

/**
 * ClassName: Display
 * Description:显示图书
 * date: 2021/4/23 20:33
 *  显示图书
 * @author wt
 * @since JDK 1.8
 */
public class Display implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            System.out.println(bookList.getBooks(i));
        }
    }
}

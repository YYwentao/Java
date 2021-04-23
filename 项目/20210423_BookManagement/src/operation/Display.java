package operation;

import book.BookList;

/**
 * ClassName: Display
 * Description:
 * date: 2021/4/23 20:33
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Display implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
    }
}

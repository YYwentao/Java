package operation;

import book.BookList;

/**
 * ClassName: Borrow
 * Description:
 * date: 2021/4/23 20:31
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Borrow implements IOpeartion{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
    }
}

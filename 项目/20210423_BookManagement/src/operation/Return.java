package operation;

import book.BookList;

/**
 * ClassName: Return
 * Description:
 * date: 2021/4/23 20:36
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Return implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
    }
}

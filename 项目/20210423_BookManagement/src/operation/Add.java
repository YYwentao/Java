package operation;

import book.BookList;

/**
 * ClassName: Add
 * Description:
 * date: 2021/4/23 20:29
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Add implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
    }
}

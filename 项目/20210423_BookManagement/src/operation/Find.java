package operation;

import book.BookList;

/**
 * ClassName: Find
 * Description:
 * date: 2021/4/23 20:35
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Find implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("查询图书");
    }
}

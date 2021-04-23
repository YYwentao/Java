package operation;

import book.BookList;

/**
 * ClassName: Del
 * Description:
 * date: 2021/4/23 20:32
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Del implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
    }
}

package operation;

import book.BookList;

/**
 * ClassName: Exit
 * Description:
 * date: 2021/4/23 20:34
 *  退出系统
 * @author wt
 * @since JDK 1.8
 */
public class Exit implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}

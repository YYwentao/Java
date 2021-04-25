package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: Find
 * Description:查找图书
 * date: 2021/4/23 20:35
 *
 * @author wt
 * @since JDK 1.8
 */
public class Find implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        System.out.println("请输入书名:");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.nextLine();
        System.out.println();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            //将i下标的这本书放到book里
            Book book = bookList.getBooks(i);
            //取出这个书的书名与要输入的书名bookname比较
            if (book.getName().equals(bookname)) {
                System.out.println("找到这本书：");
                System.out.println(book);
                return;
            }
        }
        //
        System.out.println("没有这本书！！！");
    }
}

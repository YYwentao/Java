package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: Add
 * Description:添加图书
 * date: 2021/4/23 20:29
 *  新增图书
 * @author wt
 * @since JDK 1.8
 */
public class Add implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("新增图书");

        System.out.println("请输入书名：");
        String name = scanner.nextLine();

        System.out.println("请输入作者：");
        String author = scanner.nextLine();

        System.out.println("请输入类型：");
        String type = scanner.nextLine();

        System.out.println("请输入价格：");
        int price = scanner.nextInt();



        int curSize = bookList.getUsedSize();

        Book book = new Book(name,author,price,type);
        int pos = bookList.getUsedSize();
        bookList.setBooks(pos,book);

        bookList.setUsedSize(curSize+1);
        System.out.println("新增成功！");
    }
}

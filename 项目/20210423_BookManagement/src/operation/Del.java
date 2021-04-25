package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: Del
 * Description:
 * date: 2021/4/23 20:32
 *  删除图书
 * @author wt
 * @since JDK 1.8
 */
public class Del implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = scanner.nextLine();

        int pos = -1;

        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("没有这本书！");
            return;
        }
        //有效个数用curSize表示
        int curSize = bookList.getUsedSize();
        for (int i = pos; i < curSize-1; i++) {
            //顺序表删除操作
            //[i] = [i+1]
            Book book = bookList.getBooks(i+1);
            bookList.setBooks(i,book);
        }
        bookList.setUsedSize(curSize-1);
        //curSize的一直没有变化，curSize-1始终表示最后一个有效个数的位置的下标
        //置为空，因为books为数组，存放的为引用类型，需要释放内存
        bookList.setBooks(curSize-1,null);
    }
}

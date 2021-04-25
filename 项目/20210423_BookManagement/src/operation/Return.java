package operation;

import book.BookList;

import java.util.Scanner;

/**
 * ClassName: Return
 * Description:
 * date: 2021/4/23 20:36
 *  归还图书
 * @author wt
 * @since JDK 1.8
 */
public class Return implements IOpeartion {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的书名：");
        String name = scanner.nextLine();
        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            if (bookList.getBooks(i).getName().equals(name)) {
                bookList.getBooks(i).setFlg(false);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("没有这本书！！！");
    }
}

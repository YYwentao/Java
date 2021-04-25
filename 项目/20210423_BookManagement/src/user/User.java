package user;

import book.BookList;
import operation.IOpeartion;

/**
 * ClassName: User
 * Description:
 * date: 2021/4/23 19:22
 * @author wt
 * @since JDK 1.8
 */
public abstract class User {

    public String name;

    //1.准备一个接口数组 存储每一个对象
    public IOpeartion[] IOpeartions;

    public User(String name) {
     this.name = name;
    }
    public abstract int menu();

    //3.
    public void doOpeartion(int choice, BookList bookList) {
        this.IOpeartions[choice].work(bookList);
    }
}

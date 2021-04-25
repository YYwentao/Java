package user;

import operation.*;

import java.util.Scanner;

/**
 * ClassName: AdminUser
 * Description:
 * date: 2021/4/23 20:40
 *  管理员
 * @author wt
 * @since JDK 1.8
 */
public class AdminUser extends User{
    public AdminUser(String name) {
        super(name);
        this.IOpeartions = new IOpeartion[] {
                new Exit(),
                new Find(),
                new Add(),
                new Del(),
                new Display(),
        };
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======" + "Hello " +this.name + "=======");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("========================================");

        int choice = scanner.nextInt();
        return choice;
    }
}

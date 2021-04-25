package user;

import operation.*;

import java.util.Scanner;

/**
 * ClassName: NormalUser
 * Description:
 * date: 2021/4/23 20:41
 *  普通用户
 * @author wentao
 * @since JDK 1.8
 */
public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.IOpeartions = new IOpeartion[] {
                new Exit(),
                new Find(),
                new Borrow(),
                new Return()
        };
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======" + "Hello "+this.name + "=======");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("========================================");

        int choice = scanner.nextInt();
        return choice;
    }
}

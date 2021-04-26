import java.util.Objects;
import java.util.Scanner;

/**
 * ClassName: Test20210426
 * Description:
 * date: 2021/4/26 13:10
 *
 * @author wt
 * @since JDK 1.8
 */


/**
 * 这是自定义异常
 *
 */
class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}
class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class Test20210426 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String userName1 = scanner.nextLine();
        System.out.println("请输入密码：");
        int password1 = scanner.nextInt();

        try {
            login(userName1, password1);
        } catch (UserException e) {
            e.printStackTrace();
        } catch (PasswordException e) {
            e.printStackTrace();
        }
    }
    public static void login(String userName1, int password1) throws UserException, PasswordException {

        String userName = "wentao";

        int password = 0000000;
        if (!userName.equals(userName1)) {
            throw new UserException("用户名错误");
        }
        if (password != password1) {
            throw new PasswordException("密码错误");
        }
        System.out.println("登陆成功");

    }

}

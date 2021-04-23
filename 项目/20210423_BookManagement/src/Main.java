import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * date: 2021/4/23 21:16
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Main {

    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入姓名:");
        String name = scanner.nextLine();
    }

    public static void main(String[] args) {
        login();
    }
}

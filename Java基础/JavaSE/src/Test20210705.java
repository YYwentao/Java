import java.util.Scanner;

/**
 * ClassName: Test20210705
 * Description:
 * date: 2021/7/5 22:32
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210705 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            char[] array = str.toCharArray();
            System.out.println(reverse(array,0,str.length()-1));
        }
    }

    public static String reverse(char[] array, int start, int end) {
        while(start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
        return new String(array);
    }
}

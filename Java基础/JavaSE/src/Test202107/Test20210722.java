package Test202107;

import java.util.Scanner;

/**
 * ClassName: Test20210722
 * Description:
 * date: 2021/7/22 10:13
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210722 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = Integer.parseInt(scan.nextLine());
            String result = "";
            String[] arr = new String[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextLine();
            }
            for(int i = 0; i < n; i++) {
                String str = arr[i];
                if(str.contains(",")|| str.contains(" ")) {
                    result += "\""+str+"\""+", ";
                } else {
                    result += str+", ";
                }
            }
            System.out.println(result.substring(0,result.length()-2));
        }
    }
}

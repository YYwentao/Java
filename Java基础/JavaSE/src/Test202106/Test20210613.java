package Test202106;

import java.util.Scanner;

/**
 * ClassName: Test20210613
 * Description:
 * date: 2021/6/13 12:52
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210613 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            System.out.println(isMatch(str1+" ",str2+" "));
    }
    public static boolean isMatch(String str1,String str2) {
        int s1 = 0;
        int e1 = str1.length()-1;
        int s2 = 0;
        int e2 = str2.length()-1;
        while(s2 <= e2 && s1 <= e1) {
            //如果字符相同或者一个字符为通配符'?'，都加一
            if(str1.charAt(s1) == str2.charAt(s2) || str1.charAt(s1) == '?') {
                s1++;
                s2++;
            } else if(str1.charAt(s1) != '*') {
                return false;
            }
            if(str1.charAt(s1) == '*') {
                s1++;
                if(str1.charAt(s1) == ' '){
                    return true;
                } else {
                    while(str1.charAt(s1) != str2.charAt(s2)) {
                        s2++;
                    }
                }
            }
        }
        return true;
    }
}

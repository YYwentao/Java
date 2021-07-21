package Test202107;

import java.util.Scanner;

/**
 * ClassName: Tset20210721
 * Description:
 * date: 2021/7/21 22:20
 *
 * @author wt
 * @since JDK 1.8
 */
public class Tset20210721 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            String[] arr = str.split(" ");
            String s = arr[0];
            String t = arr[1];
            int sLen = s.length();
            int tLen = t.length();
            int count = 0;
            if(sLen < tLen) {
                System.out.println(0);
                return;
            }
            int i = 0;
            String s1 = s;
            while(i < sLen-tLen+1) {
                if((s1.substring(i,i+tLen)).equals(t)) {
                    count++;
                    i += tLen;
                    s1 = s;
                } else{
                    i++;
                }
            }
            System.out.println(count);
        }
    }
}

package Test202106;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: Test20210628
 * Description:
 * date: 2021/6/28 15:47
 *
 * @author wt
 * @since JDK 1.8
 */

public class Test20210628 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //while(scan.hasNext()) {
        Map<Character,Integer> map = new HashMap<>();
        String str = scan.nextLine();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.get(ch) == null) {
                map.put(ch,1);
            } else {
                map.put(ch,map.get(ch)+1);
            }
        }
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.get(ch) == 1) {
                System.out.println(ch);
                break;
            }
        }
        System.out.println(-1);
        //}
    }
}

package Test202106;

import java.util.HashSet;
import java.util.Scanner;

/**
 * ClassName: Test20210606
 * Description:
 * date: 2021/6/6 11:35
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210606 {

    public static int add(int a, int b){
        try {
            return a+b;
        }
        catch (Exception e) {
            System.out.println("catch语句块");
        }
        finally{
            System.out.println("finally语句块");
        }
        return 0;
    }
    public static void main1(String argv[]){
        Test20210606 test =new Test20210606();
        System.out.println("和是："+ Test20210606.add(9, 34));
    }

    public static void main2(String[] args) {
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6= b4+b5;
        b3= (byte) (b1+b2);
        System.out.println(b3+b6);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < strs.length; i++) {
            if(!set.contains(strs[i])) {
                set.add(strs[i]);
                count++;
            } else {
                count++;
            }
        }
        System.out.println(count);
        for(String s : set) {
            System.out.println(s);
        }
    }
}

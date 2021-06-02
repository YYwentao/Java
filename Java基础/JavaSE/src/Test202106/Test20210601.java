package Test202106;

import java.util.Scanner;

/**
 * ClassName: Test20210601
 * Description:
 * date: 2021/6/1 17:27
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210601 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] array = new String[n];
        for(int i = 0; i < n; i++) {
            array[i] = scan.nextLine();
        }
        //字典序
        boolean flg1 = Graphical(array);
        //长度排序
        boolean flg2 = Lengths(array);
        if(flg1 == true && flg2 == true) {
            System.out.println("both");
        } else if(flg1 == true) {
            System.out.println("lexicographically");
        } else if(flg2 == true) {
            System.out.println("lengths");
        } else {
            System.out.println("none");
        }
    }
    //字典序
    public static boolean Graphical(String[] array) {
        for(int i = 0 ; i < array.length-1; i++) {
            String str1 = array[i];
            String str2 = array[i+1];
            //比较两个字符串的字典排序
            if(ComperateTow(str1,str2)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    //长度排序
    public static boolean Lengths(String[] array) {
        for(int i = 0; i < array.length-1; i++) {
            if(array[i].length() > array[i+1].length()) {
                return false;
            }
        }
        return true;
    }
    public static boolean ComperateTow(String str1,String str2) {
        int s1 = 0;
        int s2 = 0;
        int e1 = str1.length();
        int e2 = str2.length();
        while(s1 < e1 && s2 < e2) {
            char ch1 = str1.charAt(s1);
            char ch2 = str2.charAt(s2);
            if(ch1 == ch2) {
                s1++;
                s2++;
            } else if(ch1 < ch2){
                return true;
            } else {
                return false;
            }
        }
        if(s1 == e1) {
            return true;
        }
        if(s2 == e2) {
            return false;
        }
        return true;
    }
}

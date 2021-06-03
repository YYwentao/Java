package 每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: Day08
 * Description:
 * date: 2021/6/3 15:52
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day08 {
    /**
     * 两种排序方法
     */
    public static void main(String[] args) throws IOException {
        BufferedReader re=new BufferedReader(new InputStreamReader(System.in));
        int number=Integer.parseInt(re.readLine());
        String[] arr = new String[number];
        for(int i = 0; i < number; i++) {
            arr[i]=re.readLine();
        }
        if(isSortDiXu(arr) && isSortLength(arr)) {
            System.out.println("both");
        } else if (isSortDiXu(arr)) {
            System.out.println("lexicographically");
        } else if (isSortLength(arr)) {
            System.out.println("lengths");
        } else {
            System.out.println("none");
        }
    }
    public static boolean isSortDiXu(String[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSortLength(String[] arr) {
        for(int i = 0; i < arr.length-1; i++ ) {
            if(arr[i].length() > arr[i+1].length()) {
                return false;
            }
        }
        return true;
    }
}

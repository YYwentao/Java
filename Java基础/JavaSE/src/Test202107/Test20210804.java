package Test202107;
import java.util.*;

/**
 * ClassName: Test20210804
 * Description:
 * date: 2021/8/4 21:02
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210804 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        String str = scan.nextLine();
        String[] allPrint = str.split(" ");//全部分割
        int len = allPrint.length; //总长度
        int n = Integer.parseInt(allPrint[0]);// 输入了多少个单词
        String strLast = allPrint[len-2]; //根据这个单词找那些是它的兄弟单词
        int r = Integer.parseInt(allPrint[len-1]); // 输出兄弟单词中按照字典序排列的第几个单词，没有就输出0
        for(int i = 1; i <= len - 3; i++) {
            if(strLast.equals(allPrint[i])) {
                continue;
            } else {
                String tmp = strLast;
                char[] arr1 = tmp.toCharArray();
                Arrays.sort(arr1);
                String tmp2 = allPrint[i];
                char[] arr2 = tmp2.toCharArray();
                Arrays.sort(arr2);
                if((new String(arr1)).equals(new String(arr2))) {
                    list.add(allPrint[i]);
                }
            }
        }
        //用于字典排序
        //for(String s : set) {
        //    list.add(s);
        //}
        System.out.println(list.size());//输出多少个
        Collections.sort(list);
        if(list.size() < r ) {
            System.out.println(0);
        } else {
            for(int i = 0; i < list.size(); i++) {
                if(i == r-1) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}

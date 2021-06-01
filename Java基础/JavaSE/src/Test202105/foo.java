package Test202105;

/**
 * ClassName: foo
 * Description:
 * date: 2021/5/30 12:32
 *
 * @author wt
 * @since JDK 1.8
 */
public class foo {
    public static int StrToInt(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();
        int flg = 1;
        if(array[0] == '+') {
            array[0] = '0';
            flg = 1;
        } else if (array[0] == '-') {
            array[0] = '0';
            flg = -1;
        } else {
            ;
        }
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < '0' || array[i] > '9' ) {
                return 0;
            }
            count = count * 10 + (array[i] -'0');
        }
        return count*flg;
    }

    public static void main(String[] args) {
        StrToInt("+2147483647");
    }

}

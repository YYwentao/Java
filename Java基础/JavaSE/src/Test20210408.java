import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: Test20210407
 * Description:数组的创建和使用等_作业
 * date: 2021/4/8 9:25
 *
 * @author lenovo
 * @since JDK 1.8
 */
public class Test20210408 {
    public static void main(String[] args) {
        //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
        int[] arr = new int[100];
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=j;
            j++;
            System.out.print(arr[i]+" ");
        }
    }


    public static void main1(String[] args) {
        int[] arr = new int[]{1,2,3};
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}

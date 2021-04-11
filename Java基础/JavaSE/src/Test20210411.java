import java.util.Arrays;

/**
 * ClassName: Test20210411
 * Description:
 * date: 2021/4/11 20:25
 *
 * @author lenovo
 * @since JDK 1.8
 */
public class Test20210411 {

    public static void main(String args[]) {
        //给定两个整型数组, 交换两个数组的内容
        int[] arr1 = {1,1,1,1,1,1};
        int[] arr2 = {2,2,2,2,2,2};
        ExArray(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void ExArray(int [] arr1,int[] arr2) {
        int tmp = 0;
        for (int i = 0; i <arr1.length ; i++) {
                tmp=arr1[i];
                arr1[i] =arr2[i];
                arr2[i] = tmp;
        }
    }
}

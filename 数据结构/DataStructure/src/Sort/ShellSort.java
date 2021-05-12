package Sort;

/**
 * ClassName: ShellSort
 * Description:
 * date: 2021/5/12 19:37
 *  希尔排序
 * @author wt
 * @since JDK 1.8
 */
public class ShellSort {
    public static void main(String[] args) {
       
    }

    private static void shellSort(int[] array) {
        int[] arr = {5,3,1};
        for (int i = 0 ;i <arr.length; i++) {
            shell(array, arr[i]);
        }
    }

    private static void shell(int[] array, int i) {
    }
}

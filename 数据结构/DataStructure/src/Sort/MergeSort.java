package Sort;

import java.util.Arrays;

/**
 * ClassName: MergeSort
 * Description: 归并排序
 * date: 2021/5/14 21:43
 *
 时间复杂度：O(n * log(n))
 空间复杂度：O(n)
 稳定性：稳定
 */
public class MergeSort {
    public static void mergeSort(int[] array) {
        mergeSortRecursion(array,0,array.length-1);
    }
    //先递归，分多个组
    public static void mergeSortRecursion(int[] array,int low,int high) {
        //递归的结束条件
        if (low >= high) {
            return;
        }
        int mid = (low + high)>>>1;
        mergeSortRecursion(array,low,mid);
        mergeSortRecursion(array,mid+1,high);
        //进行合并
        mergeSortRet(array,low,mid,high);
    }
    //是每两个数组合并为一个数组的问题
    private static void mergeSortRet(int[] array,int low,int mid,int high) {
        int[] tmpArray = new int[high-low+1];   //申请一个数组用来存放合并后的排序数据
        int k = 0;  //tmpArray的下标
        int s1 = low;
        int e1= mid;

        int s2 = mid+1;
        int e2 = high;

        while(s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tmpArray[k++] = array[s1++];
            } else {
                tmpArray[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmpArray[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArray[k++] = array[s2++];
        }
        for (int i = 0; i <tmpArray.length; i++) {
            array[i + low ] = tmpArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

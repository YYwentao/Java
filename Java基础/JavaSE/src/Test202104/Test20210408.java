package Test202104;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ClassName: Test202104.Test20210408
 * Description:数组的创建和使用等_作业
 *
 * date: 2021/4/8 9:25
 *
 * @author lenovo
 * @since JDK 1.8
 */
public class Test20210408 {
    //数组拷贝
    public static int[] copyOf(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            ret[i] = array[i];
        }
        return ret;
    }
    public static void main7(String[] args) {
        /**
         * 数组的克隆：
         * Arrays.copyOf(int[] original, int newLength)
         * original:要拷贝的数组
         * newLength：拷贝后新的长度
         * @param args
         */
        int[] array = new int[]{1,2,3,4,5,5};
        int[] ret = copyOf(array);
        System.out.println(Arrays.toString(ret));
    }

    //数组转字符串
    public static String toString(int[] array) {
        String ret ="[";
        for (int i = 0; i <array.length ; i++) {
            ret=ret+array[i];
            if(i != array.length-1) {
                ret+=",";
            }

        }
        return ret+"]";
    }
    public static void main6(String[] args) {
        int[] array=new int[]{1,2,3,4,5,6,5,6};
        String tmp = toString(array);
        System.out.println(tmp);
    }

    //判断数组是否有序
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(isSorted(array));
    }

    //优化后冒泡排序
    public static void bubbleSort1(int[] array) {

        for (int i = 0; i <array.length-1; i++) {
            boolean flg = false;//默认每一趟都是没有有序的
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =tmp;
                    flg = true;
                }
            }
            if (flg == false) {
                break;
            }
        }
    }
    public static void main4(String[] args) {
        //冒泡
        int[] array = {6,5,10,3,9};
        System.out.println(Arrays.toString(array));
        bubbleSort1(array);
        System.out.println(Arrays.toString(array));
    }

    //顺序二分查找
    public static int binarySearch(int[] array,int key) {
        int i = 0;
        int j = array.length-1;
        while (i<=j) {
            int mid = (i+j)/2;
            if (key>array[mid]) {
                i = mid+1;
            } else if (key<array[mid]) {
                j = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main3(String[] args) {
        int[] array = {1,3,5,6,7};
        System.out.println("查找的的数下标为："+binarySearch(array,7));
    }


    public static void main2(String[] args) {
        //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
        int[] arr = new int[100];
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=j;
            j++;
            System.out.print(arr[i]+" ");
        }
    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main1(String[] args) {
        int[] arr = new int[]{1,2,3};
        printArray(arr);
    }

}

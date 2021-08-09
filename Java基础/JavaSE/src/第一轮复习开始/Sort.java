package 第一轮复习开始;


import java.util.Arrays;


/**
 * ClassName: Sort
 * Description: 八大排序
 * date: 2021/8/9 10:16
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,5,9,6,7,4,56,78,90,66};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        int[] arr1 = new int[]{1,3,5};
//        for (int i = 0; i < arr1.length; i++) {
//            shellSort(arr,arr1[i]);
//        }
//        System.out.println(Arrays.toString(arr));

//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));

        //堆排序
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
    }

    ////堆排序
    private static void heapSort(int[] arr) {
        // 1.创建大堆
        createBigHeap(arr);
        // 2.排序
        int last = arr.length-1;
        while (last > 0) {
            int tmp = arr[0];
            arr[0] = arr[last];
            arr[last] = tmp;
            // 交换堆顶最大值和对最后一个值后,再次从调整为大堆
            adjust(arr,0,last);

            last--;
        }
    }

    private static void createBigHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
            adjust(arr,i,arr.length);
        }
    }

    private static void adjust(int[] arr, int parent, int len) {
        int child = parent*2 + 1;
        while (child < len) {
            if (child+1 < len && arr[child] < arr[child+1]) {
                child = child+1;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = parent*2+1;
            } else {
                break;
            }
         }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //希尔排序
    public static void shellSort(int[] arr,int k) {
        for (int i = k; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - k;
            for (; j >=0 ; j=j-k) {
                if (arr[j] > tmp) {
                    arr[j+k] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+k] = tmp;
        }
    }

    //直接插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= 0 ;j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }
}

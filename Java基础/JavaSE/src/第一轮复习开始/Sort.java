package 第一轮复习开始;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;


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
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));

//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        //快速排序
//        Random random = new Random();
//        int[] arr = new int[10_000];
//        for (int i = 0; i < 10_000; i++) {
//            arr[i] = random.nextInt(1000)+1;
//        }
//        System.out.println(Arrays.toString(arr));
//        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
        //非递归快排
//        quickSort2(arr);
//        System.out.println(Arrays.toString(arr));
        //归并排序
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //归并排序
    private static void mergeSort(int[] arr) {
        merge(arr,0,arr.length-1);
    }


    private static void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left+right) >>> 1;
        merge(arr,left,mid);
        merge(arr,mid+1,right);
        //合并
        mergeRet(arr,left,mid,right);
    }

    private static void mergeRet(int[] arr, int left, int mid, int right) {
        int[] tmpArr = new int[right-left+1];
        int k = 0;
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        while (s1 <= e1 && s2 <= e2) {
            if (arr[s1] <= arr[s2]) {
                tmpArr[k++] = arr[s1++];
            } else {
                tmpArr[k++] = arr[s2++];
            }
        }
        while(s1 <= e1) {
            tmpArr[k++] = arr[s1++];
        }
        while (s2 <= e2) {
            tmpArr[k++] = arr[s2++];
        }
        for (int i = 0; i < tmpArr.length; i++) {
            arr[left+i] = tmpArr[i];
        }
    }

    ////非递归快排
    private static void quickSort2(int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        int par = partion(arr,left,right); //找 基准
        Stack<Integer> stack = new Stack<>();
        if (par > left+1) {
            stack.push(left);
            stack.push(par-1);

        }
        if (par < right-1) {
            stack.push(par+1);
            stack.push(right);
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            par = partion(arr,left,right);
            if (par > left+1) {
                stack.push(left);
                stack.push(par-1);

            }
            if (par < right-1) {
                stack.push(par+1);
                stack.push(right);
            }
        }
    }

    //递归快排
    private static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int par = partion(arr,left,right);  //找基准
        quick(arr,left,par - 1);
        quick(arr,par + 1,right);
    }

    private static int partion(int[] arr, int s, int e) {
        int tmp = arr[s];
        while (s < e) {
            while (s < e && arr[e] >= tmp) {
                e--;
            }
            if (s >= e) {
                arr[s] = tmp;
                break;
            } else {
                arr[s] = arr[e];
            }

            while (s < e && arr[s] <= tmp) {
                s++;
            }
            if (s >= e) {
                arr[s] = tmp;
                break;
            } else {
                arr[e] = arr[s];
            }
        }
        return s;
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

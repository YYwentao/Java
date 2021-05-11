package Heap;

import java.util.Arrays;

/**
 * ClassName: TestBigHead
 * Description:
 * date: 2021/5/11 15:35
 * @author wt
 * @since JDK 1.8
 */
public class TestBigHead {
    public static void main(String[] args) {
        BigHeap bigHeap = new BigHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        bigHeap.createHeap(array);
        bigHeap.push(50);
        bigHeap.pop();
        System.out.println(Arrays.toString(bigHeap.elem));
    }
}

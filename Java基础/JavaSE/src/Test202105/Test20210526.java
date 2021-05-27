package Test202105;

import java.util.HashMap;

/**
 * ClassName: Test20210526
 * Description:
 * date: 2021/5/26 9:15
 *
 * @author wt
 * @since JDK 1.8
 */
class Test_1 {

    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = array.length / 2;//4

        for(int i = 0; i < array.length ; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i],1);
            } else{
                map.put(array[i],map.get(array[i]) + 1);
            }
        }
        int number = 0;
        for(int i = 0; i< array.length; i++) {
            number = Math.max(map.get(array[i]),number);//5
        }
        return number > n? 2 : 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int num =  MoreThanHalfNum_Solution(array);
        System.out.println(num);
    }
}

public class Test20210526 {

}

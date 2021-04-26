/**
 * ClassName: Test1_20210426
 * Description:
 * date: 2021/4/26 22:23
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test1_20210426 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(canThreePartsEqualSum(arr));
    }
    //3. 将数组分成和相等的三个部分
    public static boolean canThreePartsEqualSum(int[] arr) {
            int sum = 0;
            for(int i = 0 ; i <arr.length; i++) {
                sum += arr[i] ;
            }
            if(sum%3 != 0) {
                return false;
            }
            // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段
            // 找到2段后就返回true,因为能走到这里的的话，一定说明能够被平分成三段（i只能到数组A的倒数第二个元素，保证了有第3段）
            int curSum = 0;
            int cur = 0;
            for(int i = 0;i<arr.length-1 ;i++) {
                curSum += arr[i];
                if( curSum == (sum/3) ) {
                    cur++;
                    if(cur == 2) {
                        return true;
                    }
                    curSum = 0;
                }
            }
            return false;
    }
}

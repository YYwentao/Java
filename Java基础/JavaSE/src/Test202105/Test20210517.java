package Test202105;

import java.util.HashMap;

/**
 * ClassName: Test20210517
 * Description:
 * date: 2021/5/17 16:10
 *
 * @author wt
 * @since JDK 1.8
 */
class Test20210517 {
}
//
class Test{
    public String name="abc";
    public static void main(String[] args){
        Test test=new Test();
        Test testB=new Test();
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
    }
}
//
 class TestObj{
    public static void main(String[] args){
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
}
class Solution_387 {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if (hashMap.get(ch) == null) {
                hashMap.put(ch,1);
            } else {
                hashMap.put(ch,hashMap.get(ch) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
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

class Solution_165 {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int index1 = 0;
        int index2 = 0;
        while(index1 < len1 || index2 < len2) {
            if(index1 < len1 && version1.charAt(index1) == '.') {
                index1++;
            }
            if(index2 < len2 && version2.charAt(index2) == '.') {
                index2++;
            }
            int sum1 = 0;
            int sum2 = 0;
            while(index1 < len1 && version1.charAt(index1) !='.') {
                sum1 = sum1*10 + version1.charAt(index1) - '0';
                index1++;
            }
            while(index2 < len2 && version2.charAt(index2) !='.') {
                sum2 = sum2*10 + version2.charAt(index2) - '0';
                index2++;
            }
            if (sum1!=sum2)
                return sum1<sum2?-1:1;
        }
        return 0;
    }
}

class Solution_349 {



}



















package Test202105;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: Test20210520
 * Description:
 * date: 2021/5/20 10:54
 *
 * @author wt
 * @since JDK 1.8
 */
public class Test20210520 {
    class Solution_819 {
        public String mostCommonWord(String paragraph, String[] banned) {

            HashSet<String> banSet = new HashSet<>();
            for(String s : banned){
                banSet.add(s);
            }
            HashMap<String,Integer> map = new HashMap<>();
            paragraph = paragraph.replace(",", " ").replace(".", " ").replace("!", " ").replace("?", " ").replace(";", " ").replace("'", " ");
            for(String s : paragraph.split("\\s+")){
                s = s.toLowerCase();
                if(banSet.contains(s)) continue;
                if(map.containsKey(s)){
                    map.put(s,map.get(s) + 1);
                }else{
                    map.put(s, 1);
                }
            }
            int max = 0;
            String maxString = "";
            for(String s : map.keySet()){
                if(map.get(s) > max){
                    max = map.get(s);
                    maxString = s;
                }
            }
            return maxString;
        }
    }

    class Solution_217 {
        public boolean containsDuplicate(int[] nums) {
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int i = 0;i < nums.length; i++) {
                if(hashMap.get(nums[i]) == null) {
                    hashMap.put(nums[i],1);
                } else {
                    hashMap.put(nums[i],hashMap.get(nums[i]) + 1);
                }
            }

            for(int i = 0 ;i < nums.length; i++) {
                if(hashMap.get(nums[i])  > 1) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution_389 {
        public char findTheDifference(String s, String t) {
            int[] array = new int[26];
            for(int i = 0 ;i < s.length(); i++) {
                char ch = s.charAt(i);
                array[ ch - 97]++;
            }
            for(int i = 0 ;i <t.length(); i++) {
                char ch = t.charAt(i);
                array[ch - 97]--;
                if(array[ch - 97] < 0) {
                    return ch;
                }
            }
            return ' ';
        }
    }
}

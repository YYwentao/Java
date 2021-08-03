package Test202107;

import java.util.*;

/**
 * ClassName: Day20210802
 * Description:
 * date: 2021/8/2 13:50
 *
 * @author wt
 * @since JDK 1.8
 */
public class Day20210802 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            scan.nextLine();
            ArrayList<String> list=new ArrayList<>();
            Set<String> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                String str = scan.nextLine();
                StringBuffer sb = new StringBuffer();
                char[] chars = str.replace("-","").toCharArray();
                for(int j = 0; j < chars.length; j++) {
                    if(j == 3) {
                        sb.append("-");
                    }
                    if(chars[j] == '1') {
                        sb.append("1");
                    }else if (chars[j] == '2' || chars[j] == 'A' || chars[j] == 'B' || chars[j] == 'C') {
                        sb.append("2");
                    }else if (chars[j] == '3' || chars[j] == 'D' || chars[j] == 'E' || chars[j] == 'F') {
                        sb.append("3");
                    }else if (chars[j] == '4' || chars[j] == 'G' || chars[j] == 'H' || chars[j] == 'I') {
                        sb.append("4");
                    }else if (chars[j] == '5' || chars[j] == 'J' || chars[j] == 'K' || chars[j] == 'L') {
                        sb.append("5");
                    }else if (chars[j] == '6' || chars[j] == 'M' || chars[j] == 'N' || chars[j] == 'O') {
                        sb.append("6");
                    }else if (chars[j] == '7' || chars[j] == 'P' || chars[j] == 'Q' || chars[j] == 'R' || chars[j] == 'S') {
                        sb.append("7");
                    }else if (chars[j] == '8' || chars[j] == 'T' || chars[j] == 'U' || chars[j] == 'V') {
                        sb.append("8");
                    }else if (chars[j] == '9' || chars[j] == 'W' || chars[j] == 'X' || chars[j] == 'Y' || chars[j] == 'Z') {
                        sb.append("9");
                    } else if(chars[j] == '0') {
                        sb.append("0");
                    }
                }
                set.add(new String(sb));
            }
            for (String s : set) {
                list.add(s);
            }
            Collections.sort(list);


            for (int i = 0; i <list.size() ; i++) {
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }



        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            char[] arr = str.toCharArray();
            int i = 0;
            int len = arr.length;
            while(i < len) {
                int j = i;
                if( j < len && (arr[j] < 'a' || arr[j] > 'z') && (arr[j] < 'A' || arr[j] > 'Z')) {
                    arr[j] = ' ';
                    i++;
                    j++;
                }
                while( j < len && ((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z'))) {
                    j++;
                }
                if(j == len) {
                    reverseWord(arr,i,j-1);
                    i = j + 1;
                } else {
                    arr[j] = ' ';
                    reverseWord(arr,i,j-1);
                    i = j + 1;
                }
            }
            reverseWord(arr,0,len-1);
            System.out.println(new String(arr));
        }

        public static void reverseWord(char[] arr,int i,int j) {
            while (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
}

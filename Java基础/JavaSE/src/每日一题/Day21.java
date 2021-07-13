package 每日一题;

import java.util.Scanner;

/**
 * ClassName: Day21
 * Description:
 * date: 2021/7/12 13:50
 */
public class Day21 {
    /**
     *  洗牌
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();//表示组数
        for(int i = 0; i < t; i++) {
            int n = scan.nextInt();//表示 2n 的一半牌
            int k = scan.nextInt();//洗牌次数
            int[] cards = new int[n*2];
            //发牌
            for(int j = 0; j < n*2; j++) {
                cards[j] = scan.nextInt();
            }
            //洗牌
            playCard(cards,n,k);
        }
    }
    public static void playCard(int[] cards,int n,int k) {
        for(int i = 0; i < k; i++) {
            //表示洗牌一次的过程
            int[] newCards = new int[cards.length];
            for(int j = 0; j < n; j++) {
                // j ==> 2 * j
                // j + n ==> 2 * j + 1
                newCards[2 * j] = cards[j];
                newCards[2 * j + 1] = cards[j + n];
            }
            cards = newCards;
        }
        //打印
        printCard(cards);
    }

    public static void printCard(int[] newCards) {
        for(int j =0 ; j < newCards.length-1; j++) {
            System.out.print(newCards[j]+" ");
        }
        System.out.println(newCards[newCards.length-1]);
    }

    /**
     * 题目ID:36888-MP3光标位置
     */
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            //歌曲数量
            String num = scan.nextLine();
            int n = Integer.parseInt(num);
            String str = scan.nextLine();
            //指令数组
            char[] order = str.toCharArray();
            mouseMove(n,order);
        }
    }

    public static void mouseMove(int n,char[] order) {
        //显示鼠标当前的位置
        int mouse = 1;
        //显示列表所在的起始位置
        int first = 1;
        //指令处理(歌曲小于 4 和 大于 4 两种情况)
        if(n <= 4) {
            for(int i = 0; i < order.length; i++) {
                if(mouse == 1 && first == 1 && order[i] == 'U') {
                    mouse = n;
                } else if(mouse == 4 && first == 1 && order[i] == 'D') {
                    mouse = 1;
                } else if(order[i] == 'U') {
                    mouse--;
                } else if(order[i] == 'D') {
                    mouse++;
                }
            }
            for(int i = 1; i < n; i++) {
                System.out.print(i+" ");
            }
            System.out.println(n);
            System.out.println(mouse);
        } else {
            for(int i = 0; i < order.length; i++) {
                if(mouse == 1 && first == 1 && order[i] == 'U') {
                    first = n - 3;
                    mouse = n;
                } else if(mouse == n && first == n-3 && order[i] == 'D') {
                    first = 1;
                    mouse = 1;
                } else if(first != 1 && mouse == first && order[i] == 'U') {
                    first--;
                    mouse--;
                } else if(first != n-3 && mouse == first + 3 && order[i] == 'D') {
                    first++;
                    mouse++;
                } else if(order[i] == 'U') {
                    mouse--;
                } else if(order[i] == 'D') {
                    mouse++;
                }
            }
            for(int i = first; i < first+3; i++) {
                System.out.print(i+" ");
            }
            System.out.println(first+3);
            System.out.println(mouse);
        }
    }
}

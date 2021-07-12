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
    
}

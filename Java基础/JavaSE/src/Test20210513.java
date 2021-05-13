import java.util.Comparator;
import java.util.Objects;

/**
 * ClassName: Test20210513
 * Description:
 * date: 2021/5/13 11:18
 *
 * @author wt
 * @since JDK 1.8
 */


class Card implements Comparable<Card> {
    public int rank;//数值
    public String suit;//花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return ((Card) o).rank == this.rank
                ;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }
}
public class Test20210513 {


    public static void main(String[] args) {
        Card c1= new Card(3,"♥");
        Card c2= new Card(2,"♥");
        System.out.println(c1.compareTo(c2));

    }

    //重写equals比较
    public static void main1(String[] args) {
        Card c1= new Card(2,"♥");
        Card c2= new Card(2,"♥");
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);
    }
}

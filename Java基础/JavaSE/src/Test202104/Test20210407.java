package Test202104;

/**
 * ClassName: Test202104.Test20210407
 * Description:青蛙跳台阶问题,递归求解汉诺塔问题
 * date: 2021/4/7 20:25
 * @author lenovo
 * @since JDK 1.8
 */
public class Test20210407 {
    public static void main(String[] args) {
        //递归求解汉诺塔问题
        /** 1    A->C          (2^n)-1
         * 2    A->B   A->C   B->C
         * 3    A->C   A->B   C->B   A->C  B->A  B->C A->C
         */
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
    }

    /**
     *
     * @param n     盘子的个数
     * @param pos1  起始位置
     * @param pos2  中转位置
     * @param pos3   目的地
     */
    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if (n==1) {
            move(pos1,pos3);
        } else{
            hanoi(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanoi(n-1,pos2,pos1,pos3);
        }
    }

    public static void move(char pos1,char pos2) {
        System.out.print(pos1+"=>"+pos2+" ");
    }


    public static void main1(String[] args) {
        System.out.println(dancestep(2));
        System.out.println(dancestep(3));
        System.out.println(dancestep(4));
    }

    public static int dancestep(int n) {
        //青蛙跳台阶
        if (n==1 || n==2) {
            return n;
        } else {
            return dancestep(n-1) + dancestep(n-2);
        }
    }
}

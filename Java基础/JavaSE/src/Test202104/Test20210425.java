package Test202104;

/**
 * ClassName: Test202104.Test20210425
 * Description:
 * date: 2021/4/25 18:32
 *
 * @author wentao
 * @since JDK 1.8
 */
public class Test20210425 {


    public static void main(String[] args){
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
    }
}

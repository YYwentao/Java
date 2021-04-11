import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){

        //System.out.println("hello world");
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
//        scanner.nextDouble();
//        //读取字符串到空格符就结束
//        scanner.next();
//        //读取字符串到换行符就结束
//        scanner.nextLine();

        //读取若干个整1数之和
//        int sum =0;
//        while(scanner.hasNext()){
//            int num =scanner.nextInt();
//            sum += num;
//        }
//        System.out.println(sum);



        //猜数字
        //1.随机生成一个1-100的数
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        int toguess = random.nextInt(100)+1;
//        while (true) {
//            System.out.println("请输如一个要猜的数字[1,100]");
//            int num = scanner.nextInt();
//            if (toguess>num){
//                System.out.println("低了");
//            }else if (toguess<num){
//                System.out.println("高了");
//            }else {
//                System.out.println("猜对了");
//                break;
//            }
//        }

//        1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入年龄");
//        int age = scanner.nextInt();
//        if (age<=18 && age>=0){
//            System.out.println("是少年");
//        }else if (age>=19 && 28>=age){
//            System.out.println("是青年");
//        }else if (age>=29 && 55>=age){
//            System.out.println("是中年");
//        }else {
//            System.out.println("是老年");
//        }

//        2. 判定一个数字是否是素数
//            Scanner scanner = new Scanner(System.in);
//            int num =scanner.nextInt();
//            int count =0;
//            for (int i=1;i<=num;i++) {
//                if (num%i == 0 && i!=num) {
//                    count++;
//                }
//            }
//            if (count==1){
//                System.out.println("是素数");
//            }else {
//                System.out.println("不是素数");
//            }

//        3. 打印 1 - 100 之间所有的素数
//                int isPrime = 0;
//                int check = 0;
//                for (isPrime = 1; isPrime <= 100; isPrime++) {
//                    for (check = 2; check < isPrime; check++) {
//                        //只要求模一次为 0 ,则这个数就肯定不是素数
//                        if (isPrime % check == 0) {
//                            break;
//                        }
//                    }
//                    //因为我们最小用 2 来判断是否为素数,所以不需要判断这个数是不是小于2
//                    if (check == isPrime) {
//                        System.out.print(isPrime + " ");
//                    }
//                }


//        4. 输出 1000 - 2000 之间所有的闰年
//            for (int year =1000;year<=2000;year++){
//                if (year % 100==0) {
//                    if(year % 400==0) {
//                        System.out.println(year);
//                    }else {
//                        //System.out.println("不是闰年");
//                    }
//                }else {
//                    if (year % 4==0) {
//                        System.out.println(year);
//                    }
//                }
//            }


//        5. 输出乘法口诀表
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入一个数");
//            int num = scanner.nextInt();
//            int i=1;
//            int j=1;
//            for (i=1;i<=num;i++){
//                for (j=1;j<=i;j++){
//                    System.out.print(j+"*"+i+"="+i*j+"\t");
//                }
//                System.out.println();
//            }


//        6. 求两个正整数的最大公约数
//            int num = claGreatestCommonDivisorm(100,120);
//            System.out.println(num);


//        7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
            //两项当成一项
//            double sum = serisSum(100);
//            System.out.println(sum);


//        8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
//            int count =0;
//            for (int i=1;i<100;i++){
//                if (i/10==9||i%10==9){
//                    count++;
//                    System.out.println(i);
//                }
//            }
//            System.out.println("一共有"+count+"包含9的数字");


//        9. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
//        身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
        //方法1
//            for(int flower = 0;flower<1000;flower++){
//                int i = flower/100;//百位
//                int j =(flower%100)/10;//十位
//                int k =((flower%100)%10);//个位
//                if (flower==i*i*i+j*j*j+k*k*k) {
//                    System.out.println(flower);
//                }
//            }
        //方法2
//            for (int i = 0;i<1000;i++) {
//                if (isNarcissusNum(i)) {
//                    System.out.println(i);
//                }
//            }



//        10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
//        入，最多输入三次。三次均错，则提示退出程序
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入密码>:");
//            String password = "123456";
//            int retrytime = 3;
//            for (int i=1;i<=3;i++){
//                String num = scanner.next();
//                if (num.equals( password)){
//                    System.out.println("密码正确");
//                    break;
//                } else {
//                    retrytime--;
//                    System.out.println("请重新输入密码,密码还有"+retrytime+"次");
//                }
//                if (retrytime==0) {
//                    System.out.println("次数用完退出程序");
//                }
//        }


//        11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
//            Scanner scanner = new Scanner(System.in);
//            int num = scanner.nextInt();
//            int num1 = BinarySystem(num);
//            System.out.println(num1);


//        12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
//            Scanner sc = new Scanner(System.in);
//            int num = sc.nextInt();     //用户输入的整数
//            System.out.print("奇数位:");
//            //一个整数在计算机中4个字节共32个比特位，奇数位为1，3，5，7...31
//            for (int i = 31; i >= 1; i-=2) {
//                System.out.print(num>>i&1);  //通过位运算：右移，然后与1，可得到该位的值
//            }
//            //偶数位数字获取方式与奇数位同理
//            System.out.print("偶数位:");
//            for (int i = 30; i >=0 ; i-=2) {
//                System.out.print(num>>i&1);
//            }

        
//        13. 输出一个整数的每一位.



    }



    public static int BinarySystem(int num) {   //二进制返回1的个数
        int count = 0;
        while (num>0) {
            if ((num&1)==1) {
                count++;
            }
            num=num>>1;
        }
        return count;
    }

    public static boolean isNarcissusNum(int num) {   //水仙花数
        //取出个位
        int i = num % 10;
        //取出十位
        int j = (num/10)%10;
        //取出百位
        int k =num/100;
        if (num==i*i*i+j*j*j+k*k*k) {
            return true;
        }else {
            return false;
        }
    }

    public static int claGreatestCommonDivisorm(int a,int b){        //最大公约数
        int min =min(a,b);
        for (int i=min;min>=1;i--) {
            if (a%i == 0 && b%i==0) {
                return i;
            }
        }
        return 1;
    }
    public static int min(int a,int b){        //求两个数的最小值
        if (a>b) {
            return b;
        }else {
            return a;
        }
    }
    public static double serisSum(int n) {      //数列求和
        double sum =0.0;
        for (int i=1;i<=n;i+=2 ) {
            sum +=claItme(i);
        }
        return sum;
    }
    public static double claItme(double i) {
        return 1/i-1/(i+1) ;
    }

    public void hello() {
    }
}

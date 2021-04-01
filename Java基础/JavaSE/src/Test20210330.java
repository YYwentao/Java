import java.util.Random;
import java.util.Scanner;

public class Test20210330 {
    public static void main(String[] args) {
//        while (true) {
//            int choice = menu();
//            if (choice == 1) {
//                //开始一局游戏
//                game();
//            } else if(choice == 0) {
//                //结束程序
//                System.out.println("bye");
//                break;
//            }else {
//                System.out.println("输入有误，请重新输入");
//                continue;
//            }
//        }


        //利用for循环遍历数组
//        int[] arr = {1,2,3,4};
////        for (int i = 0; i < arr.length; i++) {
////            System.out.println(arr[i]);
////        }
//        //java中 for each 写法
//        //针对数组这样的类型，就可以通过这种方式完成从前往后遍历
//        for (int x:arr){
//            System.out.println(x);
//        }


        //改变数组每位数*2
        //将原来也改变了
//        int[] arr = {1,2,3,4,};
//        System.out.println("改变后的：");
//        transform(arr);
//        System.out.println("改变前的：");
//        Arrar(arr);

        //不改变原来的
        int[] arr = {1,2,3,4,};
        System.out.println("改变后的：");
        transform(arr);
        System.out.println("改变前的：");
        Arrar(arr);
    }

    private static void transform(int[] arr) {  //重新创建一个数组用来接收改变后的值并返回
        int[] ret = new int[arr.length];
        for (int i =0;i<arr.length;i++) {
            ret[i] = arr[i] * 2;
            System.out.println(ret[i]);
        }
    }

    private static void Arrar(int[] arr) {
        for (int x:arr) {
            System.out.println(x);
        }
    }


    public static void game() {
        //1.生成一个随机数
        Random random = new Random();
        int toGuess = random.nextInt(100);
        //2.让玩家输入数字进行猜
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要猜的数字：");
            int num = scanner.nextInt();
            //进行比较
            if (num<toGuess) {
                System.out.println("小了");
            }else if (num>toGuess) {
                System.out.println("大了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
    }

    public static int menu() {
        System.out.println("--------------------------");
        System.out.println("---1.开始游戏---------------");
        System.out.println("---0.退出游戏---------------");
        System.out.println("--------------------------");
        System.out.println("请选择:");
        Scanner scanner = new Scanner(System.in);
        int ret = scanner.nextInt();
        return ret;
    }
}

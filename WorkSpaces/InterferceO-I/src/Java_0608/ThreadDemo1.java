package Java_0608;

/**
 * ClassName: ThreadDemo1
 * Description: 饿汉模式
 * date: 2021/6/8 14:12
 *
 * @author wt
 * @since JDK 1.8
 */
public class ThreadDemo1 {
    //(注意:这里加 static 是防止类名重复报错)
    static class Singleton {
        //把构造方法私有，此时外部类就无法 new 在这个类的实例
        private Singleton() {}
        //提供一个static 成员属性，表示Singleton类的唯一的实例
        //static 和类相关 ，和实例无关， 类在内存中只有一份，static成员也只有一份
        private  static Singleton instance = new Singleton();

        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        //此处的getInstance 就是获取实例的唯一方式，不应该使用其他方式来获取实例了
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}

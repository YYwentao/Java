package Java_0608;

/**
 * ClassName: ThreadDemo2
 * Description: 懒汉模式
 * date: 2021/6/8 14:59
 *
 * @author wt
 * @since JDK 1.8
 */
public class ThreadDemo2 {
    static class Singleton {
        //构造方法私有
        private Singleton () {}

        private  static Singleton instance = null;
        //类加载的时候没有实例化，第一次调用的时候 getInstance 才真正的实例化
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}

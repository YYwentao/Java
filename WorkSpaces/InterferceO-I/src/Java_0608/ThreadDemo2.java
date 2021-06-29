package Java_0608;

/**
 * ClassName: ThreadDemo2
 * Description: 懒汉模式
 * date: 2021/6/8 14:59
 *
 * @author wt
 * @since JDK 1.8
 */

/**
 * 为了保证懒汉模式下的线程安全，要涉及到三个点(重点)
 *  1.synchronized 加锁，保证线程安全
 *  2.双重 if，保证效率
 *  3.volatile 避免内存的可见性引发的问题
 */
public class ThreadDemo2 {
    static class Singleton {
        //构造方法私有
        private Singleton () {}

        private volatile static Singleton instance = null;
        //类加载的时候没有实例化，第一次调用的时候 getInstance 才真正的实例化
        //只是实例化之前的时候加锁，提高了效率，后面getInstance不会加锁，也是线程安全
        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}

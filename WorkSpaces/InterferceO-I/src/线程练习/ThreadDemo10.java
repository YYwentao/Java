package 线程练习;


public class ThreadDemo10 {
    // 懒汉模式 (在调用方法的时候才会创建实例对象)
    static class Singleton {
        private Singleton instance = null;
        // 构造方式私有,防止其他代码再创建实例
        private Singleton () {}
        // 双重 if 加 synchronized锁 既保证了线程安全，又保证了效率
        public Singleton getInstance() {
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

    public static void main(String[] args) {
        Singleton s = new Singleton();
        s.getInstance();
    }
}

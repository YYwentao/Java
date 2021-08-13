package 线程练习;


public class ThreadDemo9 {
    // 饿汉模式 (实例的创建出现在类加载的时候) 
    static class Singleton {
        // 先创建一个成员, 保存唯一的一个 Singleton 实例
        private static Singleton instance = new Singleton();
        // 然后把类的构造方法设为 private, 防止其他代码再创建实例
        private Singleton() {}
        // 再提供一个方法, 来获取到这个实例
        public static Singleton getInstance () {
            return instance;
        }
    }

    public static void main(String[] args) {
        // 只能通过 getInstance 的方式获取到该实例.
        // 而无法通过 new 的方式创建新的 Singleton 实例了.
        Singleton s = Singleton.getInstance();
    }
}

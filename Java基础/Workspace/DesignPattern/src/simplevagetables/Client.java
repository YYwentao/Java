package simplevagetables;

public class Client {
    public static void main(String[] args) {
        Root root = RootFactory.makeRoot("Potato");
        root.seed();
        root.grow();
        root.fruit();

    }
}

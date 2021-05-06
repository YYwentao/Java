package factoryway;

public class Client {
    public static void main(String[] args) {
        Vagetables vagetables = new RootFactory().getVagetables();
        vagetables.seed();
        vagetables.grow();
        vagetables.fruit();
        Vagetables vagetables1 = new CeleryFactory().getVagetables();
        vagetables1.seed();
        vagetables1.grow();
        vagetables1.fruit();
    }
}

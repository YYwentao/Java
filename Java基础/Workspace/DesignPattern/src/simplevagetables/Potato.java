package simplevagetables;

public class Potato implements Root{
    @Override
    public void seed() {
        System.out.println("种植土豆");
    }

    @Override
    public void grow() {
        System.out.println("土豆成长");
    }

    @Override
    public void fruit() {
        System.out.println("土豆收割");
    }
}

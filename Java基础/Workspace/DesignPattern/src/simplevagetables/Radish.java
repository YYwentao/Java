package simplevagetables;

public class Radish implements Root{
    @Override
    public void seed() {
        System.out.println("种植萝卜");
    }

    @Override
    public void grow() {
        System.out.println("萝卜成长");
    }

    @Override
    public void fruit() {
        System.out.println("萝卜收割");
    }
}

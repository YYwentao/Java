package simplevagetables;

public class Carrot implements Root{
    @Override
    public void seed() {
        System.out.println("种植胡萝卜");
    }

    @Override
    public void grow() {
        System.out.println("胡萝卜成长");
    }

    @Override
    public void fruit() {
        System.out.println("收割胡萝卜");
    }
}

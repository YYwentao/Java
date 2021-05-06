package simplevagetables;

public class Turnip implements Root{
    @Override
    public void seed() {
        System.out.println("种植大头菜");
    }

    @Override
    public void grow() {
        System.out.println("大头菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("收割大头菜");
    }
}

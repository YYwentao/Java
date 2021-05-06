package factoryway;

public class Root implements Vagetables{
    @Override
    public void seed() {
        System.out.println("种植根菜");
    }

    @Override
    public void grow() {
        System.out.println("根菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("根菜收割");
    }
}

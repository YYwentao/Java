package factoryway;

public class Celery implements Vagetables{
    @Override
    public void seed() {
        System.out.println("种植茎菜");
    }

    @Override
    public void grow() {
        System.out.println("茎菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("茎菜收割");
    }
}

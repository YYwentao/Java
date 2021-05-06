package growvegetables;

public class NgMoCelery implements Celery{
    @Override
    public void seed() {
        System.out.println("种植非转基因芹菜");
    }

    @Override
    public void grow() {
        System.out.println("非转基因芹菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("非转基因芹菜果实");
    }
}

package growvegetables;

public class TransgenosisCelery implements Celery{
    @Override
    public void seed() {
        System.out.println("种植转基因芹菜");
    }

    @Override
    public void grow() {
        System.out.println("转基因芹菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("转基因芹菜果实");
    }
}

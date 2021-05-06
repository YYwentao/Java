package growvegetables;

public class TransgenosisRoot implements Root{
    @Override
    public void seed() {
        System.out.println("种植转基因根菜");
    }

    @Override
    public void grow() {
        System.out.println("转基因根菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("转基因根菜果实");
    }
}

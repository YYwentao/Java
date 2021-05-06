package growvegetables;

public class NgMoRoot implements Root{
    @Override
    public void seed() {
        System.out.println("种植非转基因根菜");
    }

    @Override
    public void grow() {
        System.out.println("非转基因根菜成长");
    }

    @Override
    public void fruit() {
        System.out.println("非转基因根菜果实");
    }
}

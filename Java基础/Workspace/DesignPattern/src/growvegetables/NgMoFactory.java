package growvegetables;

public class NgMoFactory implements GrowVegetablesFactory{
    @Override
    public Root root() {
        return new NgMoRoot();
    }

    @Override
    public Celery celery() {
        return  new NgMoCelery();
    }
}

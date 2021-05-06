package growvegetables;

public class TransgenosisFactory implements GrowVegetablesFactory{
    @Override
    public Root root() {
        return new TransgenosisRoot();
    }

    @Override
    public  Celery celery() {
        return new TransgenosisCelery();
    }
}

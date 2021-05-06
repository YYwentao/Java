package factoryway;

public class CeleryFactory implements VagetablesFactory{
    @Override
    public Vagetables getVagetables() {
        return new Celery();
    }
}

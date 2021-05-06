package factoryway;

public class RootFactory implements VagetablesFactory{
    @Override
    public Vagetables getVagetables() {
        return new Root();
    }
}

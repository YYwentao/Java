package growvegetables;

public interface Root extends Vegetables{
    @Override
    void seed();

    @Override
    void grow();

    @Override
    void fruit();
}

package electricity;

public class HaierFactory implements ElectricityFactory{
    @Override
    public Haier haier() {
        return new HaierElectricityProduct();
    }

    @Override
    public Tcl tcl() {

        return new TclElectricityProduct();
    }
}

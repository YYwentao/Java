package electricity;

public class TclFactory implements ElectricityFactory{
    @Override
    public Haier haier() {
        return new HaierElectricityProduct();
    }

    @Override
    public Tcl tcl() {
        return new TclElectricityProduct();
    }
}

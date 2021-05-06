package electricity;
//抽象产品工厂
public interface ElectricityFactory {
    Haier haier();
    Tcl tcl();
}

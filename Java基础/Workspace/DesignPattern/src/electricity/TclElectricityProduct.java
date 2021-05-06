package electricity;

public class TclElectricityProduct implements Tcl{
    @Override
    public void maketv() {
        System.out.println("TCL工厂制作TCL电视");
    }

    @Override
    public void makeair() {
        System.out.println("TCL工厂制作TCL空调");
    }
}

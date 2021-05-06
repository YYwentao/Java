package electricity;

public class Client {
    public static void main(String[] args) {
        Haier haier = new HaierFactory().haier();
        haier.makeair();
        haier.maketv();
        Tcl tcl= new TclFactory().tcl();
        tcl.makeair();
        tcl.maketv();
    }
}

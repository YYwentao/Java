package electricity;

public class HaierElectricityProduct implements Haier{
    @Override
    public void maketv() {
        System.out.println("海尔工厂制作海尔电视");
    }

    @Override
    public void makeair() {
        System.out.println("海尔工厂制作海尔空调");
    }
}

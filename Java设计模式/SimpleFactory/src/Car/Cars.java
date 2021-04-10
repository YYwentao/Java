package Car;

public class Cars {
	public static void main(String[] args) {
		Car bm = new BMWFactory().makeCar();
		Car bz = new BenzFactory().makeCar();
		bm.name();
		bz.name();
	}

}

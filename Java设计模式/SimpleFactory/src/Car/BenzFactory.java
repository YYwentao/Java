package Car;

public class BenzFactory implements CarFactory {
	@Override
	public Car makeCar() {
		return new Benz();
	}
}

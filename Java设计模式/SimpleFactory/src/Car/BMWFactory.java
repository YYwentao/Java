package Car;

public class BMWFactory implements CarFactory {
	@Override
	public Car makeCar() {
		return new BMW();
	}
}

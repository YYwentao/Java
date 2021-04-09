package CreateShape;

import java.nio.channels.UnsupportedAddressTypeException;

class Shape {
	 public void draw() {
		 //绘制方法
	 }
	 public void erase() {
		 //擦除方法
	 }
}
//创建一个Circle类继承Shape类，并重写draw和erase方法
class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("绘制圆形");
	}

	@Override
	public void erase() {
		System.out.println("擦除圆形");
	}
}
//创建一个Rectangle类继承Shape类,并重写draw和erase方法
class Rectangle extends Shape {

	@Override
	public void draw() {
		System.out.println("绘制矩形");
	}

	@Override
	public void erase() {
		System.out.println("擦除矩形");
	}
	
}
//创建一个Triangle类继承Shape类,并重写draw和erase方法
class Triangle extends Shape {
	
	@Override
	public void draw() {
		System.out.println("绘制三角形");
	}

	@Override
	public void erase() {
		System.out.println("擦除三角形");
	}
	
}
public class Testdemo {
	public static void main(String[] args) {
		try {
			Circle circle = new Circle();
			Rectangle rectangle = new Rectangle();
			Triangle triangle = new Triangle();
			String[] shapes = {"circle", "rectangle", "triangle"};
			for (String shape : shapes) {
				if (shape.equals("circle")) {
					circle.draw();
					circle.erase();
				} else if (shape.equals("rectangle")) {
					rectangle.draw();
					rectangle.erase();
				} else if (shape.equals("triangle")) {
					triangle.draw();
					triangle.erase();
				}
			}
		} catch (UnsupportedAddressTypeException e) {
			System.out.println("ghjggh");
		}

	}
}

package CreateShape;

import java.nio.channels.UnsupportedAddressTypeException;

class Shape {
	 public void draw() {
		 //���Ʒ���
	 }
	 public void erase() {
		 //��������
	 }
}
//����һ��Circle��̳�Shape�࣬����дdraw��erase����
class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("����Բ��");
	}

	@Override
	public void erase() {
		System.out.println("����Բ��");
	}
}
//����һ��Rectangle��̳�Shape��,����дdraw��erase����
class Rectangle extends Shape {

	@Override
	public void draw() {
		System.out.println("���ƾ���");
	}

	@Override
	public void erase() {
		System.out.println("��������");
	}
	
}
//����һ��Triangle��̳�Shape��,����дdraw��erase����
class Triangle extends Shape {
	
	@Override
	public void draw() {
		System.out.println("����������");
	}

	@Override
	public void erase() {
		System.out.println("����������");
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

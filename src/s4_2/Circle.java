package s4_2;

public class Circle extends Shape {

	public int radius;
	
	public Circle(int r) {
		super("Circle");
		radius = r;
	}	
	
	@Override
	public double computeArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double computePerimeter() {
		return 2.0 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}

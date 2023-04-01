package s4_2;

public class Rectangle extends Shape {
	
	public int width;
	public int height;
	
	//Rectangle이 상속을 받을 때, 부모 클래스의 생성자 정의해줘야 됨
	public Rectangle(int w,int h) {
		super("Rectangle");
		width = w;
		height = h;
	}

	@Override
	public double computeArea() {
		return (double)width * height;
	}

	@Override
	public double computePerimeter() {
		return 2.0 * (width + height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
}

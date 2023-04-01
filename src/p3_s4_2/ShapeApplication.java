package p3_s4_2;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {

	private int capacity = 10;
	private Shape[] shapes = new Shape[capacity];
	private int n = 0;
	private Scanner kb = new Scanner(System.in);
	
	public void processCommand() {
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("add")) {
				handleAdd();
			}else if(command.equals("show") || command.equals("showdetail")) {
				handleShow(command.equals("showdetail"));
			}else if(command.equals("sort")) {
				//bubbleSort(shapes,n);
				Arrays.sort(shapes,0,n); //bubbleSort말고 요렇게도 가능..
			}else if(command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	
	private void bubbleSort(MyComparable[] data,int size) {
		for(int i=size-1; i >0; i--) {
			for(int j=0; j<i; j++) {
				if(data[j].compareTo(data[j+1]) > 0 ) {
					MyComparable tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
	}

	private void handleShow(boolean detailed) {
		for(int i=0;i<n;i++) {
			System.out.println((i+1)+ ". " + shapes[i].toString());
			if(detailed) {
				System.out.println("    The area is " + shapes[i].computeArea());
				System.out.println("    The perimeter is " + shapes[i].computePerimeter());
			}
		}
		
	}

	private void handleAdd() {
		String type = kb.next();
		switch(type) {
		case "R":
			addShape(new Rectangle(kb.nextInt(), kb.nextInt()));
			break;
		case "C":
			addShape(new Circle(kb.nextInt()));
			break;
		case "T":
			//생략
			break;
		}
		
	}

	private void addShape(Shape shape) {
		//다형성을 위해 Shape타입으로 매개변수 받습니다.
		if(n >= capacity) {
			//n은 실제 배열에 저장된 갯수임
			reallocate();
		}
		shapes[n++] = shape;
	}

	private void reallocate() {
		capacity *= 2;
		Shape[] tmp = new Shape[capacity];
		//shapes 배열 내용을 시작위치 0해서 tmp배열로 copy하라
		//tmp배열은 0부터 시작해서 shapes.length만큼 카피
		System.arraycopy(shapes, 0, tmp, 0,shapes.length);
		shapes = tmp;
	}

	public static void main(String[] args) {
		ShapeApplication app = new ShapeApplication();
		app.processCommand();

	}

}

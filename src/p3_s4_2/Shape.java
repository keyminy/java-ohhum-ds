package p3_s4_2;

public abstract class Shape implements Comparable<Object>{
	public String shapeName;
	
	public Shape(String name) {
		shapeName = name;
	}
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	public int compareTo(Object other) {
		double myArea = computeArea();
		double yourArea = ((Shape)other).computeArea();//Shape로 type변환
		if(myArea < yourArea) return -1;
		else if(myArea == yourArea) return 0;
		else return 1;
	}
}

import java.lang.Math;

public class Triangle implements Shape {
		public String name = "Triangle";
		public int side1, side2, side3;
		public int id;
		public String color;
		
		public Triangle(int i, int a, int b, int c, String co) {
			id = i;
			side1 = a;
			side2 = b;
			side3 = c;
			color = co;
		}
		
		public double getArea() { 
			double p = this.getPerimeter() / 2;
			double area = Math.sqrt(p*(p-side1) * (p-side2) * (p-side3));
			return area;
		}
		public double getPerimeter() { return side1 + side2 + side3; }
		public String toString() { return String.format("%s %d %d %d %d %s", name, id, side1, side2, side3, color); }
	}
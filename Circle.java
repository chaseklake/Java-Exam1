public class Circle implements Shape {
		public final double PI = 3.14;
		public String name = "Circle";
		public int radius;
		public int id;
		public String color;
		
		public Circle(int i, int r, String c) {
			id = i;
			radius = r;
			color = c;
		}
		
		public double getArea() {return PI * (double)radius * (double)radius;}
		public double getPerimeter() {return 2 * PI * (double)radius;}
		public String toString() { return String.format("%s %d %d %s", name, id, radius, color); }
	}
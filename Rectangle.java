public class Rectangle implements Shape {
		public String name = "Rectangle";
		public int base, height;
		public int id;
		public String color;
		
		public Rectangle(int i, int b, int h, String c) {
			id = i;
			base = b;
			height = h;
			color = c;
		}
		
		public double getArea() { return base * height; }
		public double getPerimeter() { return 2 * base + 2 * height; }
		public String toString() { return String.format("%s %d %d %d %s", name, id, base, height, color); }
	}
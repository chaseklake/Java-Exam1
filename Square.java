public class Square implements Shape {
		public String name = "Rectangle";
		public int sideLength;
		public int id;
		public String color;
		
		public Square(int i, int s, String c ) {
			id = i;
			sideLength = s;
			color = c;
		}
		
		public double getArea() { return (double)sideLength * (double)sideLength; }
		public double getPerimeter() { return 4 * (double)sideLength; }
		public String toString() { return String.format("%s %d %d %s", name, id, sideLength, color); }
	}

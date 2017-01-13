import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Exam extends JFrame implements ActionListener {
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	ArrayList<String> shapesInfo = new ArrayList<String>();
	JComboBox shapesBox = new JComboBox();
	JTextPane txtInfo = new JTextPane();
	JLabel lblImage = new JLabel("");
	
	public Exam() {
		init();
		
		JPanel left = new JPanel();
		
		getContentPane().add(left, BorderLayout.WEST);
		
		JComboBox shapesBox = new JComboBox();
		for (String s : shapesInfo)
			shapesBox.addItem(s);
		shapesBox.setToolTipText("Select a Shape");
		shapesBox.addActionListener(this);
		left.add(shapesBox);
		
		getContentPane().add(lblImage, BorderLayout.CENTER);
		
		txtInfo.setText("Info:\r\nNo shape selected.");
		getContentPane().add(txtInfo, BorderLayout.EAST);
		
		setSize(600,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() instanceof JComboBox) {
			 JComboBox<String> cb = (JComboBox<String>)a.getSource();
			 String selected = (String)cb.getSelectedItem();
			 for (Shape s : shapes) {
				 if (selected.equals(s.toString())) {
					 if (s instanceof Rectangle) {
						 String info = String.format("Info:\nName: %s\nID: %d\nBase: %d\nHeight: %d\n"
								 + "Color: %s\nPerimeter: %.0f\nArea: %.0f", ((Rectangle) s).name, ((Rectangle) s).id,
								 ((Rectangle) s).base, ((Rectangle) s).height, ((Rectangle) s).color, 
								 s.getPerimeter(), s.getArea());
						 txtInfo.setText(info);
						 lblImage.setIcon(new ImageIcon(Exam.class.getResource("/Images/rect-icon.png")));
						 
					 }
					 else if (s instanceof Circle) {
						 txtInfo.setText(String.format("Info:\nName: %s\nID: %d\nRadius: %d\n"
								 + "Color: %s\nPerimeter: %.3f\nArea: %.3f", ((Circle) s).name, ((Circle) s).id, 
								 ((Circle) s).radius, ((Circle) s).color, s.getPerimeter(), s.getArea()));
						 lblImage.setIcon(new ImageIcon(Exam.class.getResource("/Images/police-icon.png")));
					 }
					 else if (s instanceof Square) {
						 txtInfo.setText(String.format("Info:\nName: %s\nID: %d\nSideLength: %d\n"
								 + "Color: %s\nPerimeter: %.0f\nArea: %.0f",((Square) s).name, ((Square) s).id,
								 ((Square) s).sideLength, ((Square) s).color, s.getPerimeter(), s.getArea()));
						 lblImage.setIcon(new ImageIcon(Exam.class.getResource("/Images/kid-icon.png")));
					 }
					 else if (s instanceof Triangle) {
						 txtInfo.setText(String.format("Info:\nName: %s\nID: %d\nSide1: %d\n"
								 + "Side2: %d\nSide3: %d\nColor: %s\nPerimeter: %.3f\nArea: %f.3", ((Triangle) s).name,
								 ((Triangle) s).id, ((Triangle) s).side1, ((Triangle) s).side2, ((Triangle) s).side3,
								 ((Triangle) s).color, s.getPerimeter(), s.getArea()));
						 lblImage.setIcon(new ImageIcon(Exam.class.getResource("/Images/teacher-icon.png")));
					 }
				 }
			 }
		}
	}

	public void init() {
		// Sets up the array of shapes, reading them from shapes.txt
		String curdir = System.getProperty("user.dir") + "\\src";
		
		File cd = new File(curdir);
		File[] files = cd.listFiles();
		for (File f: files) {
			if (f.getName().endsWith(".txt")) {
				
				try (FileInputStream is = new FileInputStream(f)) {
					InputStreamReader ir = new InputStreamReader(is);
                    BufferedReader rdr = new BufferedReader(ir);
                    String line = rdr.readLine();
                    while (line != null) {
	                    if (line.contains("rectangle")) {
	                    	String[] parts = line.split(" ");
	                    	int id = Integer.parseInt(parts[1]);
	                    	int base = Integer.parseInt(parts[2]);
	                    	int height = Integer.parseInt(parts[3]);
	                    	String color = parts[4];
	                    	Rectangle rect = new Rectangle(id, base, height, color);
	                    	shapes.add(rect);
	                    	
	                    } else if (line.contains("circle")) {
	                    	String[] parts = line.split(" ");
	                    	int id = Integer.parseInt(parts[1]);
	                    	int radius = Integer.parseInt(parts[2]);
	                    	String color = parts[3];
	                    	Circle circ = new Circle(id, radius, color);
	                    	shapes.add(circ);
	                    	
	                    } else if (line.contains("square")) {
	                    	String[] parts = line.split(" ");
	                    	int id = Integer.parseInt(parts[1]);
	                    	int sideLength = Integer.parseInt(parts[2]);
	                    	String color = parts[3];
	                    	Square sqr = new Square(id, sideLength, color);
	                    	shapes.add(sqr);
	                    	
	                    } else if (line.contains("triangle")) {
	                    	String[] parts = line.split(" ");
	                    	int id = Integer.parseInt(parts[1]);
	                    	int a = Integer.parseInt(parts[2]);
	                    	int b = Integer.parseInt(parts[3]);
	                    	int c = Integer.parseInt(parts[4]);
	                    	String color = parts[5];
	                    	Triangle tri = new Triangle(id, a, b, c, color);
	                    	shapes.add(tri);
	                    	
	                    }
	                    
	                    line = rdr.readLine();
                    }
				}
				catch (Exception ex) { System.out.printf("Failed for %s\n", ex.getMessage()); }
			}
		}
		
		// Now that shapes is initialized, convert to strings for JComboBox
		for (Shape s : shapes)
			shapesInfo.add(s.toString());
	}
	
	public static void main(String[] args) {
		Exam obj = new Exam();
		
		for (String s : obj.shapesInfo) {
			System.out.println(s);
		}
	}
}

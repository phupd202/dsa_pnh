package hw3_20001958.exercise_2;

import java.util.ArrayList;
import java.util.List;

public class TestShape {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();

        Circle c1 = new Circle(3);
        shapes.add(c1);
        Sphere s1 = new Sphere(5);
        shapes.add(s1);
        Rectangle r1 = new Rectangle(2, 3);
        shapes.add(r1);

        for (int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i) instanceof Circle) {
                System.out.println("Circle!, Perimeter = " + shapes.get(i).getPerimeter());
            } 
            if(shapes.get(i) instanceof Rectangle) {
                System.out.println("Rectangel!, Perimeter = " + shapes.get(i).getPerimeter());
            }

            if(shapes.get(i) instanceof Sphere) {
                System.out.println("Sphere!, Volume = " + shapes.get(i).getVolume());
            }
        }
        
    }
}

package hw3_20001958.exercise_2;

public class Circle extends Shape {
    private double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return Math.PI * this.radius * this.radius;
       
    }

    @Override
    protected double getPerimeter() {
        return 2 * Math.PI * this.radius;
        
    }

    @Override
    public String getName() {
        return super.getName() + "Circle = " + this.radius;
    }
}
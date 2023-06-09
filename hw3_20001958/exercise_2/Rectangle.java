package hw3_20001958.exercise_2;

public class Rectangle extends Shape {
    private double width = 0;
    private double height = 0;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getArea() {
        return this.width * this.height;
    }

    @Override
    protected double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
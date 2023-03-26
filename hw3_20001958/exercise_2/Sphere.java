package hw3_20001958.exercise_2;

public class Sphere extends Shape {
    private double radius = 0;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getVolume() {
        return 4.0 / 3.0 * Math.PI * this.radius * this.radius * this.radius;
    }

    @Override
    protected double getArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }
}
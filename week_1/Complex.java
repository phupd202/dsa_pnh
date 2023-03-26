package week_1;

import java.util.Scanner;

public class Complex {

    private double real;
    private double virtual;

    // constructor
    public Complex(double real, double virtual) {
        this.real = real;
        this.virtual = virtual;
    }

    // getter and setter
    public double getReal() {
        return real;
    }

    public double getVirtual() {
        return virtual;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setVirtual(double virtual) {
        this.virtual = virtual;
    }

    // add 2 complex
    public Complex add(Complex other) {
        double sumReal = this.real + other.real;
        double sumVirtual = this.virtual + other.virtual;

        return new Complex(sumReal, sumVirtual);
    }

    // subsstract
    public Complex substract(Complex other) {
        double subReal = this.real - other.real;
        double subVirtual = this.virtual - other.virtual;
        
        return new Complex(subReal, subVirtual);
    }

    // multiplication
    public Complex multi(Complex other) {
        double newReal = this.real * other.real - this.virtual * other.virtual;
        double newVirtual = this.real * other.virtual + this.virtual * other.real;

        return new Complex(newReal, newVirtual);
    }

    // divise
    public Complex devise(Complex other) {
        double coef = other.real * other.real + other.virtual * other.virtual;
        
        double newReal = (this.real * other.real +  this.virtual * other.virtual) / coef;
        double newVirtual =  (this.virtual * other.real - this.real * other.virtual) / coef;
        return new Complex(newReal, newVirtual);
    }

    // toString
    public String toString() {
        return this.real + " + " + this.virtual + "i";
    }

   
    public static void main(String[] args) {

        // Nhập số phức
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập phần thực");
        double real = sc.nextDouble();
        System.out.println("Nhập phần ảo");
        double virtual = sc.nextDouble();

        Complex complex = new Complex(real, virtual);
        System.out.println("Số phức vừa nhập là: " + complex.toString());

        System.out.println("Test chức năng:");
        Complex complex1 = new Complex(1, 2);
        Complex complex2 = new Complex(2, 3);
        // test toString
        System.out.println(complex1.toString());
        System.out.println(complex2.toString());

        // test add
        System.out.println("Add: ");
        System.out.println(complex1.add(complex2));

        // test substract
        System.out.println("Substract: ");
        System.out.println(complex1.substract(complex2)); // - 1 - 1i

        // Product
        System.out.println("Product: ");
        System.out.println(complex1.multi(complex2)); // - 4 + 7i

        // Division
        System.out.println("Devision: ");
        System.out.println(complex1.devise(complex2));

    }
}

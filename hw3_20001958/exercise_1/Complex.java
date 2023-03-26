package hw3_20001958.exercise_1;

public class Complex {
    private float real; //phần thực
    private float image; // phần ảo

    public Complex(float r, float i) {
        this.real = r;
        this.image = i;
    }

    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.image + c.image);
    }

    public Complex minus(Complex c) {
        return new Complex(this.real - c.real, this.image - c.image);
        
    }

    public Complex time(Complex c) {
        // Nhân hai so phưc
        float newReal = this.real * c.real - this.image * c.image;
        float newImage = this.real * c.image + this.image * c.real;
        return new Complex(newReal, newImage);
    }

    public float realpart() {
        return real;
    }
       
    public float imagepart() {
        return image;
    }
        
    @Override
    public String toString() {
        if(this.real == 0) {
            return this.image +"i";
        } else if(this.image == 0) {
            return this.real +"";
        } else {
            return this.real + " + " + this.image + "i";
        }
    }
}

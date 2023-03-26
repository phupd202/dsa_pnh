package week_1;

class Sphere {
    
    private double r;
    private double x;
    private double y;
    private double z;

    // Contructor
    public Sphere(double r, double x, double y, double z) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getR() {
        return r;
    }


    // tinh diện tích
    public double getArea() {
        return 4 * Math.PI * this.r * this.r;
    }

    // tính thể tích
    public double getVolume() {
        return 4 / 3 * Math.PI * this.r * this.r * this.r;
    }

    // khoang cach tam
    public double getDistanceCentral(Sphere other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y) + (this.z - other.z) * (this.z - other.z));
    }
    // check giao nhau
    public boolean checkIntersect(Sphere other) {

        if (Math.abs(this.r - other.r) < this.getDistanceCentral(other) && this.getDistanceCentral(other) < this.r + other.r) {
            return true;
        }
        return false;
    }

    // check bao nhau
    public boolean checkNest(Sphere other) {

        if (Math.abs(this.r - other.r) >  this.getDistanceCentral(other)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(3, 2, 2, 2);
        Sphere sphere2 = new Sphere(5, 2, 3, 2);

        //the tich
        System.out.println("Thể tích sphere1: " + sphere1.getVolume());

        // Dien tich
        System.out.println("Diện tích xq sphere1: " + sphere1.getArea());

        // test giao nhau
        System.out.println("Test giao nhau: " + sphere1.checkIntersect(sphere2)); // giao nhau

        // test bao nhau
        System.out.println("Test bao nhau: " + sphere1.checkNest(sphere2));
    }
}

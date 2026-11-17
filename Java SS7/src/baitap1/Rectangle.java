public class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }

    public double dienTich(){
        return length * width;
    }

    public double chuVi(){
        return 2 * (length + width);
    }

    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + dienTich());
        System.out.println("Chu vi: " + chuVi());
    }
}

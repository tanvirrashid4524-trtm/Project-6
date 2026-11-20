package Task1;

public class task1 {

    public static int calculateArea(int length, int width) {
        return length * width;
    }

    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        System.out.println(calculateArea(5, 4));     // 20
        System.out.println(calculateArea(5.5, 4.2)); // 23.1
    }
}
package alone;

public class MethodEx1 {
    public static void main(String[] args) {
        avg(1, 2, 3);
        avg(15, 25, 35);
    }

    public static void avg(int a, int b, int c) {
        int sum = a + b + c;
        double avg = sum / 3;
        System.out.println("평균값: " + avg);
    }
}

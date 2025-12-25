package alone;

public class NestedEx1 {
    public static void main(String[] args) {

        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                System.out.println(x + " * " + y + " = " + x * y);
            }
        }
    }
}

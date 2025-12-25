package alone;

public class MethodEx2 {
    public static void main(String[] args) {
        again("Hello World!", 3);
        again("Hello World!", 5);
        again("Hello World!", 7);
    }

    public static void again(String message, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(message);
        }
    }
}

package alone;

public class WhileEx3 {
    public static void main(String[] args) {
        int max = 100;

        int i = 1;
        int sum = 0;

        while (i <= max) {
            sum += i;
            i++;
        }

        System.out.println(sum);
    }
}

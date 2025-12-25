package alone;

public class AloneAverage {
    public static void main(String[] args) {
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        double answer = 0;
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        answer = sum / numbers.length;

        System.out.println(answer);
    }
}

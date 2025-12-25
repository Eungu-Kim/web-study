package alone;

public class ScoreEx {
    public static void main(String[] args) {
        int score = 80;

        if (90 <= score) {
            System.out.println("학점은 A입니다.");
        } else if (80 <= score) {
            System.out.println("학점은 B입니다.");
        } else if (70 <= score) {
            System.out.println("학점은 C입니다.");
        } else if (60 <= score) {
            System.out.println("학점은 D입니다.");
        } else {
            System.out.println("학점은 F입니다.");
        }
    }
}

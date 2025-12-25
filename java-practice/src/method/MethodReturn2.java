package alone;

public class MethodReturn2 {
    public static void main(String[] args) {
        checkAge(10);
        checkAge(20);
    }

    public static void checkAge(int age) {
        if (age >= 18) {
            System.out.println("입장하세요.");
            return;
        } else {
            System.out.println("미성년자는 출입이 불가합니다.");
        }
    }
}

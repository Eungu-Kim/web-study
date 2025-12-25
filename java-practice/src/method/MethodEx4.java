package alone;

import java.util.Scanner;

public class MethodEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 0;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("입금액을 입력하세요: ");
                int depositAmount = scanner.nextInt();
                balance += depositAmount;

                System.out.println(depositAmount + "원을 입금하였습니다. 현재 잔액: " + balance);
            }
            else if (choice == 2) {
                System.out.print("출급액을 입력하세요: ");
                int withdrawAmount = scanner.nextInt();

                if (balance >= withdrawAmount) {
                    balance -= withdrawAmount;
                    System.out.println(withdrawAmount + "원을 출금하였습니다. 현재 잔액: " + balance);
                } else {
                    System.out.println(withdrawAmount + "원을 출급하려 했으나 잔액이 부족합니다.");
                }
            }
            else if (choice == 3) {
                System.out.println("현재 잔액: " + balance);
            }
            else if (choice == 4) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
            else {
                System.out.println("잘못된 메뉴를 입력했습니다.");
            }
        }

    }
}

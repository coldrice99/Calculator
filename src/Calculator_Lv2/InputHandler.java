package Calculator_Lv2;

import java.util.Scanner;

//입력 관련 로직을 처리하는 클래스
public class InputHandler {
    private final Scanner sc = new Scanner(System.in);

    //숫자 입력 받기
    public int getInputNumber(String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num >= 0) {
                    break;
                } else {
                    System.out.println("0 또는 양의 정수를 입력해주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                sc.next(); // 잘못된 입력 처리
            }
        }
        return num;
    }


    //연산자 입력 받기
    public char getOperator() {
        char operator;
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            operator = sc.next().charAt(0);
            if ("+-*/".indexOf(operator) != -1) {
                break;
            } else {
                System.out.println("잘못된 연산 기호입니다. 다시 입력해주세요.");
            }
        }
        return operator;
    }

    public void closeScanner() {
        sc.close();
    }
}

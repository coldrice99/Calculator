package Calculator_Lv3;

import java.util.Scanner;

//입력 관련 로직을 처리하는 클래스
public class InputHandler {
    private final Scanner sc = new Scanner(System.in);

    //숫자 입력 받기 (실수도 처리할 수 있도록 수정)
    public double getInputNumber(String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                num = sc.nextInt();
                if (num >= 0) {
                    break;
                } else {
                    System.out.println("0 또는 양의 숫자를 입력해주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.next(); // 잘못된 입력 처리
            }
        }
        return num;
    }

    //연산자 입력 받기
    // 연산자 입력 받기
    public char getOperator() {
        System.out.print("연산자를 입력하세요 (+, -, *, /): ");
        return sc.next().charAt(0);
    }
    // Scanner 자원 해체
    public void closeScanner() {
        sc.close();
    }
}

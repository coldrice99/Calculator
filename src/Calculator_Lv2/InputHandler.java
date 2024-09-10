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
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.next(); // 잘못된 입력 처리
            }
        }
        return num;
    }

    //연산자 입력 받기
    public char getOperator(int num2) {
        char operator;
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            operator = sc.next().charAt(0);
            if ("+-*/".indexOf(operator) != -1) {
                if(operator == '/' && num2 == 0) {
                    System.out.println("나눗셈의 두 번째 숫자는 0이 될 수 없습니다. 연산 기호를 다시 입력하세요.");
                }
                else break;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
            }
        }
        return operator;
    }

    /**
     * 사용자로부터 삭제 여부를 입력받는 메서드.
     * @return 'Y' 또는 'N'
     */
    public String getDeleteChoice() {
        System.out.println("결과 리스트의 첫번째 값을 삭제하시겠습니까? (Y/N)");
        return sc.next();
    }

    /**
     * 프로그램 종료 여부를 확인하는 메서드.
     * @return 'exit' 입력 시 true 반환
     */
    public boolean checkExit() {
        String input = sc.next();
        return input.equalsIgnoreCase("exit");
    }

    public void closeScanner() {
        sc.close();
    }
}

package Calculator_Lv1;

import java.util.Scanner;

/**
 * Lv1 계산기의 메인 클래스.
 * 사용자로부터 두 숫자와 연산자를 입력받아 사칙연산을 수행한 후 결과를 출력하는 역할을 합니다.
 * 'exit' 입력 시 프로그램이 종료됩니다.
 */
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            // 두 양의 정수 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int Num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int Num2 = sc.nextInt();

            // 연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0); // 첫 번째 문자만 입력

            // 연산 수행 및 결과 출력
            double result = 0;
            switch (operator) {
                case '+':
                    result = Num1 + Num2;
                    break;
                case '-':
                    result = Num1 - Num2;
                    break;
                case '*':
                    result = Num1 * Num2;
                    break;
                case '/':
                    if (Num2 == 0) {
                        System.out.println("나눗셈 연산에서 두 번째 정수가 0일 수 없습니다.");
                        continue;
                    }
                    result = (double) Num1 / Num2;
                    break;
                default:
                    System.out.println("잘못되 연산 기호입니다. 다시 시도해주세요.");
                    continue;
            }

            System.out.println("결과: " + result);

            // exit 입력 시 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String nextLine = sc.next();
            if (nextLine.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

        }
        sc.close();
    }
}


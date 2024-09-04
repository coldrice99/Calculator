package Calculator_Lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            //Step1 : 두 양의 정수 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int Num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int Num2 = sc.nextInt();

            //Step2 : 연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0); // 첫 번째 문자만 입력

            //Step3 : 연산 수행 및 결과 출력
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

            //Step 5 : exit 입력 시 종료
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


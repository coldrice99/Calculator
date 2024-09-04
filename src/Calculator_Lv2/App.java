package Calculator_Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            //Step1 : 두 양의 정수 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            //Step2 : 연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0); // 첫 번째 문자만 입력

            try {
                //Step3 : 연산 수행 및 결과 출력
                calc.setResults(num1, num2, operator);
                System.out.println("결과: " + calc.getResults());
            } catch (ArithmeticException e) {
                //두번 째 수가 0일 때 나누기 연산하는 경우 처리
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

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


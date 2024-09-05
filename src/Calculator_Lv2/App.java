package Calculator_Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num1 = 0, num2 = 0;
            //Step1 : 두 양의 정수 입력
//            try {
//                System.out.print("첫 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
//                num1 = sc.nextInt();
//
//                System.out.print("두 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
//                num2 = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
//                sc.nextLine();
//                continue;
//            }
            //첫 번째 숫자 입력
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
                if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    if (num1 >= 0) {
                        break;
                    } else {
                        System.out.println("0 또는 양의 정수를 입력해주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                    sc.next(); // 잘못된 입력 처리
                }
            }
            //두 번째 숫자 입력
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
                if (sc.hasNextInt()) {
                    num2 = sc.nextInt();
                    if (num2 >= 0) {
                        break;
                    } else {
                        System.out.println("0 또는 양의 정수를 입력해주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                    sc.next(); // 잘못된 입력 처리
                }
            }

            //Step2 : 연산 기호 입력
            char operator;
            do {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                operator = sc.next().charAt(0);

                // 연산 기호가 잘못되었을 경우 Calculator 클래스에서 예외 처리
                try {
                    calc.setResults(num1, num2, operator);
                    break; // 올바른 연산 기호라면 루프 탈출
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);

            try {
                // Step3 : 연산 수행 및 결과 출력
                System.out.println("결과: " + calc.getResults());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
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


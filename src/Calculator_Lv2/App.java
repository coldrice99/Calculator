package Calculator_Lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {

            //입력받기
            int num1 = getInputNumber(sc, "첫 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            int num2 = getInputNumber(sc, "두 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            char operator = getOperator(sc);

            //계산 수행 및 결과 저장
            try {
                calc.setResults(num1, num2, operator);
                System.out.println("결과:" + calc.getResults());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

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

    //숫자 입력받기
    private static int getInputNumber(Scanner sc, String prompt) {
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

    //연산자 입력받기
    private static char getOperator(Scanner sc) {
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

}


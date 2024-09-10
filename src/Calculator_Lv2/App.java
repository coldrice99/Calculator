package Calculator_Lv2;

public class App {

    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        Calculator calc = new Calculator();

        while (true) {
            // 사용자로부터 첫 번째 숫자 입력
            int num1 = inputHandler.getInputNumber("첫 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            // 사용자로부터 두 번째 숫자 입력
            int num2 = inputHandler.getInputNumber("두 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            // 연산자 입력
            char operator = inputHandler.getOperator(num2);


            // 연산 수행 및 결과 출력
            int result = calc.calculate(num1, num2, operator);
            System.out.println("결과: " + result);
            // 결과 리스트 출력
            System.out.println("결과 리스트:" + calc.getResults());


            // 결과 리스트의 첫번째 값 삭제
            String deleteChoice = inputHandler.getDeleteChoice();
            if (deleteChoice.equalsIgnoreCase("Y")) {
                calc.removeFirstResult();
            }

            // 종료 여부 확인
            System.out.println("계속하시겠습니까? (exit 입력 시 종료)");
            if (inputHandler.checkExit()) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
        inputHandler.closeScanner();
    }
}


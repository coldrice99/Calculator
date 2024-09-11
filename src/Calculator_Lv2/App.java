package Calculator_Lv2;

/**
 * Lv2 계산기의 메인 클래스.
 * 사용자로부터 두 숫자와 연산자를 입력받고, Calculator 클래스를 이용해 연산을 수행한 후 결과를 출력합니다.
 * 'exit' 입력 시 프로그램이 종료되며, 연산 결과 리스트의 첫 번째 값을 삭제할지 여부도 처리합니다.
 */
public class App {

    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler(); //사용자 입력 및 예외처리를 하는 인스턴스 생성
        Calculator calc = new Calculator(); // 계산을 수행하고 결과를 저장하는 인스턴스 생성

        while (true) {
            // 사용자로부터 첫 번째 숫자 입력
            int num1 = inputHandler.getInputNumber("첫 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            // 사용자로부터 두 번째 숫자 입력
            int num2 = inputHandler.getInputNumber("두 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            // 연산자 입력
            char operator = inputHandler.getOperator(num2);


            // 연산 수행 및 결과 출력
            double result = calc.calculate(num1, num2, operator);
            System.out.println("결과: " + result);
            // 결과 리스트 출력
            System.out.println("결과 리스트:" + calc.getResults());


            // 결과 리스트의 첫번째 값 삭제 여부 확인
            String deleteChoice = inputHandler.getDeleteChoice();
            if (deleteChoice.equalsIgnoreCase("Y")) {
                calc.removeFirstResult(); // 첫 번째 결과 삭제
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


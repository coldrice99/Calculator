package Calculator_Lv3;

/**
 * Lv3 계산기의 메인 클래스.
 * 사용자가 입력한 두 개의 숫자와 연산자를 받아서 ArithmeticCalculator를 통해 연산을 수행하고,
 * 결과를 출력합니다.
 * 연산 결과를 리스트에 저장하며, 사용자가 입력한 값보다 큰 결과를 조회할 수 있습니다.
 */
public class App {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();  // InputHandler 인스턴스 사용
        ArithmeticCalculator<Double> calc = new ArithmeticCalculator<>();  // 제네릭으로 Double 타입 지정

        while (true) {
            // 첫 번째 숫자 입력 (Double 타입으로 입력받기)
            double num1 = inputHandler.getInputNumber("첫 번째 숫자를 입력하세요: ", Double.class);

            // 두 번째 숫자 입력
            double num2 = inputHandler.getInputNumber("두 번째 숫자를 입력하세요: ", Double.class);

            // 연산자 입력
            OperatorType operator = inputHandler.getOperator(num2);

            try {
                // 연산 수행 및 결과 출력
                double result = calc.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

                // 결과 리스트 출력
                System.out.println("결과 리스트: " + calc.getResults());

            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("오류: " + e.getMessage());
            }

            // 결과 리스트의 첫번째 값 삭제
            String deleteChoice = inputHandler.getDeleteChoice();
            if (deleteChoice.equalsIgnoreCase("Y")) {
                calc.removeFirstResult();
            }

            // 계속할지 종료할지 확인
            if (inputHandler.checkExit()) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        inputHandler.closeScanner();  // Scanner 자원 해제
    }
}

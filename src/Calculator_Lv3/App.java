package Calculator_Lv3;

/**
 * 메인 프로그램을 실행하는 클래스입니다.
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
                break;
            }
        }

        inputHandler.closeScanner();  // Scanner 자원 해제
    }
}

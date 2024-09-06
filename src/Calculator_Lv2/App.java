package Calculator_Lv2;

public class App {
    public static void main(String[] args) {

//        Calculator calc = new Calculator();
//        Scanner sc = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        Calculator calc = new Calculator();


        while (true) {

            //입력받기
            int num1 = inputHandler.getInputNumber("첫 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            int num2 = inputHandler.getInputNumber("두 번째 숫자를 입력하세요(0을 포함한 양의 정수): ");
            char operator = inputHandler.getOperator();

            //계산 수행 및 결과 저장
            try {
                double result = calc.performOperation(num1, num2, operator);
                System.out.println("결과: " + result);
                System.out.println("결과 리스트:" + calc.getResults());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            //결과 리스트의 첫번째 값 삭제
            System.out.println("결과 리스트의 첫번째 값을 삭제하시겠습니까(yes 입력 시 삭제)");
            String sc = new java.util.Scanner(System.in).nextLine();
            if(sc.equalsIgnoreCase("yes")){
                calc.removeResults();
            }

            // exit 입력 시 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String sc2 = new java.util.Scanner(System.in).nextLine();
            if (sc2.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                inputHandler.closeScanner();
                break;
            }

        }
    }

}


package Calculator_Lv3;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받아 처리하는 클래스입니다.
 * 숫자와 연산자 입력을 받고, 잘못된 입력에 대한 오류 처리도 수행합니다.
 */
public class InputHandler {
    private final Scanner sc = new Scanner(System.in);

//    사용자로부터 숫자를 입력받는 메서드.
//    제네릭 타입을 사용하여 int, double 등 다양한 숫자 타입을 처리할 수 있습니다.
//    @param prompt 사용자에게 보여줄 메시지.
//    @param type 입력받을 숫자의 타입.
//    @param <T> 숫자 타입을 제네릭으로 처리 (Number타입을 상속받은 타입)
//    @return 입력받은 숫자 (Integer 또는 Double 타입)
    public <T extends Number> T getInputNumber(String prompt, Class<T> type) {

        while (true) {
            System.out.print(prompt);
            try {
                if(type == Integer.class) {
                    return type.cast(sc.nextInt());
                } else if(type == Double.class) {
                    return type.cast(sc.nextDouble());
                } else {
                    throw new IllegalArgumentException("지원하는 타입이 아닙니다.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 다시 입력해주세요");
                sc.next(); //잘못된 입력 무시
            }
        }
    }

    /**
     * 연산자를 입력받아 OperatorType Enum으로 반환하는 메서드
     * 나눗셈의 경우 두 번째 숫자가 0이면 다시 입력을 받습니다
     * @param num2 두 번째 숫자 (나눗셈 시 0인지 확인)
     * @return 입력된 연산자에 해당하는 OperatorType Enum 값
     */
    public OperatorType getOperator(double num2) {
        while(true) {
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char symbol = sc.next().charAt(0);

            try{
                // '/'일 때 두 번째 숫자가 0인지 확인
                if(symbol == '/' && num2 == 0) {
                    System.out.println("나눗셈의 두 번째 숫자는 0이 될 수 없습니다. 다시 입력해주세요.");
                    continue;
                }
                return OperatorType.fromSymbol(symbol);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
            }
        }
    }

    /**
     * 사용자로부터 삭제 여부를 입력받는 메서드.
     * @return 'Y' 또는 'N'
     */
    public String getDeleteChoice() {
        System.out.println("결과 리스트의 첫번째 값을 삭제하시겠습니까? (Y/N)");
        return sc.next();
    }

    /**
     * 프로그램 종료 여부를 확인하는 메서드.
     * @return 'exit' 입력 시 true 반환
     */
    public boolean checkExit() {
        System.out.println("계속하시겠습니까? (exit 입력 시 종료)");
        return sc.next().equalsIgnoreCase("exit");
    }
    
    // Scanner 자원 해제
    public void closeScanner() {
        sc.close();
    }
}

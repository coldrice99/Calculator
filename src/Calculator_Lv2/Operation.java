package Calculator_Lv2;

//각 연산을 처리하는 로직을 담당
public class Operation {
    //사칙연산을 수행한 후, 결과값을 반환하는 메서드
    public double calculate(int num1, int num2, char operator) {

        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 두 번째 정수가 0일 수 없습니다.");
                }
                return (double) num1 / num2;
            default:
                throw new IllegalStateException("잘못되 연산 기호입니다. 다시 입력해주세요.");
        }

    }
}



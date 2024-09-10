package Calculator_Lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculator 클래스는 사칙연산을 수행하고, 연산 결과를 저장하는 계산기입니다.
 * 연산 결과는 내부 컬렉션에 저장되며, 외부에서는 Getter/Setter를 통해 접근할 수 있습니다.
 */
public class Calculator {

    // 연산 결과를 저장하는 컬렉션 (캡슐화되어 외부에서 직접 접근 불가)
    private final List<Integer> results;

    // 생성자: 결과 리스트 초기화
    public Calculator() {
        results = new ArrayList<>();
    }

    /**
     * 주어진 두 숫자와 연산자를 사용해 사칙연산을 수행하는 메서드.
     * 연산 결과는 내부 컬렉션에 저장되고 반환됩니다.
     *
     * @param num1 첫 번째 피연산자
     * @param num2 두 번째 피연산자
     * @param operator 사칙연산 기호 ('+', '-', '*', '/')
     * @return 연산 결과
     * @throws IllegalArgumentException 잘못된 연산자 입력 시 예외 발생
     * @throws ArithmeticException 나눗셈에서 0으로 나눌 때 예외 발생
     */
    public int calculate(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다: " + operator);
        }

        // 결과를 리스트에 저장
        results.add(result);
        return result;
    }

    /**
     * 연산 결과를 반환하는 Getter 메서드 (외부에서 간접적으로 접근 가능).
     * @return 연산 결과 리스트
     */
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 원본 보호를 위해 복사본 반환
    }

    /**
     * 연산 결과 리스트에서 가장 먼저 저장된 데이터를 삭제하는 메서드.
     */
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);  // 첫 번째 결과 삭제
            System.out.println("결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }
}

package Calculator_Lv2;

import java.util.ArrayList;
import java.util.List;


public class Calculator {

    // 연산 결과를 저장하는 컬렉션 (캡슐화되어 외부에서 직접 접근 불가)
    private final List<Integer> results;

    // 생성자: 결과 리스트 초기화
    public Calculator() {
        results = new ArrayList<>();
    }

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

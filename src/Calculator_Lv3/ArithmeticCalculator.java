package Calculator_Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제네릭을 사용해 다양한 타입의 연산을 지원하는 사칙연산 계산기 클래스.
 * 연산 결과는 리스트에 저장되고, Lambda & Stream을 사용해 결과 조회 기능도 구현.
 */
public class ArithmeticCalculator<T extends Number> {

    private final List<T> results = new ArrayList<>();

    // 연산 메서드: OperatorType Enum을 사용해 연산 수행
    public T calculate(T num1, T num2, OperatorType operator) {
        double result;
        switch (operator) {
            case ADD:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case SUBTRACT:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자: " + operator);
        }

        T finalResult = (T) Double.valueOf(result);  // 제네릭 타입으로 변환
        results.add(finalResult);
        return finalResult;
    }

    // 연산 결과 리스트를 반환하는 메서드
    public List<T> getResults() {
        return results;
    }

    // 입력된 값보다 큰 연산 결과들을 반환하는 메서드 (Lambda & Stream 사용)
    public List<T> findResultsGreaterThan(T value) {
        return results.stream()
                .filter(result -> result.doubleValue() > value.doubleValue())
                .collect(Collectors.toList());
    }

    //연산 결과 리스트에서 가장 먼저 저장된 데이터를 삭제하는 메서드.
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);  // 첫 번째 결과 삭제
            System.out.println("결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }

}

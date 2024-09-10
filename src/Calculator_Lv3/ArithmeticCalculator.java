package Calculator_Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제네릭을 사용해 다양한 타입의 연산을 지원하는 사칙연산 계산기 클래스.
 * 연산 결과는 리스트에 저장되며, Lambda & Stream을 사용해 결과 조회 기능을 제공합니다.
 * 연산 결과는 Double과 같은 실수 타입으로 처리됩니다.
 */
public class ArithmeticCalculator<T extends Number> {

    private final List<T> results = new ArrayList<>(); //연산 결과를 저장하는 리스트

    /**
     * 두 숫자와 연산자를 받아 사칙연산을 수행하는 메서드입니다.
     * @param num1 첫 번째 숫자
     * @param num2 두 번째 숫자
     * @param operator 연산자 (ADD, SUBTRACT, MULTIPLY, DIVIDE)
     * @return 연산 결과 (제네릭 타입)
     */
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
        results.add(finalResult); //결과를 리스트에 추가
        return finalResult;
    }

    /**
     * 저장된 연산 결과 리스트를 반환하는 메서드입니다.
     * @return 연산 결과 리스트
     */
    public List<T> getResults() {
        return results;
    }

    /**
     * 입력된 값보다 큰 연산 결과들을 반환하는 메서드입니다. (Lambda & Stream 사용)
     * @param value 비교할 값
     * @return 입력된 값보다 큰 결과들의 리스트
     */
    public List<T> findResultsGreaterThan(T value) {
        return results.stream()
                .filter(result -> result.doubleValue() > value.doubleValue())
                .collect(Collectors.toList());
    }

    /**
     * 연산 결과 리스트에서 가장 먼저 저장된 결과를 삭제하는 메서드입니다.
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

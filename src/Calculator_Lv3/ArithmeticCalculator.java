package Calculator_Lv3;

import java.util.List;
import java.util.stream.Collectors;

//ArithmeticCalculator 클래스는 제네릭을 사용하여 다양한 숫자 타입을 처리하는  사칙연산 계산기이다.
//@param <T> 연산에 사용할 숫자의 타입 T는 Number를 확장하는 타입이어야 한다.
public class ArithmeticCalculator<T extends Number> {

    public double calculate(T num1, T num2, OperatorType operator) {
        switch (operator) {
            case ADD:
                return num1.doubleValue() + num2.doubleValue();
            case SUBSTRACT:
                return num1.doubleValue() - num2.doubleValue();
            case MULTIPLY:
                return num1.doubleValue() * num2.doubleValue();
            case DIVIDE:
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 두 번째 정수가 0일 수 없습니다.");
                }
                return num1.doubleValue() / num2.doubleValue();
            default:
                throw new IllegalArgumentException("잘못되 연산 기호입니다. 다시 입력해주세요.");
        }
    }

    //저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력하는 메서드
    public List<Double> getResultsGraterThan(List<Double> results, double threshold) {
        return results.stream()
                .filter(result -> result > threshold) //람다를 사용한 필터링
                .collect(Collectors.toList()); //필터링된 결과를 리스트로 반환
    }

}

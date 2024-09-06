package Calculator_Lv2;

import java.util.ArrayList;
import java.util.List;

//결과를 관리하고 계산을 수행하는 역할을 담당
public class Calculator {
    //연산 결과를 저장하는 컬렉션 타입 필드
    private final List<Double> results = new ArrayList<>();
    private final Operation operation = new Operation();

    //사칙연산을 수행한 후, 결과값을 반환하는 메서드
    public void addResult(double result) {
        results.add(result);
    }

    //setter 역할도 수행
    public double performOperation(int num1, int num2, char operator) {
        double result = operation.calculate(num1, num2, operator);
        addResult(result);
        return result;
    }

    //getter
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            throw new IndexOutOfBoundsException("삭제할 연산 결과가 없습니다.");
        }
    }
}

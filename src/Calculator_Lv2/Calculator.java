package Calculator_Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //연산 결과를 저장하는 컬렉션 타입 필드
    private List<Double> results = new ArrayList<>();

    //사칙연산을 수행한 후, 결과값을 반환하는 메서드
    public List<Double> calculate(int num1, int num2, char operator) {
        double result = 0;

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
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 두 번째 정수가 0일 수 없습니다.");
                }
                result = (double) num1 / num2;
                break;
            default:
                throw new IllegalStateException("잘못되 연산 기호입니다. 다시 시도해주세요.");
        }
        //결과를 리스트에 저장
        results.add(result);

        return results;
    }
    //getter
    public List<Double> getResults() {
        return results;
    }
    //setter
    public void setResults(int num1, int num2, char operator) {
        calculate(num1, num2, operator);
    }

    //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResults() {
        if(!results.isEmpty()) {
            results.remove(0);
        } else {
            throw new IndexOutOfBoundsException("삭제할 연산 결과가 없습니다.");
        }
    }
}

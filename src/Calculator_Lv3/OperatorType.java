package Calculator_Lv3;

//OperatorType Enum은 ArithmeticCalculator에 사용되는 연산자 정보를 관리한다.
public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    // 연산자를 나타내는 symbol (기호)를 저장할 필드
    private final char symbol;


    // Enum의 생성자로, 각 연산자에 해당하는 symbol을 초기화한다.
    // @param symbol 연산을 나타내는 문자('+', '-', '*', '/')
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // 주어진 symbol을 바탕으로 해당하는 OperatorType Enum을 반환하는 정적 메서드
    // 입력된 연산자 기호와 일치하는 Enum 상수를 찾습니다.
    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType type : OperatorType.values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        // 일치하는 연산자가 없을 경우 예외를 발생시킴
        throw new IllegalArgumentException("잘못된 연산자입니다: " + symbol);
    }

}

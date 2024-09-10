package Calculator_Lv3;

/**
 * 연산자 타입을 Enum으로 정의한 클래스입니다.
 * ArithmeticCalculator에서 사용될 사칙연산 타입을 관리합니다.
 */
public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    // 연산자를 나타내는 symbol을 저장할 필드
    private final char symbol;


    /**
     * Enum 생성자입니다. 각 연산자에 해당하는 symbol을 초기화합니다.
     * @param symbol 연산을 나타내는 문자
     */
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    /**
     * symbol 필드를 반환하는 메서드입니다.
     * @return 연산자 symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * 입력된 symbol에 해당하는 OperatorType Enum을 반환하는 메서드입니다.
     * @param symbol 연산자 문자
     * @return 해당하는 OperatorType Enum 값
     */
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

package study.stringCalculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> first / second);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    private static final Map<String, Operator> operatorMap =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.getSymbol(), operator -> operator)));

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int operate(int first, int second) {
        return operation.apply(first, second);
    }

    public static Operator findOperator(String symbol) throws IllegalArgumentException {

        Operator operator = operatorMap.get(symbol);

        if (operator == null) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        return operator;
    }
}

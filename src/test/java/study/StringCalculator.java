package study;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {

    private String[] inputStringArr;
    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public int execute() throws IllegalArgumentException {
        processInputString();
        return processInputStringArr();
    }

    public void processInputString() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);

        try {
            String inputString = sc.nextLine();
            inputStringArr = inputString.split(" ");
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력 문자열이 올바르지 않습니다.");
        }

        sc.close();
    }

    public int processInputStringArr() throws IllegalArgumentException {

        Operator operator = Operator.PLUS;
        int result = 0;
        boolean operatorFlag = false; // 연산자 차례 여부

        for (int i = 0; i < inputStringArr.length; i++) {
            boolean isNumber = pattern.matcher(inputStringArr[i]).find();

            if (operatorFlag && isNumber) {
                // 연산자가 나와야 하는 차례인데 숫자가 나온 경우
                throw new IllegalArgumentException("입력 문자열이 올바르지 않습니다.");
            }

            if (!operatorFlag && !isNumber) {
                // 숫자가 나와야 하는 차례인데 문자가 나온 경우
                throw new IllegalArgumentException("입력 문자열이 올바르지 않습니다.");
            }

            if (isNumber) {
                result = operator.operate(result, Integer.parseInt(inputStringArr[i]));
                operatorFlag = true;
                continue;
            }

            operator = Operator.findOperator(inputStringArr[i]);
            operatorFlag = false;
        }

        return result;
    }
}

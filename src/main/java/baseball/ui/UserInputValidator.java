package baseball.ui;

public class UserInputValidator {

    public static void validateDigits(String inputNumberString, int minDigits, int maxDigits)
        throws IllegalArgumentException {
        if (inputNumberString == null || inputNumberString.isEmpty()) {
            throw new IllegalArgumentException("입력한 값이 공백입니다.");
        }

        if (!inputNumberString.matches("[0-9]+")) {
            throw new IllegalArgumentException("입력한 값이 숫자가 아닙니다.");
        }

        if (inputNumberString.length() < minDigits) {
            throw new IllegalArgumentException(String.format("입력한 값이 %d자리 미만입니다.", minDigits));
        }

        if (inputNumberString.length() > maxDigits) {
            throw new IllegalArgumentException(String.format("입력한 값이 %d자리 초과입니다.", maxDigits));
        }
    }

    public static void validateRange(String inputNumberString, int minRange, int maxRange)
        throws IllegalArgumentException {
        int inputNumber = Integer.parseInt(inputNumberString);

        if (inputNumber < minRange) {
            throw new IllegalArgumentException(String.format("입력한 값이 %d 미만입니다.", minRange));
        }

        if (inputNumber > maxRange) {
            throw new IllegalArgumentException(String.format("입력한 값이 %d 초과입니다.", maxRange));
        }
    }

}

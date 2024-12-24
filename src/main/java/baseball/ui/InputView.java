package baseball.ui;

import java.util.Scanner;

public class InputView {

    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    /**
     * 사용자로부터 3자리 숫자를 입력받아 int 배열로 반환한다.
     * @return 사용자 입력 숫자
     * @throws IllegalArgumentException 입력값이 3자리가 아닌 경우
     */
    public int[] getUserNumber() throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = sc.nextLine();

        UserInputValidator.validateDigits(inputString, 3, 3);

        int[] inputNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            inputNumber[i] = inputString.charAt(i) - '0';
        }

        return inputNumber;
    }

    /**
     * 사용자로부터 게임을 계속할지 여부를 입력받아 boolean으로 반환한다.
     * @return 게임 계속 여부
     * @throws IllegalArgumentException 사용자 입력 값이 1 또는 2가 아닌 경우
     */
    public boolean checkUserContinue() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String inputString = sc.nextLine();
        UserInputValidator.validateDigits(inputString, 1, 1);
        UserInputValidator.validateRange(inputString, 1, 2);
        int inputNumber = Integer.parseInt(inputString);

        if (inputNumber == 1) {
            return true;
        }

        if (inputNumber == 2) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }

}

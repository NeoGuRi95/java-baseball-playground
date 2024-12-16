package baseball.ui;

import java.util.Scanner;

public class InputView {

    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public String execute() throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = sc.nextLine();

        UserInputValidator.validateDigits(inputString, 3, 3);

        return inputString;
    }

}

package baseball.ui;

import static java.lang.System.exit;

import java.util.Scanner;

public class ResultView {

    private final Scanner sc;

    public ResultView(Scanner sc) {
        this.sc = sc;
    }

    public void execute(int ball, int strike) throws IllegalArgumentException {
        validateBallAndStrike(ball, strike);
        printResult(ball, strike);
        checkContinue(strike);
    }

    private void validateBallAndStrike(int ball, int strike) throws IllegalArgumentException {
        if (ball < 0 || ball > 3) {
            throw new IllegalArgumentException("볼의 개수는 0이상 3이하여야 합니다.");
        }

        if (strike < 0 || strike > 3) {
            throw new IllegalArgumentException("스트라이크의 개수는 0이상 3이하여야 합니다.");
        }
    }

    public void printResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }

        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    public void checkContinue(int strike) throws IllegalArgumentException {
        if (strike < 3) return;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String inputString = sc.nextLine();
        UserInputValidator.validateDigits(inputString, 1, 1);
        UserInputValidator.validateRange(inputString, 1, 2);
        int inputNumber = Integer.parseInt(inputString);

        if (inputNumber == 1) {
            return;
        }

        if (inputNumber == 2) {
            exit(0);
        }
    }

}

package baseball;

import baseball.ui.InputView;
import baseball.ui.ResultView;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        ResultView resultView = new ResultView(sc);

        while (true) {
            String inputNumber = inputView.execute();

            // TODO: 핵심 로직 구현

            resultView.execute(0, 3);
        }
    }
}

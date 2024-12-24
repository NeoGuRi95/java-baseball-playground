package baseball;

import baseball.core.RandomGenerator;
import baseball.core.Referee;
import baseball.ui.InputView;
import baseball.ui.ResultView;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        ResultView resultView = new ResultView();
        Referee referee = new Referee();

        boolean isContinue = true;

        while (isContinue) {

            boolean isSuccess = false; // 성공 여부
            int[] answer = RandomGenerator.generateNumbers(1, 9, 3); // 정답

            while (!isSuccess) { // 사용자가 맞출 때 까지 반복
                int[] inputNumberArr = inputView.getUserNumber(); // 사용자 입력 값

                int[] result = referee.judge(answer, inputNumberArr); // 결과

                if (result[0] == 3) isSuccess = true; // 3스트라이크면 성공

                resultView.execute(result[0], result[1]); // 결과 출력
            }

            isContinue = inputView.checkUserContinue(); // 게임 재시작 여부 확인
        }
    }
}

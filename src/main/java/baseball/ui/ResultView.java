package baseball.ui;

public class ResultView {

    public void execute(int strike, int ball) throws IllegalArgumentException {
        validateBallAndStrike(strike, ball);
        printResult(strike, ball);
    }

    /**
     * 볼과 스트라이크의 개수가 정상 벙위인지 검증한다.
     * @param strike 스트라이크 수
     * @param ball 볼 수
     * @throws IllegalArgumentException 스트라이크와 볼의 개수가 0이상 3이하가 아닐 경우
     */
    private void validateBallAndStrike(int strike, int ball) throws IllegalArgumentException {
        if (ball < 0 || ball > 3) {
            throw new IllegalArgumentException("볼의 개수는 0이상 3이하여야 합니다.");
        }

        if (strike < 0 || strike > 3) {
            throw new IllegalArgumentException("스트라이크의 개수는 0이상 3이하여야 합니다.");
        }
    }

    /**
     * 볼과 스트라이크의 개수를 출력한다.
     * @param strike 스트라이크 수
     * @param ball 볼 수
     */
    public void printResult(int strike, int ball) {
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



}

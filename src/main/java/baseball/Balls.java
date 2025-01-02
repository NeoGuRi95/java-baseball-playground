package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> ballList = new ArrayList<>();

    public Balls(List<Integer> numberList) throws IllegalArgumentException {
        validateNumberList(numberList);
        mapBallList(numberList);
    }

    private void validateNumberList(List<Integer> numberList) throws IllegalArgumentException {
        if (numberList.size() != 3) {
            throw new IllegalArgumentException("숫자 목록의 길이는 3이어야 합니다.");
        }
    }

    private void mapBallList(List<Integer> numberList) {
        for (int i = 0; i < 3; i++) {
            Ball ball = new Ball(i, numberList.get(i));
            this.ballList.add(ball);
        }
    }

    public int size() {
        return this.ballList.size();
    }

    public Ball get(int position) {
        return this.ballList.get(position);
    }

    public BallStatus judge(Ball inputBall) {
        for (int i = 0; i < 3; i++) {
            Ball ball = this.ballList.get(i);
            BallStatus result = ball.judge(inputBall);
            if (!result.isNothing()) return result;
        }
        return BallStatus.NOTHING;
    }

    public GameResult judge(Balls inputBalls) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < 3; i++) {
            Ball inputBall = inputBalls.get(i);
            BallStatus ballStatus = this.judge(inputBall);
            gameResult.add(ballStatus);
        }
        return gameResult;
    }
}

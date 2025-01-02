package baseball;

import java.util.Objects;

public class Ball {

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 2;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int position;
    private int number;

    public Ball(int position, int number) throws IllegalArgumentException {
        mapPosition(position);
        mapNumber(number);
    }

    private void mapPosition(int position) throws IllegalArgumentException {
        if (MIN_POSITION <= position && position <= MAX_POSITION) {
            this.position = position;
            return;
        }
        throw new IllegalArgumentException("볼의 위치값은 0부터 2사이의 숫자여야 합니다.");
    }

    private void mapNumber(int number) throws IllegalArgumentException {
        if (MIN_NUMBER <= number && number <= MAX_NUMBER) {
            this.number = number;
            return;
        }
        throw new IllegalArgumentException("볼의 숫자는 1부터 9사이의 숫자여야 합니다.");
    }

    public BallStatus judge(Ball inputBall) {
        if (this.equals(inputBall)) {
            return BallStatus.STRIKE;
        } else if (inputBall.equalsNumber(this.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return ball.equalsPosition(this.position) && ball.equalsNumber(this.number);
    }

    private boolean equalsPosition(int position) {
        return this.position == position;
    }

    private boolean equalsNumber(int number) {
        return this.number == number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}

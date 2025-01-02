package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    @Test
    @DisplayName("스트라이크 테스트")
    void strikeTest() {
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(1, 1);

        BallStatus result = computerBall.judge(userBall);

        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 테스트")
    void ballTest() {
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(2, 1);

        BallStatus result = computerBall.judge(userBall);

        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothingTest() {
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(2, 2);

        BallStatus result = computerBall.judge(userBall);

        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-1, 1",
        "3, 1"
    })
    @DisplayName("잘못된 볼의 위치값 테스트")
    void wrongPositionTest(int position, int number) {
        assertThatThrownBy(() -> {
            new Ball(position, number);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("볼의 위치값은 0부터 2사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1, 0",
        "1, 10"
    })
    @DisplayName("잘못된 볼의 숫자 테스트")
    void wrongNumberTest(int position, int number) {
        assertThatThrownBy(() -> {
            new Ball(position, number);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("볼의 숫자는 1부터 9사이의 숫자여야 합니다.");
    }
}
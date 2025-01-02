package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.StringUtil;

public class BallsTest {

    @Test
    @DisplayName("숫자 목록에서 볼 목록 생성 성공 테스트")
    void createBallsTest() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 목록에서 볼 목록 생성 실패 테스트")
    void createWrongBallsTest() {
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 2));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자 목록의 길이는 3이어야 합니다.");
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strikeTest() {
        Ball ball = new Ball(0, 1);
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus result = balls.judge(ball);

        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 테스트")
    void ballTest() {
        Ball ball = new Ball(1, 1);
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus result = balls.judge(ball);

        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothingTest() {
        Ball ball = new Ball(0, 4);
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus result = balls.judge(ball);

        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "'[1, 2, 3]', '[1, 2, 3]', true",
        "'[1, 2, 3]', '[4, 5, 6]', false",
        "'[1, 2, 3]', '[3, 2, 1]', false",
        "'[1, 2, 3]', '[1, 2, 4]', false"
    })
    @DisplayName("게임 결과 테스트")
    void gameResultTest(String answerArrayStr, String userInput, boolean expectedResult) {
        List<Integer> answerNumberList = StringUtil.arrStrToList(answerArrayStr);
        List<Integer> userNumberList = StringUtil.arrStrToList(userInput);

        Balls answerBalls = new Balls(answerNumberList);
        Balls userBalls = new Balls(userNumberList);

        GameResult result = answerBalls.judge(userBalls);

        assertThat(result.isAnswer()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "'[1, 2, 3]', '[1, 2, 3]', 3스트라이크",
        "'[1, 2, 3]', '[4, 5, 6]', 낫싱",
        "'[1, 2, 3]', '[3, 2, 1]', 2볼 1스트라이크",
        "'[1, 2, 3]', '[1, 2, 4]', 2스트라이크",
        "'[1, 2, 3]', '[3, 1, 2]', 3볼",
    })
    @DisplayName("게임 결과 문자열 테스트")
    void gameResultToStringTest(String answerArrayStr, String userInput, String expectedResult) {
        List<Integer> answerNumberList = StringUtil.arrStrToList(answerArrayStr);
        List<Integer> userNumberList = StringUtil.arrStrToList(userInput);

        Balls answerBalls = new Balls(answerNumberList);
        Balls userBalls = new Balls(userNumberList);

        GameResult result = answerBalls.judge(userBalls);

        assertThat(result.toString()).isEqualTo(expectedResult);
    }
}

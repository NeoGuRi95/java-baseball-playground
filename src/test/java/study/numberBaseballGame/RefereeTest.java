package study.numberBaseballGame;

import baseball.core.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import study.converter.IntArrayConverter;

import static org.assertj.core.api.Assertions.*;

public class RefereeTest {

    private final Referee referee = new Referee();

    @ParameterizedTest
    @CsvSource(value = {
        "'1, 2, 3':'1, 2, 3':3:0",
        "'1, 2, 3':'4, 5, 6':0:0",
        "'1, 2, 3':'3, 2, 1':1:2",
    }, delimiter = ':')
    @DisplayName("볼, 스트라이크 정상 판단 테스트")
    void judgeTest(@ConvertWith(IntArrayConverter.class) int[] answer,
                   @ConvertWith(IntArrayConverter.class) int[] inputNumberArr,
                   int expectedStrike, int expectedBall) {
        // when
        int[] result = referee.judge(answer, inputNumberArr);

        // then
        assertThat(result).containsExactly(expectedStrike, expectedBall);
    }

}

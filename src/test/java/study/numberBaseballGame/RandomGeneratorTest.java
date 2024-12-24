package study.numberBaseballGame;

import baseball.core.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void generateNumbersTest() {
        // given
        int min = 1;
        int max = 9;
        int size = 3;

        // when
        int[] numbers = RandomGenerator.generateNumbers(min, max, size);

        // then
        assertThat(numbers).hasSize(size);
        assertThat(numbers).doesNotHaveDuplicates();
    }

}

package study;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    public static void inputHandling(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void complexOperatorTest() {
        inputHandling("2 + 3 * 4 / 2 - 2");
        Integer actual = calculator.execute();
        assertThat(actual).isEqualTo(8);
    }

    @Test
    void plusOperatorTest() {
        inputHandling("2 + 3");
        Integer actual = calculator.execute();
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void minusOperatorTest() {
        inputHandling("3 - 2");
        Integer actual = calculator.execute();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void multiplyOperatorTest() {
        inputHandling("2 * 3");
        Integer actual = calculator.execute();
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void divideOperatorTest() {
        inputHandling("4 / 2");
        Integer actual = calculator.execute();
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void emptyStringTest() {
        inputHandling("");
        assertThatThrownBy(() -> {
            calculator.execute();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력 문자열이 올바르지 않습니다.");
    }

    @Test
    void invalidSequenceTest() {
        inputHandling("2 + + 2");
        assertThatThrownBy(() -> {
            calculator.execute();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력 문자열이 올바르지 않습니다.");
    }

    @Test
    void operatorFirstTest() {
        inputHandling("+ 2 + 1");
        assertThatThrownBy(() -> {
            calculator.execute();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력 문자열이 올바르지 않습니다.");
    }

    @Test
    void invalidOperatorTest() {
        inputHandling("2 ^ 2");
        assertThatThrownBy(() -> {
            calculator.execute();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("사칙연산 기호가 아닙니다.");
    }

}

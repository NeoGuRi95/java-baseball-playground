package study.numberBaseballGame;

import baseball.ui.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private InputView inputView = new InputView();

    public static void inputHandling(String input) {
        if (input == null) input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @ParameterizedTest
    @CsvSource(value = {
        " :입력한 값이 공백입니다.",
        "not number:입력한 값이 숫자가 아닙니다.",
        "11:입력한 값이 3자리 미만입니다.",
        "1111:입력한 값이 3자리 초과입니다"
    }, delimiter = ':')
    @DisplayName("유효하지 않은 입력값 테스트")
    void invalidInputTest(String inputString, String expectedMessage) {
        // given
        inputHandling(inputString);

        // when
        // then
        assertThatThrownBy(() -> {
            inputView.execute();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(expectedMessage);
    }
}

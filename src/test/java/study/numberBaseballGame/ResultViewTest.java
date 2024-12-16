package study.numberBaseballGame;

import baseball.ui.ResultView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ResultView resultView = new ResultView();

    public static void inputHandling(String input) {
        if (input == null) input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0:0:낫싱",
        "1:0:1볼",
        "2:0:2볼",
        "3:0:3볼",
        "0:1:1스트라이크",
        "0:2:2스트라이크",
        "0:3:3스트라이크",
        "1:1:1볼 1스트라이크",
        "1:2:1볼 2스트라이크",
        "2:1:2볼 1스트라이크"
    }, delimiter = ':')
    @DisplayName("볼, 스트라이크 결과 정상 출력 테스트")
    void validPrintResultTest(int ball, int strike, String expected) {
        resultView.printResult(ball, strike);
        assertEquals(expected, outContent.toString().trim());
    }
}

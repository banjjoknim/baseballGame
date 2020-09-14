import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HintTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @CsvSource(value = {"378:123:0", "378:348:2", "378:148:1", "378:378:3"}, delimiter = ':')
    void countStrikeTest(String answer, String input, String correctAnswer) {
        Hint hint = new Hint();
        int expected = Integer.valueOf(correctAnswer);
        int actual = hint.countStrike(answer, input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"378:123:1", "378:348:0", "378:148:0", "378:378:0", "378:734:2", "378:837:3"}, delimiter = ':')
    void countBallTest(String answer, String input, String correctAnswer) {
        Hint hint = new Hint();
        int expected = Integer.valueOf(correctAnswer);
        int actual = hint.countBall(answer, input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"378:123:1 볼", "378:348:2 스트라이크", "378:148:1 스트라이크", "378:378:3 스트라이크", "378:734:2 볼",
        "378:837:3 볼", "378:387:1 스트라이크 2 볼"}, delimiter = ':')
    void showTest(String answer, String input, String expected) {
        Hint hint = new Hint();
        hint.show(answer, input);
        String actual = byteArrayOutputStream.toString().trim();
        assertThat(actual).isEqualTo(expected);
    }
}

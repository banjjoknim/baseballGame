import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    @CsvSource(value = {"378 123:0", "378 348:2", "378 148:1", "378 378:3"}, delimiter = ':')
    void countStrikeTest(String input, String expected) {
        Hint hint = new Hint();
        String number = input.split(" ")[0];
        String answer = input.split(" ")[1];
        Assertions.assertEquals(hint.countStrike(number, answer), Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"378 123:1", "378 348:0", "378 148:0", "378 378:0", "378 734:2", "378 837:3"}, delimiter = ':')
    void countBallTest(String input, String expected) {
        Hint hint = new Hint();
        String number = input.split(" ")[0];
        String answer = input.split(" ")[1];
        Assertions.assertEquals(hint.countBall(number, answer), Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"378 123:1 볼", "378 348:2 스트라이크", "378 148:1 스트라이크", "378 378:3 스트라이크", "378 734:2 볼",
        "378 837:3 볼"}, delimiter = ':')
    void showTest(String input, String expected) {
        Hint hint = new Hint();
        String number = input.split(" ")[0];
        String answer = input.split(" ")[1];
        hint.show(number, answer);
        Assertions.assertEquals(expected, byteArrayOutputStream.toString().trim());
    }
}

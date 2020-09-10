import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChoiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void choose(String input) throws IOException {
        Choice choice = new Choice();
        if (input.equals("1")) {
            Assertions.assertTrue(choice.choose(input));
        }
        if (input.equals("2")) {
            Assertions.assertFalse(choice.choose(input));
        }
    }
}

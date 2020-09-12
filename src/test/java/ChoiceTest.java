import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChoiceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void choose(String input) throws IOException {
        Choice choice = new Choice();
        if (input.equals("1")) {
            assertThat(choice.newGame()).isTrue();
        }
        if (input.equals("2")) {
            assertThat(choice.newGame()).isFalse();
        }

    }
}

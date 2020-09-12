import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestrictionTest {

    Restriction restriction = new Restriction();

    @ParameterizedTest
    @ValueSource(strings = {"1283", "sdf", "113", "4569", "533", "abc", "kfc", "oow", "484"})
    void check(String input) {
        assertThat(restriction.check(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void checkSelect(String input) {
        if (input.equals("1") || input.equals("2")) {
            assertThat(restriction.checkSelect(input)).isTrue();
        } else {
            assertThat(restriction.checkSelect(input)).isFalse();
        }
    }
}

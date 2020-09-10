import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RestrictionTest {

    Restriction restriction = new Restriction();

    @ParameterizedTest
    @ValueSource(strings = {"1283", "sdf", "113", "4569", "533", "abc", "kfc", "oow", "484"})
    void check(String input) {
        Assertions.assertFalse(restriction.check(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void checkSelect(String input) {
        if (input.equals("1") || input.equals("2")) {
            Assertions.assertTrue(restriction.checkSelect(input));
        } else {
            Assertions.assertFalse(restriction.checkSelect(input));
        }
    }
}

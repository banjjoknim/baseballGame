import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RestrictionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1283", "sdf", "113", "4569", "533", "abc", "kfc", "oow", "484"})
    void check(String input) {
        Restriction restriction = new Restriction();
        Assertions.assertFalse(restriction.check(input));
    }
}

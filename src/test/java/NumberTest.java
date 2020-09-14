import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberTest {
    Number number = new Number();
    String createdNumber = number.create();

    @Test
    void checkNumberHasOverlap() {
        assertThat(createdNumber.chars()
            .distinct()
            .count()).isEqualTo(3);
    }

    @Test
    void checkIsNumberTest() {
        assertThat(createdNumber.chars()
            .allMatch(numberCharacter -> '0' < numberCharacter && numberCharacter <= '9')).isTrue();
    }
}

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void createTest() {
        Number number = new Number();
        assertThat(number.create().chars()
            .distinct()
            .count()).isEqualTo(3);
        assertThat(number.create().chars()
            .noneMatch(numberCharacter -> numberCharacter <= 48 || numberCharacter > 57)).isTrue();
    }
}

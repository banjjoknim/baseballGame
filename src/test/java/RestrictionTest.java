import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestrictionTest {

    Restriction restriction = new Restriction();

    @ParameterizedTest
    @ValueSource(strings = {"123", "486", "387", "267", "954", "527"})
    void checkCorrectIsTrueTest(String input) { // 옳은 숫자 입력 테스트
        assertThat(restriction.checkInputIsCorrect(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1283", "sdf", "113", "4569", "533", "abc", "kfc", "oow", "484"})
    void checkCorrectIsFalseTest(String input) { // 틀린 숫자 입력 테스트
        assertThat(restriction.checkInputIsCorrect(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void checkSelectIsTrueTest(String input) { // 옳은 선택지 입력 테스트
        assertThat(restriction.checkSelectIsCorrect(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "okGo!2", "ok", "newGame"})
    void checkSelectIsFalseTest(String select) { // 잘못된 선택지 입력 테스트
        assertThat(restriction.checkSelectIsCorrect(select)).isFalse();
    }
}

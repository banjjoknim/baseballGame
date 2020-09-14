import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChoiceTest { // 현재 입력값에 대한 테스트는 진행이 불가능한 실력입니다.
    Choice choice = new Choice();

    @ParameterizedTest
    @ValueSource(booleans = {true})
    void chooseNewGameTest(boolean input) throws IOException {
            assertThat(choice.isNewGame()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {false})
    void chooseEndGameTest(boolean input) throws IOException {
        assertThat(choice.isNewGame()).isFalse();
    }
}

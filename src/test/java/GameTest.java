import java.io.IOException;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void playTest() throws IOException {
        Game game = new Game();
        game.play();
    }
}

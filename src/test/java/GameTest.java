import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void play() throws IOException {
        Game game = new Game();
        game.play();
    }
}

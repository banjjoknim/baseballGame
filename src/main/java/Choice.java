import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choice {
    public static final String NEW_GAME_START = "1";
    public static final String GAME_END = "2";
    private Game game = new Game();
    private Restriction restriction = new Restriction();
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    boolean isNewGame() throws IOException {
        while (true) {
            String select = bufferedReader.readLine();
            if (!restriction.checkSelectIsCorrect(select)) {
                System.out.println(game.WRONG_INPUT);
                continue;
            }
            if (select.equals(NEW_GAME_START)) {
                return true;
            }
            return false;
        }
    }
}

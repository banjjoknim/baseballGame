import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private static final String START_GAME = "게임을 시작합니다.";
    private static final String CONGRATURATION = "축하합니다! 3개의 숫자를 모두 맞히셨습니다.";
    private static final String PLEASE_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String PLEASE_INPUT = "숫자를 입력해주세요.";
    public static final String WRONG_INPUT = "잘못 입력하셨습니다. 다시 입력해주세요.";
    private static final String END_GAME = "수고하셨습니다. 게임을 종료합니다.";

    private boolean newGame = true;

    void play() throws IOException {
        Hint hint = new Hint();
        Choice choice = new Choice();
        Number number = new Number();
        Restriction restriction = new Restriction();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(input);

        String answer;

        while (true) {
            if (newGame) {
                answer = number.create();
                System.out.println(START_GAME);
                newGame = false;
                System.out.println(answer);
            } else {
                System.out.println(END_GAME);
                break;
            }
            System.out.println(PLEASE_INPUT);
            String inputStr = bufferedReader.readLine();
            if (!restriction.checkInputIsCorrect(inputStr)) {
                System.out.println(WRONG_INPUT);
                continue;
            }
            hint.show(answer, inputStr);
            if (hint.countStrike(answer, inputStr) != 3) {
                continue;
            }
            System.out.println(CONGRATURATION);
            System.out.println(PLEASE_CHOICE);
            if(choice.isNewGame()){
                newGame = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.play();
    }
}

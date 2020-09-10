import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    void play() throws IOException {
        Hint hint = new Hint();
        Choice choice = new Choice();
        Number number = new Number();
        Restriction restriction = new Restriction();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(input);

        System.out.println("게임을 시작합니다.");
        boolean newGame = true;
        String answer = null;

        while (true) {
            if (newGame) {
                answer = number.create();
                newGame = false;
            }
            System.out.println("숫자를 입력해주세요.");
            String inputStr = bufferedReader.readLine();
            if (!restriction.check(inputStr)) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                continue;
            }
            hint.show(answer, inputStr);
            if (hint.countStrike(answer, inputStr) != 3) {
                continue;
            }
            if (hint.countStrike(answer, inputStr) == 3) {
                System.out.println("축하합니다. 3개의 숫자를 모두 맞히셨습니다!");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String select = bufferedReader.readLine();
                if (restriction.checkSelect(select)) {
                    if (choice.choose(select)) {
                        System.out.println("새 게임을 시작합니다.");
                        newGame = true;
                    } else {
                        System.out.println("수고하셨습니다. 게임을 종료합니다.");
                        break;
                    }
                }
                if (!restriction.checkSelect(select)) {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    continue;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.play();
    }
}

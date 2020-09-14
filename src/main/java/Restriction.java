import java.util.Arrays;

public class Restriction {
    private static final int CORRECT_INPUT_LENGTH = 3;
    private static final int CORRECT_INPUT_CHAR_MAX = 57;
    private static final int CORRECT_INPUT_CHAR_MIN = 49;

    public boolean checkInputIsCorrect(String input) {
        int inputLength = (int) Arrays.stream(input.split("")).distinct().count();
        if (inputLength != CORRECT_INPUT_LENGTH) {
            return false;
        }
        for (char number : input.toCharArray()) {
            if (number < CORRECT_INPUT_CHAR_MIN || number > CORRECT_INPUT_CHAR_MAX) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSelectIsCorrect(String input) {
        return input.equals(Choice.NEW_GAME_START) || input.equals(Choice.GAME_END);
    }
}

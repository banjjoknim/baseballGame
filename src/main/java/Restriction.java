import java.util.Arrays;

public class Restriction {
    private static final int CORRECT_INPUT_LENGTH = 3;
    private static final int CORRECT_INPUT_CHAR_MAX = 57;
    private static final int CORRECT_INPUT_CHAR_MIN = 49;

    public boolean check(String input) {
        int inputLength = (int) Arrays.stream(input.split("")).distinct().count();
        if (inputLength != CORRECT_INPUT_LENGTH) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c < CORRECT_INPUT_CHAR_MIN || c > CORRECT_INPUT_CHAR_MAX) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSelect(String input) {
        if (input.equals("1") || input.equals("2")) {
            return true;
        }
        return false;
    }
}

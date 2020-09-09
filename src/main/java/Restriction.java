import java.util.Arrays;

public class Restriction {

    public boolean check(String input) {
        if (Arrays.stream(input.split("")).distinct().count() != 3) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c <= 48 || c > 57) {
                return false;
            }
        }
        return true;
    }
}

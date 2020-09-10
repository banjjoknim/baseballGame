import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choice {

    boolean choose(String choice) throws IOException {
        if (choice.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}

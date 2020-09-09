import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choice {

    boolean choose() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String choice = bufferedReader.readLine();
            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Hint {
    private static final String STRIKE = " 스트라이크 ";
    private static final String BALL = " 볼 ";
    private static final String FOUR_BALL = "포볼";

    int countStrike(String number, String input) {
        List<String> numberList = Arrays.asList(number.split(""));
        List<String> inputList = Arrays.asList(input.split(""));
        int size = numberList.size();
        return (int) IntStream.range(0, size)
            .filter(index -> numberList.get(index).equals(inputList.get(index)))
            .count();
    }

    int countBall(String number, String input) {
        List<String> numberList = Arrays.asList(number.split(""));
        List<String> inputList = Arrays.asList(input.split(""));
        int containCount = (int) inputList.stream()
            .filter(inputNumber -> numberList.contains(inputNumber))
            .count();
        return containCount - countStrike(number, input);
    }

    public void show(String number, String input) {
        int strikeCount = countStrike(number, input);
        int ballCount = countBall(number, input);

        if (strikeCount != 0) {
            System.out.print(countStrike(number, input) + STRIKE);
        }

        if (ballCount != 0) {
            System.out.print(countBall(number, input) + BALL);
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(FOUR_BALL);
        }
        System.out.println();
    }
}

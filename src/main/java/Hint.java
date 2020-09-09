import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Hint {

    public int countStrike(String number, String input) {
        List<String> numberList = Arrays.asList(number.split(""));
        List<String> inputList = Arrays.asList(input.split(""));
        return (int)IntStream.range(0, numberList.size())
            .filter(index -> numberList.get(index).equals(inputList.get(index)))
            .count();
    }

    public int countBall(String number, String input) {
        List<String> numberList = Arrays.asList(number.split(""));
        List<String> inputList = Arrays.asList(input.split(""));
        int containCount = (int)inputList.stream()
            .filter(item -> numberList.contains(item))
            .count();
        int StrikeCount = (int)IntStream.range(0, numberList.size())
            .filter(index -> numberList.get(index).equals(inputList.get(index)))
            .count();
        return containCount - StrikeCount;
    }

    public void show(String number, String input) {
        String showStr = "";
        String strikeStr = "";
        String ballStr = "";

        if (countStrike(number, input) != 0) {
            strikeStr = countStrike(number, input) + " 스트라이크";
        } else {
            strikeStr = "";
        }

        if (countBall(number, input) != 0) {
            ballStr = countBall(number, input) + " 볼";
        } else {
            ballStr = "";
        }

        if (countBall(number, input) == 0 && countStrike(number, input) == 0) {
            showStr = "낫싱";
        } else {
            showStr = strikeStr.concat(ballStr);
        }

        System.out.println(showStr);
    }
}

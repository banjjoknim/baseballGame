import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Number {
    private static final int NUMBER_LENGTH_LIMIT = 3;
    public static final int MAX_VALUE_OF_BASEBALL_NUMBER = 9;
    public static final int MIN_VALUE_OF_BASEBALL_NUMBER = 1;

    public String create() {
        List<Integer> numbers = new ArrayList<>();
        int currentNumberLength = 0;
        while (currentNumberLength < NUMBER_LENGTH_LIMIT) {
            int number = (int) (MIN_VALUE_OF_BASEBALL_NUMBER + Math.random() * MAX_VALUE_OF_BASEBALL_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
                currentNumberLength = currentNumberLength + 1;
            }
        }
        return numbers.stream()
            .map(number -> String.valueOf(number))
            .collect(Collectors.joining());
    }
}

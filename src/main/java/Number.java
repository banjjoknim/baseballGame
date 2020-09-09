import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Number {

    public String create() {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < 3) {
            int number = (int)(Math.random() * 9 + 1);
            if (!list.contains(number)) {
                list.add(number);
                i = i + 1;
            }
        }
        return list.stream().map(item -> String.valueOf(item)).collect(Collectors.joining());
    }
}

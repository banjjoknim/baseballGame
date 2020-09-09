import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void createTest() {
        Number number = new Number();
        List<Character> list = new ArrayList<>();
        for (char c : number.create().toCharArray()) {
            list.add(c);
        }
        Assertions.assertEquals(3, list.stream().distinct().count());
        Assertions.assertEquals(true, list.stream().noneMatch(item -> item <= 48 || item > 57));
    }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MinTest {

    @Test
    public void testMinWithStrings() {
        List<String> stringList = new ArrayList<>(Arrays.asList("d", "b", "c", "a"));
        String minString = Min.min(stringList);
        assertEquals("a", minString);
    }

    @Test
    public void testMinWithIntegers() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 7, 1, 3));
        Integer minInteger = Min.min(integerList);
        assertEquals(Integer.valueOf(1), minInteger);
    }

    @Test
    public void testMinWithDoubles() {
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.3, 1.1, 1.2, 1.6, 1.5));
        Double minDouble = Min.min(doubleList);
        assertEquals(Double.valueOf(1.1), minDouble, 0.0001);
    }
}
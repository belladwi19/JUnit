import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcTest {
    @Test
    public void testAdd() {
        int result = Calc.add(5, 3);
        assertEquals(8, result);
    }
}

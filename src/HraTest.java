import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HraTest {

    @Test
    public void testPrevedStringNaBoolean() {
        // Testování pro vstupní řetězec "1"
        assertTrue(Hra.prevedStringNaBoolean("1"), "Vstupní řetězec \"1\" by měl být převeden na true");

        // Testování pro vstupní řetězec jiný než "1"
        assertFalse(Hra.prevedStringNaBoolean("0"), "Vstupní řetězec jiný než \"1\" by měl být převeden na false");

        // Další možné testy, například pro prázdný řetězec, null atd.
    }
}
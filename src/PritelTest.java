import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PritelTest {

    @Test
    void testBojSNepritelemVictory() {

        Hrac hrac = new Hrac("s", "s", 1, 100);
        String input = "ano\nano\nano\nne\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        Pritel nepritel = new Pritel("Enemy", "A fierce opponent", false, true, 1, 30);
        boolean result = nepritel.bojSNepritelem(scanner, hrac);
        assertTrue(result, "Player should win the battle");
    }
}
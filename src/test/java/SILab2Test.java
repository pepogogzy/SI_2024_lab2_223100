import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryBranch() {
        RuntimeException exception1 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, 100);
        });
        assertEquals("allItems list can't be null!", exception1.getMessage());

        assertTrue(SILab2.checkCart(new ArrayList<>(), 100));

        List<Item> items3 = new ArrayList<>();

        items3.add(new Item(null, "12345", 100, 0));
        assertTrue(SILab2.checkCart(items3, 100));

        List<Item> items4 = new ArrayList<>();

        items4.add(new Item("", "12345", 100, 0));
        assertTrue(SILab2.checkCart(items4, 100));

        List<Item> items5 = new ArrayList<>();

        items5.add(new Item("Mleko", null, 200, 0));
        RuntimeException exception5 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items5, 200);
        });
        assertEquals("No barcode!", exception5.getMessage());

        List<Item> items6 = new ArrayList<>();

        items6.add(new Item("Mleko", "12c23", 100, 0));
        RuntimeException exception6 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items6, 100);
        });
        assertEquals("Invalid character in item barcode!", exception6.getMessage());

        List<Item> items7 = new ArrayList<>();

        items7.add(new Item("Mleko", "34344", 400, 0.1f));
        assertTrue(SILab2.checkCart(items7, 400));

        List<Item> items8 = new ArrayList<>();

        items8.add(new Item("Mleko", "77777", 100, 0));
        assertTrue(SILab2.checkCart(items8, 100));

        List<Item> items9 = new ArrayList<>();

        items9.add(new Item("Mleko", "099999", 303, 0.1f));
        assertTrue(SILab2.checkCart(items9, 100));

        List<Item> items10 = new ArrayList<>();

        items10.add(new Item("Mleko", "56783", 200, 0));
        items10.add(new Item("Leb", "89898", 200, 0));
        assertFalse(SILab2.checkCart(items10, 300));
    }

}
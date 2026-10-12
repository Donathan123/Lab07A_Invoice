import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest
{
    LineItem item;

    @BeforeEach
    void setUp()
    {
        item = new LineItem(new Product("Toaster", 29.95), 3);
    }

    @Test
    void getQuantity()
    {
        assertEquals(3, item.getQuantity());
    }

    @Test
    void getProduct()
    {
        assertEquals("Toaster", item.getProduct().getName());
    }

    @Test
    void getTotal()
    {
        assertEquals(89.85, item.getTotal(), 0.001);
    }

    @Test
    void totalChangesWithQuantity()
    {
        item.setQuantity(1);
        assertEquals(29.95, item.getTotal(), 0.001);
    }
}

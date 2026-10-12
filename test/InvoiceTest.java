import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest
{
    Invoice inv;

    @BeforeEach
    void setUp()
    {
        inv = new Invoice(new Address("Sam's Small Appliances", "100 Main Street", "Anytown", "CA", "98765"));
        inv.add(new Product("Toaster", 29.95), 3);
        inv.add(new Product("Hair Dryer", 24.95), 1);
        inv.add(new Product("Car Vacuum", 19.99), 2);
    }

    @Test
    void itemCount()
    {
        assertEquals(3, inv.getItems().size());
    }

    @Test
    void getAmountDue()
    {
        assertEquals(154.78, inv.getAmountDue(), 0.001);
    }

    @Test
    void emptyInvoiceIsZero()
    {
        inv.clearItems();
        assertEquals(0.0, inv.getAmountDue(), 0.001);
    }

    @Test
    void formatContainsAmountDue()
    {
        String text = inv.format();
        assertTrue(text.contains("AMOUNT DUE: $154.78"));
        assertTrue(text.contains("Sam's Small Appliances"));
        assertTrue(text.contains("Car Vacuum"));
    }
}

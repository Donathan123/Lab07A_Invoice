import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest
{
    Product p;

    @BeforeEach
    void setUp()
    {
        p = new Product("Toaster", 29.95);
    }

    @Test
    void getName()
    {
        assertEquals("Toaster", p.getName());
    }

    @Test
    void getUnitPrice()
    {
        assertEquals(29.95, p.getUnitPrice(), 0.001);
    }

    @Test
    void setUnitPrice()
    {
        p.setUnitPrice(19.99);
        assertEquals(19.99, p.getUnitPrice(), 0.001);
    }
}

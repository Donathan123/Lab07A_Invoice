import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest
{
    Address a;

    @BeforeEach
    void setUp()
    {
        a = new Address("Sam's Small Appliances", "100 Main Street", "Anytown", "CA", "98765");
    }

    @Test
    void getters()
    {
        assertEquals("Sam's Small Appliances", a.getName());
        assertEquals("100 Main Street", a.getStreet());
        assertEquals("Anytown", a.getCity());
        assertEquals("CA", a.getState());
        assertEquals("98765", a.getZip());
    }

    @Test
    void setName()
    {
        a.setName("Bob's Shop");
        assertEquals("Bob's Shop", a.getName());
    }

    @Test
    void format()
    {
        assertEquals("Sam's Small Appliances\n100 Main Street\nAnytown, CA 98765", a.format());
    }
}

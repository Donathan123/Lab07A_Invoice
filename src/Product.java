/**
 * Product describes something that can be sold: a name and a unit price.
 */
public class Product
{
    private String name;
    private double unitPrice;

    public Product(String name, double unitPrice)
    {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() { return name; }
    public double getUnitPrice() { return unitPrice; }

    public void setName(String name) { this.name = name; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString()
    {
        return String.format("%s ($%.2f)", name, unitPrice);
    }
}

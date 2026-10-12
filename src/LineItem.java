/**
 * LineItem is one row on the invoice: a Product and the quantity ordered.
 * The line total is the product's unit price multiplied by the quantity.
 */
public class LineItem
{
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setProduct(Product product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    /**
     * @return unit price * quantity
     */
    public double getTotal()
    {
        return product.getUnitPrice() * quantity;
    }

    /**
     * @return this line item formatted as one row of the invoice
     */
    public String format()
    {
        return String.format("%-20s %5d %10.2f %10.2f",
                product.getName(), quantity, product.getUnitPrice(), getTotal());
    }

    @Override
    public String toString()
    {
        return format();
    }
}

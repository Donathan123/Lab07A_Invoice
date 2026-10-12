import java.util.ArrayList;

/**
 * Invoice is a bill sent to a customer (billing Address) made up of
 * LineItems. The amount due is the sum of all the line item totals.
 */
public class Invoice
{
    private Address billingAddress;
    private ArrayList<LineItem> items;

    public Invoice(Address billingAddress)
    {
        this.billingAddress = billingAddress;
        this.items = new ArrayList<>();
    }

    public Address getBillingAddress() { return billingAddress; }
    public void setBillingAddress(Address billingAddress) { this.billingAddress = billingAddress; }

    public ArrayList<LineItem> getItems() { return items; }

    /**
     * Adds a product and the quantity being bought to this invoice.
     */
    public void add(Product product, int quantity)
    {
        items.add(new LineItem(product, quantity));
    }

    public void add(LineItem item)
    {
        items.add(item);
    }

    public void clearItems()
    {
        items.clear();
    }

    /**
     * @return the sum of the totals of all line items
     */
    public double getAmountDue()
    {
        double amountDue = 0;
        for (LineItem item : items)
        {
            amountDue += item.getTotal();
        }
        return amountDue;
    }

    /**
     * @return the whole invoice formatted as text, laid out like the sample invoice
     */
    public String format()
    {
        String bar = "=".repeat(49) + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append("                    I N V O I C E\n\n");
        sb.append(billingAddress.format()).append("\n\n");
        sb.append(bar);
        sb.append(String.format("%-20s %5s %10s %10s%n", "Item", "Qty", "Price", "Total"));
        for (LineItem item : items)
        {
            sb.append(item.format()).append("\n");
        }
        sb.append(bar);
        sb.append(String.format("AMOUNT DUE: $%.2f%n", getAmountDue()));
        return sb.toString();
    }

    @Override
    public String toString()
    {
        return format();
    }
}

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * InvoiceFrame is the Swing GUI. The user enters the customer's billing
 * address and then adds line items (product name, unit price, quantity).
 * The formatted invoice is shown in a JTextArea.
 */
public class InvoiceFrame extends JFrame
{
    private JTextField nameTF, streetTF, cityTF, stateTF, zipTF;
    private JTextField productTF, priceTF, qtyTF;
    private JTextArea displayTA;
    private Invoice invoice;

    public InvoiceFrame()
    {
        super("Lab 07A - Invoice");
        invoice = new Invoice(new Address("", "", "", "", ""));

        JPanel mainPnl = new JPanel(new BorderLayout(10, 10));
        mainPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPnl = new JPanel(new GridLayout(1, 2, 10, 0));
        inputPnl.add(createCustomerPanel());
        inputPnl.add(createLineItemPanel());

        mainPnl.add(inputPnl, BorderLayout.NORTH);
        mainPnl.add(createDisplayPanel(), BorderLayout.CENTER);
        mainPnl.add(createControlPanel(), BorderLayout.SOUTH);

        add(mainPnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 680);
        setLocationRelativeTo(null);
        refreshDisplay();
    }

    private JPanel createCustomerPanel()
    {
        JPanel pnl = new JPanel(new GridLayout(5, 2, 5, 5));
        pnl.setBorder(new TitledBorder("Bill To (Customer Address)"));
        nameTF = new JTextField();
        streetTF = new JTextField();
        cityTF = new JTextField();
        stateTF = new JTextField();
        zipTF = new JTextField();
        pnl.add(new JLabel("Name:"));   pnl.add(nameTF);
        pnl.add(new JLabel("Street:")); pnl.add(streetTF);
        pnl.add(new JLabel("City:"));   pnl.add(cityTF);
        pnl.add(new JLabel("State:"));  pnl.add(stateTF);
        pnl.add(new JLabel("Zip:"));    pnl.add(zipTF);
        return pnl;
    }

    private JPanel createLineItemPanel()
    {
        JPanel pnl = new JPanel(new GridLayout(5, 2, 5, 5));
        pnl.setBorder(new TitledBorder("Line Item"));
        productTF = new JTextField();
        priceTF = new JTextField();
        qtyTF = new JTextField();
        JButton addBtn = new JButton("Add Line Item");
        addBtn.addActionListener(e -> addLineItem());
        pnl.add(new JLabel("Product Name:")); pnl.add(productTF);
        pnl.add(new JLabel("Unit Price ($):")); pnl.add(priceTF);
        pnl.add(new JLabel("Quantity:"));      pnl.add(qtyTF);
        pnl.add(new JLabel(""));               pnl.add(addBtn);
        return pnl;
    }

    private JPanel createDisplayPanel()
    {
        JPanel pnl = new JPanel(new BorderLayout());
        pnl.setBorder(new TitledBorder("Invoice"));
        displayTA = new JTextArea();
        displayTA.setEditable(false);
        displayTA.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        pnl.add(new JScrollPane(displayTA), BorderLayout.CENTER);
        return pnl;
    }

    private JPanel createControlPanel()
    {
        JPanel pnl = new JPanel(new GridLayout(1, 3, 10, 0));
        JButton displayBtn = new JButton("Display Invoice");
        JButton clearBtn = new JButton("Clear");
        JButton quitBtn = new JButton("Quit");
        displayBtn.addActionListener(e -> {
            refreshDisplay();
            System.out.println(invoice.format());
        });
        clearBtn.addActionListener(e -> clearAll());
        quitBtn.addActionListener(e -> System.exit(0));
        pnl.add(displayBtn);
        pnl.add(clearBtn);
        pnl.add(quitBtn);
        return pnl;
    }

    private void addLineItem()
    {
        String name = productTF.getText().trim();
        if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter a product name.");
            return;
        }
        double price;
        int qty;
        try
        {
            price = Double.parseDouble(priceTF.getText().trim().replace("$", ""));
            qty = Integer.parseInt(qtyTF.getText().trim());
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Unit price must be a number and quantity must be a whole number.");
            return;
        }
        if (price < 0 || qty <= 0)
        {
            JOptionPane.showMessageDialog(this, "Price can't be negative and quantity must be at least 1.");
            return;
        }
        invoice.add(new Product(name, price), qty);
        productTF.setText("");
        priceTF.setText("");
        qtyTF.setText("");
        productTF.requestFocus();
        refreshDisplay();
    }

    /** Copies the address fields into the invoice and redraws the text area. */
    private void refreshDisplay()
    {
        invoice.setBillingAddress(new Address(nameTF.getText().trim(), streetTF.getText().trim(),
                cityTF.getText().trim(), stateTF.getText().trim(), zipTF.getText().trim()));
        displayTA.setText(invoice.format());
    }

    private void clearAll()
    {
        nameTF.setText(""); streetTF.setText(""); cityTF.setText("");
        stateTF.setText(""); zipTF.setText("");
        productTF.setText(""); priceTF.setText(""); qtyTF.setText("");
        invoice.clearItems();
        refreshDisplay();
    }
}

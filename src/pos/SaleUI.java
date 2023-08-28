package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class SaleUI extends JPanel {

    // Variables declaration 
    private String cus_id;
    private JLabel BalanceLabelField;
    private JLabel TotalBillLabelField;
    private JLabel BarcodeLabelField;
    private JComboBox<String> comboboxCus;
    private JComboBox<String> comboboxProduct;
    private JLabel InvoiceLabelField;
    private JButton AddButton;
    private JButton RemoveButton;
    private JButton RemoveAllButton;
    private JLabel CustomerLabel;
    private JLabel BalanceLabel;
    private JLabel InvoiceLabel;
    private JLabel ProductLabel;
    private JLabel UnitPriceLabel;
    private JLabel BarcodeLabel;
    private JLabel QtyLabel;
    private JLabel TotalPriceLabel;
    private JLabel TotalBillLabel;
    private JLabel PaidAmountLabel;
    private JLabel TotalQtyLabel;
    private JPanel TopPanel;
    private JPanel CenterPanel1;
    private JPanel CenterPanel2;
    private JPanel BottomPanel;
    private JPanel BottomPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private JTextField QtyField;
    private JTextField PaidAmountLabelField;
    private JButton PayButton;
    private JTable salesTable;
    private JLabel TotalPriceLabelField;
    private JLabel TotalQtyLabelField;
    private JLabel UnitPriceLabelField;
    // End of variables declaration

    public SaleUI() {
        initComponents();
        TableLoad();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        Dimension FieldSize = new Dimension(200, 40);
        Dimension buttonSize = new Dimension(120, 40);
        Font tableFont = new Font("Segoe UI", Font.PLAIN, 18);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 20);

        TopPanel = new JPanel();
        TopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sale Details"));
        TopPanel.setLayout(new java.awt.GridLayout(3, 4, 5, 0));

        CustomerLabel = new JLabel("Customer:");
        CustomerLabel.setFont(labelFont);
        TopPanel.add(CustomerLabel);

        comboboxCus = new JComboBox<>();
        comboboxCus.setFont(labelFont);
        comboboxCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxCusActionPerformed(evt);
            }
        });
        TopPanel.add(comboboxCus);

        ProductLabel = new JLabel("Product:");
        ProductLabel.setFont(labelFont);
        TopPanel.add(ProductLabel);

        comboboxProduct = new JComboBox<>();
        comboboxProduct.setFont(labelFont);
        comboboxProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxProductActionPerformed(evt);
            }
        });
        TopPanel.add(comboboxProduct);

        UnitPriceLabel = new JLabel("Unit Price:");
        UnitPriceLabel.setFont(labelFont);
        TopPanel.add(UnitPriceLabel);

        UnitPriceLabelField = new JLabel("0.00");
        UnitPriceLabelField.setFont(labelFont);
        TopPanel.add(UnitPriceLabelField);

        BarcodeLabel = new JLabel("Barcode:");
        BarcodeLabel.setFont(labelFont);
        TopPanel.add(BarcodeLabel);

        BarcodeLabelField = new JLabel("000000");
        BarcodeLabelField.setFont(labelFont);
        TopPanel.add(BarcodeLabelField);

        QtyLabel = new JLabel("Quantity:");
        QtyLabel.setFont(labelFont);
        TopPanel.add(QtyLabel);

        QtyField = new JTextField();
        QtyField.setFont(textFieldFont);
        QtyField.setPreferredSize(FieldSize);
        QtyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QtyFieldKeyReleased(evt);
            }
        });
        TopPanel.add(QtyField);

        // Content Center
        CenterPanel1 = new JPanel();
        CenterPanel1.setLayout(new BorderLayout());

        salesTable = new JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Invoice ID", "Product Name", "Barcode", "Quantity", "Unit Price", "Total Price"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        salesTable.getTableHeader().setPreferredSize(new Dimension(salesTable.getTableHeader().getWidth(), 40));

        // Set row height
        salesTable.setRowHeight(30);

        // Disable row reordering
        salesTable.getTableHeader().setReorderingAllowed(false);
        salesTable.setFont(tableFont);
        jScrollPane1.setViewportView(salesTable);
        CenterPanel1.add(jScrollPane1, BorderLayout.CENTER);

        CenterPanel2 = new JPanel();
        CenterPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        AddButton = new JButton("Add to Cart");
        AddButton.setPreferredSize(buttonSize);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        CenterPanel2.add(AddButton);

        RemoveButton = new JButton("Remove");
        RemoveButton.setPreferredSize(buttonSize);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });
        CenterPanel2.add(RemoveButton);

        RemoveAllButton = new JButton("Remove All");
        RemoveAllButton.setPreferredSize(buttonSize);
        RemoveAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveAllButtonActionPerformed(evt);
            }
        });
        CenterPanel2.add(RemoveAllButton);

        // Content Panel Bottom
        BottomPanel = new JPanel();
        BottomPanel.setLayout(new java.awt.GridLayout(2, 4, 5, 5));

        TotalPriceLabel = new JLabel("Total Price:");
        TotalPriceLabel.setFont(labelFont);
        BottomPanel.add(TotalPriceLabel);

        TotalPriceLabelField = new JLabel("0.00");
        TotalPriceLabelField.setFont(labelFont);
        BottomPanel.add(TotalPriceLabelField);

        TotalBillLabel = new JLabel("Total Bill:");
        TotalBillLabel.setFont(labelFont);
        BottomPanel.add(TotalBillLabel);

        TotalBillLabelField = new JLabel("0.00");
        TotalBillLabelField.setFont(labelFont);
        BottomPanel.add(TotalBillLabelField);

        TotalQtyLabel = new JLabel("Total Qty:");
        TotalQtyLabel.setFont(labelFont);
        BottomPanel.add(TotalQtyLabel);

        TotalQtyLabelField = new JLabel("0");
        TotalQtyLabelField.setFont(labelFont);
        BottomPanel.add(TotalQtyLabelField);

        PaidAmountLabel = new JLabel("Paid Amount:");
        PaidAmountLabel.setFont(labelFont);
        BottomPanel.add(PaidAmountLabel);

        PaidAmountLabelField = new JTextField("0");
        PaidAmountLabelField.setFont(textFieldFont);
        PaidAmountLabelField.setFont(labelFont);
        PaidAmountLabelField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PaidLabelFieldKeyReleased(evt);
            }
        });
        BottomPanel.add(PaidAmountLabelField);

        BalanceLabel = new JLabel("Balance:");
        BalanceLabel.setFont(labelFont);
        BottomPanel.add(BalanceLabel);

        BalanceLabelField = new JLabel("0.00");
        BalanceLabelField.setFont(labelFont);
        BottomPanel.add(BalanceLabelField);

        PayButton = new JButton("Pay");
        PayButton.setPreferredSize(buttonSize);
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });
        BottomPanel.add(PayButton);

        BottomPanelRight = new JPanel();
        BottomPanelRight.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        InvoiceLabel = new JLabel("Invoice ID:");
        InvoiceLabel.setFont(labelFont);
        BottomPanelRight.add(InvoiceLabel);

        InvoiceLabelField = new JLabel("000");
        InvoiceLabelField.setFont(labelFont);
        BottomPanelRight.add(InvoiceLabelField);

        BottomPanel.add(BottomPanelRight);

        add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel2, BorderLayout.EAST);
        add(CenterPanel1, BorderLayout.CENTER);
        add(BottomPanel, BorderLayout.SOUTH);

    }

    // Load the data of table
    public void TableLoad() {
        // Load customer names into the combo box
        try {
            ResultSet customerResultSet = DatabaseActions.executeQuery("SELECT * FROM customer");
            Vector<String> customerNames = new Vector<>();
            while (customerResultSet.next()) {
                customerNames.add(customerResultSet.getString("D_CusName"));
            }
            customerNames.insertElementAt("Selected Customer", 0);

            DefaultComboBoxModel<String> customerComboBoxModel = new DefaultComboBoxModel<>(customerNames);
            comboboxCus.setModel(customerComboBoxModel);
        } catch (SQLException e) {
            System.out.println(e);
        }

        // Load product names into the combo box
        try {
            ResultSet productResultSet = DatabaseActions.executeQuery("SELECT * FROM product");
            Vector<String> productNames = new Vector<>();
            while (productResultSet.next()) {
                productNames.add(productResultSet.getString("D_ProductName"));
            }
            productNames.insertElementAt("Selected Product", 0);
            DefaultComboBoxModel<String> productComboBoxModel = new DefaultComboBoxModel<>(productNames);
            comboboxProduct.setModel(productComboBoxModel);
        } catch (SQLException e) {
            System.out.println(e);
        }

        // Load last invoice number and update the next invoice number
        try {
            ResultSet extraResultSet = DatabaseActions.executeQuery("SELECT * FROM extra WHERE exid = 1");
            if (extraResultSet.next()) {
                InvoiceLabelField.setText(extraResultSet.getString("val"));
            }
            int i = Integer.valueOf(InvoiceLabelField.getText());
            i++;
            InvoiceLabelField.setText(String.valueOf(i));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Calculate the total price
    public void countTotalPrice() {
        String tblQtyText = QtyField.getText();
        String priceText = UnitPriceLabelField.getText();

        if (!tblQtyText.isEmpty() && !priceText.isEmpty()) {
            try {
                Double qt = Double.parseDouble(tblQtyText);
                Double price = Double.parseDouble(priceText);
                Double tot = qt * price;
                TotalPriceLabelField.setText(String.valueOf(tot));
            } catch (NumberFormatException e) {
                // Handle the exception, e.g., display an error message
                TotalPriceLabelField.setText("0.0");
            }
        } else {
            TotalPriceLabelField.setText(""); // Clear the total price if either tblQty or price is empty
        }
    }

    // Calculate the total bill and total qty
    public void countCartTotalPriceAndQty() {
        int numOfRow = salesTable.getRowCount();
        double total = 0;
        for (int i = 0; i < numOfRow; i++) {
            double value = Double.valueOf(salesTable.getValueAt(i, 5).toString());
            total += value;
        }
        TotalBillLabelField.setText(Double.toString(total));

        // Total quantity count
        int numOfRows = salesTable.getRowCount();
        int totals = 0;
        for (int i = 0; i < numOfRows; i++) {
            double value = Double.valueOf(salesTable.getValueAt(i, 3).toString());
            int intValue = (int) value;
            totals += intValue;
        }
        TotalQtyLabelField.setText(Integer.toString(totals));
    }

    // Calculate the balance
    public void countBalanceTotal() {
        try {
            Double paid = Double.parseDouble(PaidAmountLabelField.getText());
            Double tot = Double.parseDouble(TotalBillLabelField.getText());
            Double due = paid - tot;
            BalanceLabelField.setText(String.valueOf(due));
        } catch (NumberFormatException e) {
            // Handle the exception, e.g., display an error message
            BalanceLabelField.setText("Invalid Input");
        }
    }

    // Show and calculate the total price when qty field is input
    private void QtyFieldKeyReleased(java.awt.event.KeyEvent evt) {
        countTotalPrice();
    }

    // Load the data of customer from database to get cus_id
    private void comboboxCusActionPerformed(java.awt.event.ActionEvent evt) {
        String name = comboboxCus.getSelectedItem().toString();
        try {
            Statement s = DatabaseActions.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT cid, D_CusName FROM customer WHERE D_CusName ='" + name + "'");
            if (rs.next()) {
                cus_id = (rs.getString("cid"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Load the data of product from database to get unit price, barcode
    private void comboboxProductActionPerformed(java.awt.event.ActionEvent evt) {
        String name = comboboxProduct.getSelectedItem().toString();

        if (name.isEmpty()) {
            // Clear fields or display default values when no item is selected
            UnitPriceLabelField.setText("");
            BarcodeLabelField.setText("");
            TotalPriceLabelField.setText("");
        } else {
            try {
                Statement s = DatabaseActions.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT D_Barcode,D_ProductPrice FROM product  WHERE D_ProductName ='" + name + "'  ");
                if (rs.next()) {
                    UnitPriceLabelField.setText(rs.getString("D_ProductPrice"));
                    BarcodeLabelField.setText(rs.getString("D_Barcode"));
                    countTotalPrice();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    // Check the combobox is selected or not
    private boolean isValidInput() {
        if (comboboxCus.getSelectedIndex() == 0) {
            DatabaseActions.showError("Please select a customer.");
            return false;
        }
        if (comboboxProduct.getSelectedIndex() == 0) {
            DatabaseActions.showError("Please select a product.");
            return false;
        }

        if (QtyField.getText().isEmpty()) {
            DatabaseActions.showError("Please enter the quantity.");
            return false;
        }

        return true;
    }

    // Add item to table
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!isValidInput()) {
            return; // Exit if input is not valid
        }

        Vector<Object> rowData = new Vector<>();
        rowData.add(InvoiceLabelField.getText());
        rowData.add(comboboxProduct.getSelectedItem().toString());
        rowData.add(BarcodeLabelField.getText());
        rowData.add(Integer.parseInt(QtyField.getText())); // Convert to Integer
        rowData.add(Double.parseDouble(UnitPriceLabelField.getText())); // Convert to Double
        rowData.add(Double.parseDouble(TotalPriceLabelField.getText())); // Convert to Double

        DefaultTableModel dt = (DefaultTableModel) salesTable.getModel();
        dt.addRow(rowData);

        countCartTotalPriceAndQty();
        countBalanceTotal();
    }

    // Remove the selected row
    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            DefaultTableModel dt = (DefaultTableModel) salesTable.getModel();
            int row = salesTable.getSelectedRow();
            dt.removeRow(row);
        } catch (Exception e) {
            System.out.println(e);
        }
        countCartTotalPriceAndQty();
        countBalanceTotal();
    }

    // Remove all the row in the table
    private void RemoveAllButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel dt = (DefaultTableModel) salesTable.getModel();
        dt.setRowCount(0);
        countCartTotalPriceAndQty();
        countBalanceTotal();
    }

    // Calculate the paid total
    private void PaidLabelFieldKeyReleased(java.awt.event.KeyEvent evt) {
        countBalanceTotal();
    }

    // Reset the sale page
    private void resetUI() {
        // Clear the table
        DefaultTableModel dt = (DefaultTableModel) salesTable.getModel();
        dt.setRowCount(0);

        // Reset other UI components as needed
        comboboxCus.setSelectedIndex(0);
        comboboxProduct.setSelectedIndex(0);
        QtyField.setText("");
        PaidAmountLabelField.setText("0");

        // Reload data and update invoice number
        TableLoad();
    }

    // Make the transaction
    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel dt = (DefaultTableModel) salesTable.getModel();
        if (dt.getRowCount() == 0) {
            DatabaseActions.showError("The table is empty. Add items to the table before proceeding.");
            return;
        }

        int rowCount = dt.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String tblInvoiceID = dt.getValueAt(i, 0).toString();
            String tblProductName = dt.getValueAt(i, 1).toString();
            String tblBarcode = dt.getValueAt(i, 2).toString();
            String tblQty = dt.getValueAt(i, 3).toString();
            String tblUnitPrice = dt.getValueAt(i, 4).toString();
            String tblTotalPrice = dt.getValueAt(i, 5).toString();
            CartData cartData = new CartData(tblInvoiceID, tblProductName, tblBarcode, tblQty, tblUnitPrice, tblTotalPrice);
            SaleDatabase.addCartItem(cartData);
        }

        try {

            for (int i = 0; i < rowCount; i++) {
                String tblProductName = dt.getValueAt(i, 1).toString();
                String tblQty = dt.getValueAt(i, 3).toString();

                // Update product quantity in the Product database
                String updateQuery = "UPDATE product SET D_ProductQty = D_ProductQty - ? WHERE D_ProductName = ?";
                PreparedStatement updateStatement = DatabaseActions.mycon().prepareStatement(updateQuery);
                updateStatement.setInt(1, Integer.parseInt(tblQty));
                updateStatement.setString(2, tblProductName);
                updateStatement.executeUpdate();
            }

            String InvoiceID = InvoiceLabelField.getText();
            String cusName = comboboxCus.getSelectedItem().toString();
            String totalQty = TotalQtyLabelField.getText();
            String totalBill = TotalBillLabelField.getText();
            String Balance = BalanceLabelField.getText();
            Double tot = Double.valueOf(TotalBillLabelField.getText());
            Double pid = Double.valueOf(PaidAmountLabelField.getText());
            String Status = null;

            if (pid.equals(0.0)) {
                Status = "UnPaid";
            } else if (tot > pid) {
                Status = "Partial";
            } else if (tot <= pid) {
                Status = "Paid";
            }

            SaleData saleData = new SaleData("", InvoiceID, cus_id, cusName, totalQty, totalBill, Status, Balance);
            SaleDatabase.addSale(saleData);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }

        DatabaseActions.showSuccess("Transaction complete");
        resetUI();
        
        try {
            String id = InvoiceLabelField.getText();
            Statement s = DatabaseActions.mycon().createStatement();
            s.executeUpdate("UPDATE extra SET val='" + id + "' WHERE exid = 1");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    Call the main of SaleUI separately for testing
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Sale Management Application");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(new SaleUI());
//            frame.pack();
//            frame.setVisible(true);
//        });
//    }
}

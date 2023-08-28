package pos;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ProductUI extends JPanel {

    // Variables declaration 
    private JTextField SearchField;
    private JTextField ProductNameField;
    private JTextField ProductBarcodeField;
    private JTextField ProductPriceField;
    private JTextField ProductQtyField;
    private JTextField ProductIDField;
    private JTable productTable;

    public ProductUI() {
        initComponents();
        TableLoad();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        Dimension searchFieldSize = new Dimension(200, 40);
        Dimension buttonSize = new Dimension(120, 40); 

        Font tableFont = new Font("Segoe UI", Font.PLAIN, 18);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 20);

        // Create and configure UI components
        JPanel searchPanel = new JPanel(new FlowLayout());

        searchPanel.add(new JLabel("Search:"));
        SearchField = new JTextField(20);
        SearchField.setFont(textFieldFont);
        SearchField.setPreferredSize(searchFieldSize);
        SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                SearchProduct();
            }
        });
        searchPanel.add(SearchField);

        productTable = new JTable(new DefaultTableModel());
        productTable.getTableHeader().setPreferredSize(new Dimension(productTable.getTableHeader().getWidth(), 40));

        // Set row height
        productTable.setRowHeight(30);
        productTable.setFont(tableFont);

        // Disable row reordering and edit
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.setModel(new javax.swing.table.DefaultTableModel() {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        // Add listener for the productTable click event
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        JScrollPane jScrollPane1 = new JScrollPane(productTable);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton SaveButton = new JButton("Save");
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/save.png")));
        SaveButton.setPreferredSize(buttonSize);
        // Add listener for the Save button
        SaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveProduct();
            }
        });
        buttonPanel.add(SaveButton);

        JButton UpdateButton = new JButton("Update");
        UpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/update.png")));
        UpdateButton.setPreferredSize(buttonSize);
        // Add listener for the Update button
        UpdateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateProduct();
            }
        });
        buttonPanel.add(UpdateButton);

        JButton DeleteButton = new JButton("Delete");
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/remove.png")));
        DeleteButton.setPreferredSize(buttonSize);
        // Add listener for the Delete button
        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteProduct();
            }
        });
        buttonPanel.add(DeleteButton);

        // Create and configure panel for product details
        JPanel detailsPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Product Details"));

        // Create and add labels with custom font
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        detailsPanel.add(nameLabel);

        ProductNameField = new JTextField(10);
        ProductNameField.setFont(textFieldFont);
        detailsPanel.add(ProductNameField);

        JLabel bcodeLabel = new JLabel("Bar Code:");
        bcodeLabel.setFont(labelFont);
        detailsPanel.add(bcodeLabel);

        ProductBarcodeField = new JTextField(10);
        ProductBarcodeField.setFont(textFieldFont);
        detailsPanel.add(ProductBarcodeField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(labelFont);
        detailsPanel.add(priceLabel);

        ProductPriceField = new JTextField(10);
        ProductPriceField.setFont(textFieldFont);
        detailsPanel.add(ProductPriceField);

        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setFont(labelFont);
        detailsPanel.add(qtyLabel);
        ProductQtyField = new JTextField(10);
        ProductQtyField.setFont(textFieldFont);
        detailsPanel.add(ProductQtyField);

        ProductIDField = new JTextField();

        // Add searchAndDetailsPanel to the main panel
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(detailsPanel, BorderLayout.EAST);

    }

    // Use for refresh table and load table data
    private void TableLoad() {
        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        dtm.setColumnIdentifiers(new String[]{"ID", "Name", "Price", "Quantity", "Bar Code"});
        dtm.setRowCount(0);

        List<ProductData> productList = ProductDatabase.searchProducts("");
        for (ProductData product : productList) {
            dtm.addRow(new Object[]{product.getId(), product.getName(), product.getBarcode(), product.getPrice(), product.getQty()});
        }
    }

    // Search product
    private void SearchProduct() {
        String searchText = SearchField.getText().trim();
        List<ProductData> searchResults = ProductDatabase.searchProducts(searchText);

        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        dtm.setRowCount(0);

        for (ProductData product : searchResults) {
            dtm.addRow(new Object[]{product.getId(), product.getName(), product.getBarcode(), product.getPrice(), product.getQty()});
        }
    }

    // Select the product from the table and show to input field
    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {
        int r = productTable.getSelectedRow();
        String id = productTable.getValueAt(r, 0).toString();
        String name = productTable.getValueAt(r, 1).toString();
        String bcode = productTable.getValueAt(r, 2).toString();
        String price = productTable.getValueAt(r, 3).toString();
        String qty = productTable.getValueAt(r, 4).toString();

        ProductIDField.setText(id);
        ProductNameField.setText(name);
        ProductBarcodeField.setText(bcode);
        ProductPriceField.setText(price);
        ProductQtyField.setText(qty);
    }

    // Add new product
    private void saveProduct() {
        String name = ProductNameField.getText();
        String bcode = ProductBarcodeField.getText();
        String price = ProductPriceField.getText();
        String qty = ProductQtyField.getText();

        if (name.isEmpty()) {
            // Display an error message indicating that some fields are empty
            DatabaseActions.showError("Name fields is required.");
            return; // Exit the method since data is incomplete
        }

        ProductData productData = new ProductData("", name, bcode, price, qty);
        ProductDatabase.addProduct(productData);
        DatabaseActions.showSuccess("Product Add Success");
        TableLoad();
    }
    
    // Update product 
    private void updateProduct() {
        String id = ProductIDField.getText();
        String name = ProductNameField.getText();
        String bcode = ProductBarcodeField.getText();
        String price = ProductPriceField.getText();
        String qty = ProductQtyField.getText();

        ProductData productData = new ProductData(id, name, bcode, price, qty);
        ProductDatabase.updateProduct(productData);
        DatabaseActions.showSuccess("Product Update Success");

        TableLoad();
    }
    
    // Delete product by product id
    private void deleteProduct() {
        String id = ProductIDField.getText();
        if (id.isEmpty()) {
            DatabaseActions.showError("Please select a product to delete.");
            return; // Exit the method since data is incomplete
        }
        ProductDatabase.deleteProduct(id);
        DatabaseActions.showSuccess("Product Delete Success");

        TableLoad();
    }

//    Call the main of ProductUI separately for testing
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Product Management");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new ProductUI());
//        frame.pack();
//        frame.setVisible(true);
//    }
}

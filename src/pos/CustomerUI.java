package pos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class CustomerUI extends JPanel {

    // Variables declaration 
    private JTextField searchAllField;
    private JTable cusTable;
    private JTextField cusIdSearchField;
    private JTextField cusNameField;
    private JTextField cusPhoneField;
    private JTextField cusEmailField;
    private JTextField cusBillAddressField;
    private JTextField cusShipAddressField;
    private JTextField cusBankField;
    private JTextField cusCityField;

    public CustomerUI() {
        initComponents();
        TableLoad();
        setupTableClickListener();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        Dimension buttonSize = new Dimension(120, 40); 
        Dimension searchFieldSize = new Dimension(200, 40); 
        Font searchFieldFont = new Font("Arial", Font.PLAIN, 16); 
        Font tableFont = new Font("Segoe UI", Font.PLAIN, 18); 
        Font textFieldFont = new Font("Arial", Font.PLAIN, 20); 

        JPanel searchPanel = new JPanel(new FlowLayout());

        searchPanel.add(new JLabel("Search:"));
        searchAllField = new JTextField(20);
        searchAllField.setPreferredSize(searchFieldSize);
        searchAllField.setFont(searchFieldFont);
        // Create and initialize UI components
        searchAllField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchCustomers(searchAllField.getText());
            }
        });
        searchPanel.add(searchAllField);

        cusTable = new JTable(new DefaultTableModel());
        cusTable.setModel(new javax.swing.table.DefaultTableModel() {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        cusTable.getTableHeader().setPreferredSize(new Dimension(cusTable.getTableHeader().getWidth(), 40));

        // Set row height
        cusTable.setRowHeight(30);

        cusTable.setFont(tableFont);

        // Disable row reordering
        cusTable.getTableHeader().setReorderingAllowed(false);

        // Create and configure panels for buttons and search field
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Create and initialize buttons
        JButton saveButton = new JButton("Save");
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/save.png")));
        saveButton.setPreferredSize(buttonSize);
        // Add action listeners to buttons
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCustomer();
            }
        });
        buttonPanel.add(saveButton);

        JButton updateButton = new JButton("Update");
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/update.png")));
        updateButton.setPreferredSize(buttonSize);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCustomer();
            }
        });
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/remove.png")));
        deleteButton.setPreferredSize(buttonSize);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCustomer();
            }
        });
        buttonPanel.add(deleteButton);

        // Create and configure panel for customer details
        JPanel detailsPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
        Font labelFont = new Font("Arial", Font.BOLD, 18);

        cusIdSearchField = new JTextField(10);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        detailsPanel.add(nameLabel);

        cusNameField = new JTextField(10);
        cusNameField.setFont(textFieldFont);
        detailsPanel.add(cusNameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        detailsPanel.add(phoneLabel);

        cusPhoneField = new JTextField(10);
        cusPhoneField.setFont(textFieldFont);
        detailsPanel.add(cusPhoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        detailsPanel.add(emailLabel);

        cusEmailField = new JTextField(10);
        cusEmailField.setFont(textFieldFont);
        detailsPanel.add(cusEmailField);

        JLabel billAddressLabel = new JLabel("BillAddress:");
        billAddressLabel.setFont(labelFont);
        detailsPanel.add(billAddressLabel);

        cusBillAddressField = new JTextField(10);
        cusBillAddressField.setFont(textFieldFont);
        detailsPanel.add(cusBillAddressField);

        JLabel shipAddressLabel = new JLabel("ShipAddress:");
        shipAddressLabel.setFont(labelFont);
        detailsPanel.add(shipAddressLabel);

        cusShipAddressField = new JTextField(10);
        cusShipAddressField.setFont(textFieldFont);
        detailsPanel.add(cusShipAddressField);

        JLabel bankLabel = new JLabel("Bank:");
        bankLabel.setFont(labelFont);
        detailsPanel.add(bankLabel);

        cusBankField = new JTextField(10);
        cusBankField.setFont(textFieldFont);
        detailsPanel.add(cusBankField);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(labelFont);
        detailsPanel.add(cityLabel);

        cusCityField = new JTextField(10);
        cusCityField.setFont(textFieldFont);
        detailsPanel.add(cusCityField);

        // Add components to main panel
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(cusTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(detailsPanel, BorderLayout.EAST);
    }

    // Clear all the input field
    public void clearText() {
        cusNameField.setText("");
        cusPhoneField.setText("");
        cusEmailField.setText("");
        cusBillAddressField.setText("");
        cusShipAddressField.setText("");
        cusBankField.setText("");
        cusCityField.setText("");
    }

    // Use for refresh table and load table data
    private void TableLoad() {
        DefaultTableModel dtm = (DefaultTableModel) cusTable.getModel();
        dtm.setColumnIdentifiers(new String[]{"ID", "Name", "Phone", "Email", "Bill Address", "Ship Address", "Bank", "City"});
        dtm.setRowCount(0);

        Customer customer = new CustomerData("", "", "", "", "", "", "", "");

        // Load data from database and populate the table
        Vector<Vector<String>> data = customer.search("");  // Use the appropriate instance of CustomerData
        for (Vector<String> row : data) {
            dtm.addRow(row);
        }

    }

    // Search function
    private void searchCustomers(String searchText) {
        DefaultTableModel dtm = (DefaultTableModel) cusTable.getModel();
        dtm.setRowCount(0);

        Customer customer = new CustomerData("", "", "", "", "", "", "", "");

        Vector<Vector<String>> data = customer.search(searchText);  // Use the appropriate instance of CustomerData
        for (Vector<String> row : data) {
            dtm.addRow(row);
        }
    }

    // Add customer
    private void saveCustomer() {
        // Get input data from UI components
        String name = cusNameField.getText();
        String phone = cusPhoneField.getText();
        String email = cusEmailField.getText();
        String billAddress = cusBillAddressField.getText();
        String shipAddress = cusShipAddressField.getText();
        String bank = cusBankField.getText();
        String city = cusCityField.getText();

        if (name.isEmpty()) {
            // Display an error message indicating that some fields are empty
            DatabaseActions.showError("Name fields is required.");
            return; // Exit the method since data is incomplete
        }

        Customer customer = new CustomerData("", name, phone, email, billAddress, shipAddress, bank, city);
        customer.save();
        // Display a success message
        DatabaseActions.showSuccess("Customer data saved successfully.");
        // Refresh table
        TableLoad();
    }

    // Update customer
    private void updateCustomer() {
        // Get input data from UI components
        String id = cusIdSearchField.getText();
        String name = cusNameField.getText();
        String phone = cusPhoneField.getText();
        String email = cusEmailField.getText();
        String billAddress = cusBillAddressField.getText();
        String shipAddress = cusShipAddressField.getText();
        String bank = cusBankField.getText();
        String city = cusCityField.getText();

        if (name.isEmpty()) {
            // Display an error message indicating that some fields are empty
            DatabaseActions.showError("Name fields is required.");
            return; // Exit the method since data is incomplete
        }

        Customer customer = new CustomerData(id, name, phone, email, billAddress, shipAddress, bank, city);
        customer.update();

        DatabaseActions.showSuccess("Customer data updated successfully.");
        clearText();
        TableLoad();
    }

    // Delete customer
    private void deleteCustomer() {
        String id = cusIdSearchField.getText();
        try {
            if (id.isEmpty()) {
                DatabaseActions.showError("Please select a customer to delete.");
                return; // Exit the method since data is incomplete
            }
            Customer customer = new CustomerData(id, "", "", "", "", "", "", "");
            customer.delete();
            DatabaseActions.showSuccess("Customer deleted successfully.");
            clearText();
            TableLoad();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Get selected row data from table
    private void setupTableClickListener() {
        cusTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int r = cusTable.getSelectedRow();
                if (r >= 0) {
                    String id = cusTable.getValueAt(r, 0).toString();
                    String name = cusTable.getValueAt(r, 1).toString();
                    String phone = cusTable.getValueAt(r, 2).toString();
                    String email = cusTable.getValueAt(r, 3).toString();
                    String billAddress = cusTable.getValueAt(r, 4).toString();
                    String shipAddress = cusTable.getValueAt(r, 5).toString();
                    String bank = cusTable.getValueAt(r, 6).toString();
                    String city = cusTable.getValueAt(r, 7).toString();

                    cusIdSearchField.setText(id);
                    cusNameField.setText(name);
                    cusPhoneField.setText(phone);
                    cusEmailField.setText(email);
                    cusBillAddressField.setText(billAddress);
                    cusShipAddressField.setText(shipAddress);
                    cusBankField.setText(bank);
                    cusCityField.setText(city);
                }
            }
        });
    }

//    Call the main of CustomerUI separately for testing
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Customer Management Application");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(new CustomerUI());
//            frame.pack();
//            frame.setVisible(true);
//        });
//    }
}

package pos;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class InvoiceUI extends javax.swing.JPanel {

    // Variables declaration 
    private JComboBox<String> comboboxStatus;
    private JTextField cusName;
    private JTextField inid;
    private JTable invoiceTable;
    private JButton refreshButton;

    public InvoiceUI() {
        initComponents();
        TableLoad();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);
        Dimension testFieldDimension = new Dimension(15, 40);
        Dimension buttonSize = new Dimension(120, 40);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel inidLabel = new JLabel("INID:");
        inidLabel.setFont(textFieldFont);
        inid = new JTextField(15);
        inid.setPreferredSize(testFieldDimension);
        inid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inidKeyReleased(evt);
            }
        });
        JLabel cusNameLabel = new JLabel("Customer Name:");
        cusNameLabel.setFont(textFieldFont);
        cusName = new JTextField(15);
        cusName.setPreferredSize(testFieldDimension);
        cusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cus_nameKeyReleased(evt);
            }
        });

        JLabel statusLabel = new JLabel("Status:");
        comboboxStatus = new JComboBox<>();
        comboboxStatus.setPreferredSize(new Dimension(130, 40));
        comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"All", "UnPaid", "Partial", "Paid"}));
        comboboxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_statusActionPerformed(evt);
            }
        });

        topPanel.add(inidLabel);
        topPanel.add(inid);
        topPanel.add(cusNameLabel);
        topPanel.add(cusName);
        topPanel.add(statusLabel);
        topPanel.add(comboboxStatus);

        refreshButton = new JButton("Refresh");
        refreshButton.setPreferredSize(buttonSize);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        topPanel.add(refreshButton);

        invoiceTable = new JTable();
        invoiceTable.getTableHeader().setPreferredSize(new Dimension(invoiceTable.getTableHeader().getWidth(), 40));
        invoiceTable.setFont(new java.awt.Font("Segoe UI", 0, 18));
        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"SaleID", "INID", "CID", "Customer Name", "Total Qty", "Total Bill", "Status", "Balance"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        invoiceTable.setRowHeight(30);
        invoiceTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane1 = new JScrollPane(invoiceTable);

        add(topPanel, BorderLayout.NORTH);
        add(jScrollPane1, BorderLayout.CENTER);
    }

    // Use for refresh table and load table data
    public void TableLoad() {
        DefaultTableModel dt = (DefaultTableModel) invoiceTable.getModel();
        dt.setRowCount(0);

        Vector<Vector<String>> data = InvoiceDatabase.searchInvoices("", "", "All");
        for (Vector<String> row : data) {
            dt.addRow(row);
        }
    }

    // Search by invoice id
    private void inidKeyReleased(java.awt.event.KeyEvent evt) {
        searchParameters();
    }

    // Search by customer name
    private void cus_nameKeyReleased(java.awt.event.KeyEvent evt) {
        searchParameters();
    }

    // Search by Status
    private void com_statusActionPerformed(java.awt.event.ActionEvent evt) {
        searchParameters();
    }

    // Search function 
    private void searchParameters() {
        String inv_id = inid.getText();
        String c_Name = cusName.getText();
        String sta = comboboxStatus.getSelectedItem().toString();

        DefaultTableModel dt = (DefaultTableModel) invoiceTable.getModel();
        dt.setRowCount(0);

        Vector<Vector<String>> data = InvoiceDatabase.searchInvoices(inv_id, c_Name, sta);
        for (Vector<String> row : data) {
            dt.addRow(row);
        }
    }

    // Refresh the table
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TableLoad();
    }

//    Call the main of InvoiceUI separately for testing
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Invoice Management");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new InvoiceUI());
//        frame.pack();
//        frame.setVisible(true);
//    }
}

package pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InvoiceDatabase extends DatabaseActions {

    public static Vector<Vector<String>> searchInvoices(String inid, String customerName, String status) {
        Vector<Vector<String>> invoiceDataVector = new Vector<>();

        try {
            String query = "SELECT * FROM sales WHERE 1"; // Start with a true condition

            // Check if customerName filter is non-empty
            if (!customerName.isEmpty()) {
                query += " AND Customer_Name LIKE '%" + customerName + "%'";
            }

            // Check if status filter is not "All"
            if (!status.equals("All")) {
                query += " AND Status = '" + status + "'";
            }

            // Check if inid filter is non-empty
            if (!inid.isEmpty()) {
                query += " AND INID LIKE '%" + inid + "%'";
            }

            ResultSet resultSet = executeQuery(query);

            while (resultSet.next()) {
                Vector<String> rowData = new Vector<>();
                rowData.add(resultSet.getString(1));
                rowData.add(resultSet.getString(2));
                rowData.add(resultSet.getString(3));
                rowData.add(resultSet.getString(4));
                rowData.add(resultSet.getString(5));
                rowData.add(resultSet.getString(6));
                rowData.add(resultSet.getString(7));
                rowData.add(resultSet.getString(8));

                invoiceDataVector.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoiceDataVector;
    }
}

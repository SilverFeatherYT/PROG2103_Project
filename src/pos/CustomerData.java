package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

class CustomerData extends Customer {  

    public CustomerData(String id, String name, String phone, String email,
            String billAddress, String shipAddress, String bank, String city) {
        super(id, name, phone, email, billAddress, shipAddress, bank, city);
    }

    // Search customer
    @Override
    public Vector<Vector<String>> search(String searchText) {
        Vector<Vector<String>> results = new Vector<>();

        try {
            ResultSet resultSet = DatabaseActions.executeQuery(
                    "SELECT * FROM customer WHERE D_CusName LIKE '%" + searchText + "%' OR "
                    + "D_CusCity LIKE '%" + searchText + "%' OR D_CusPhone LIKE '%" + searchText
                    + "%' OR D_CusEmail LIKE '%" + searchText + "%' OR D_CusBillAddress  LIKE '%" + searchText
                    + "%' OR D_CusShipAddress  LIKE '%" + searchText + "%' OR D_CusBank  LIKE '%" + searchText + "%'");

            while (resultSet.next()) {
                Vector<String> rowData = new Vector<>();
                for (int i = 1; i <= 8; i++) {
                    rowData.add(resultSet.getString(i));
                }
                results.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    // Add customer to database
    @Override
    public void save() {
        try {
            // Implementation for saving customer data to the database
            Connection connection = DatabaseActions.mycon();

            String query = "INSERT INTO customer (D_CusName, D_CusPhone, D_CusEmail, D_CusBillAddress, D_CusShipAddress, D_CusBank, D_CusCity) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, getName());
            preparedStatement.setString(2, getPhone());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getBillAddress());
            preparedStatement.setString(5, getShipAddress());
            preparedStatement.setString(6, getBank());
            preparedStatement.setString(7, getCity());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Customer data saved: " + getName());

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error saving customer data: " + e.getMessage());
        }
    }

    // Update customer
    @Override
    public void update() {
        try {
            // Implementation for updating customer data in the database
            Connection connection = DatabaseActions.mycon();

            String query = "UPDATE customer SET D_CusName=?, D_CusPhone=?, D_CusEmail=?, D_CusBillAddress=?, D_CusShipAddress=?, D_CusBank=?, D_CusCity=? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, getName());
            preparedStatement.setString(2, getPhone());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getBillAddress());
            preparedStatement.setString(5, getShipAddress());
            preparedStatement.setString(6, getBank());
            preparedStatement.setString(7, getCity());
            preparedStatement.setString(8, getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Customer data updated: " + getName());

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error updating customer data: " + e.getMessage());
        }
    }

    // Delete customer
    @Override
    public void delete() {
        try {
            // Implementation for deleting customer data from the database
            Connection connection = DatabaseActions.mycon();

            String query = "DELETE FROM customer WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Customer data deleted: " + getName());

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error deleting customer data: " + e.getMessage());
        }
    }
}

//package pos;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Vector;
//import javax.swing.JOptionPane;
//
//public class CustomerDatabase extends DatabaseActions {
//
//    public static Vector<Vector<String>> searchCustomers(String searchText) {
//        Vector<Vector<String>> results = new Vector<>();
//
//        try {
//            ResultSet resultSet = executeQuery(
//                    "SELECT * FROM customer WHERE D_CusName LIKE '%" + searchText + "%' OR "
//                    + "D_CusCity LIKE '%" + searchText + "%' OR D_CusPhone LIKE '%" + searchText + "%'");
//
//            while (resultSet.next()) {
//                Vector<String> rowData = new Vector<>();
//                for (int i = 1; i <= 8; i++) {
//                    rowData.add(resultSet.getString(i));
//                }
//                results.add(rowData);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return results;
//    }
//
//    public static void saveCustomer(CustomerData data) {
//        String query = "INSERT INTO customer (D_CusName, D_CusPhone, D_CusEmail, D_CusBillAddress, D_CusShipAddress, D_CusBank, D_CusCity) "
//                + "VALUES ('" + data.getName() + "','" + data.getPhone() + "','" + data.getEmail() + "','" + data.getBillAddress() + "','"
//                + data.getShipAddress() + "','" + data.getBank() + "','" + data.getCity() + "')";
//        executeUpdate(query);
//    }
//
//    public static void updateCustomer(CustomerData data) {
//        String query = "UPDATE customer SET D_CusName='" + data.getName() + "', D_CusPhone='" + data.getPhone() + "', D_CusEmail='" + data.getEmail()
//                + "', D_CusBillAddress='" + data.getBillAddress() + "', D_CusShipAddress='" + data.getShipAddress() + "', D_CusBank='" + data.getBank()
//                + "', D_CusCity='" + data.getCity() + "' WHERE cid = '" + data.getId() + "'";
//        executeUpdate(query);
//    }
//
//    public static void deleteCustomer(String customerId) {
//        String query = "DELETE FROM customer WHERE cid = '" + customerId + "'";
//        executeUpdate(query);
//    }
//
//}

package pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends DatabaseActions {

    // Search function for product
    public static List<ProductData> searchProducts(String searchText) {
        List<ProductData> productList = new ArrayList<>();

        try {
            PreparedStatement statement = mycon().prepareStatement(
                    "SELECT * FROM product WHERE "
                    + "pid LIKE ? OR "
                    + "D_ProductName LIKE ? OR "
                    + "D_Barcode LIKE ? OR "
                    + "D_ProductPrice LIKE ? OR "
                    + "D_ProductQty LIKE ?"
            );
            String queryText = "%" + searchText + "%";
            statement.setString(1, queryText);
            statement.setString(2, queryText);
            statement.setString(3, queryText);
            statement.setString(4, queryText);
            statement.setString(5, queryText);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String barcode = resultSet.getString(3);
                String price = resultSet.getString(4); // Change this if necessary
                String qty = resultSet.getString(5); // Change this if necessary

                productList.add(new ProductData(id, name, barcode, price, qty));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    // Add product to database
    public static void addProduct(ProductData data) {
        String query = "INSERT INTO product (D_ProductName, D_Barcode, D_ProductPrice, D_ProductQty) VALUES ('" + data.getName() + "','" + data.getBarcode() + "','" + data.getPrice() + "','" + data.getQty() + "')";
        executeUpdate(query); // Call the inherited method
    }

    // Update product
    public static void updateProduct(ProductData data) {
        String query = "UPDATE product SET D_ProductName='" + data.getName() + "', D_Barcode='" + data.getBarcode() + "' , D_ProductPrice='" + data.getPrice() + "', D_ProductQty='" + data.getQty() + "' WHERE pid = '" + data.getId() + "'";
        System.out.println(query); // Just before executeUpdate(query);

        executeUpdate(query);
    }

    // Delete product
    public static void deleteProduct(String id) {
        String query = "DELETE FROM product WHERE pid = '" + id + "'";
        executeUpdate(query);
    }

}
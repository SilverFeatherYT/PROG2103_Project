package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseActions {

    // Connect to the database
    public static Connection mycon() {
        Connection con = null;
     
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/pos","root","");
            return con;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }   
    
    // Update the data to database
    public static void executeUpdate(String query) {
        try {
            Statement statement = mycon().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Executes the query using the established database connection
    protected static ResultSet executeQuery(String query) {
        try {
            Connection connection = mycon();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    public static void showError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showSuccess(String successMessage) {
        JOptionPane.showMessageDialog(null, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
}




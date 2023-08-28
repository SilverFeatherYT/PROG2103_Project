package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDatabase extends DatabaseActions {

    // Create the User table to the database if not exists
    public static void createTable() {
        Connection connection = mycon();
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "username VARCHAR(50) NOT NULL," +
                        "password VARCHAR(50) NOT NULL)";
                statement.executeUpdate(createTableSQL);
                System.out.println("User table created successfully.");
            } catch (SQLException e) {
                System.out.println("Error creating user table: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    // Register new user
    public void insertUser(String username, String password) {
        try (Connection connection = mycon()) {
            String insertSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                System.out.println("User inserted successfully.");
            } catch (SQLException e) {
                System.out.println("Error inserting user: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check if the username and password match in the database
    public boolean checkUserCredentials(String username, String password) {
        try (Connection connection = mycon()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            } catch (SQLException e) {
                System.out.println("Error checking user credentials: " + e.getMessage());
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Close the connection database
    public void closeConnection() {
        try {
            Connection connection = mycon();
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;

public class DatabaseConnection {
    private static final Logger logger = CurrencyConverterApp.getLogger();
    public Connection connectToDatabase() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/currency_converter";
            String user = "root";
            String password = "chinnu1975";

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            // Use the logger to log the exception
            logger.log(Level.SEVERE, "Database connection error", e);
        }
        return connection;
    }
}

import javax.swing.*;
import java.sql.*;
import java.util.logging.*;

public class ConvertCurrency {
    private static final Logger logger = CurrencyConverterApp.getLogger();
    public static void convertCurrency(JComboBox<String> fromCurrencyComboBox,
                                 JComboBox<String> toCurrencyComboBox,
                                 JComboBox<String> yearComboBox,
                                 JTextField amountTextField,
                                 JLabel resultLabel,
                                 JFrame frame) {

        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();

        double amount = Double.parseDouble(amountTextField.getText());

        double convertedAmount = performConversion(fromCurrency, toCurrency, year, amount);
        resultLabel.setText(String.format("%.2f %s", convertedAmount, toCurrency));
        frame.repaint();
    }
    private static double performConversion(String fromCurrency, String toCurrency, String year, double amount) {
        String url = "jdbc:mysql://localhost:3306/currency_converter";//name your database as currency_converter
        String user = "root";
        String password = "*******";//password of your server

        int intYear = Integer.parseInt(year);

        String sqlQuery = "SELECT rate " +
                "FROM exchange_rates " +
                "WHERE from_currency = ? AND to_currency = ? AND year = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {


            preparedStatement.setString(1, fromCurrency);
            preparedStatement.setString(2, toCurrency);
            preparedStatement.setInt(3, intYear);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    double exchangeRate = resultSet.getDouble("rate");
                    return amount * exchangeRate;
                } else {
                    logger.log(Level.INFO,"No exchange range is found for query "+sqlQuery);
                    return 0.0;
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Conversion cant be performed of query "+sqlQuery +"due to "+e.getMessage(),e);
            return 0.0;
        }
    }
}

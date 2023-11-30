import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class CurrencyConverterApp {
    private JFrame frame;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        Font customFont = new Font("Arial", Font.BOLD, 25);
        Font resultFont = new Font("Arial", Font.BOLD, 30);

        JLabel fromLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "AED", "INR", "JPY"}); 
        fromCurrencyComboBox.setSelectedItem("INR");
        fromCurrencyComboBox.setFont(customFont);
        fromLabel.setFont(customFont);

        JLabel toLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "AED", "INR", "JPY"}); 
        toCurrencyComboBox.setSelectedItem("USD");
        toCurrencyComboBox.setFont(customFont);
        toLabel.setFont(customFont);

        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();
        amountTextField.setFont(customFont);
        amountLabel.setFont(customFont);
        
        JLabel yearLabel = new JLabel("Year:");
        yearComboBox = new JComboBox<>(new String[]{"2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"}); 
        yearComboBox.setSelectedItem("2023");
        yearComboBox.setFont(customFont);
        yearLabel.setFont(customFont);

        JLabel emptyLabel = new JLabel();

        JButton convertButton = new JButton("Convert");
        convertButton.setFont(customFont);
        Color customForegroundColor = new Color(100, 150, 150); 
        convertButton.setForeground(customForegroundColor);
        Color customBackgroundColor = new Color(0, 100, 100); 
        convertButton.setBackground(customBackgroundColor);

        resultLabel = new JLabel();
        resultLabel.setFont(resultFont);
        

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        

        frame.add(fromLabel);
        frame.add(fromCurrencyComboBox);
        frame.add(toLabel);
        frame.add(toCurrencyComboBox);
        frame.add(yearLabel); 
        frame.add(yearComboBox);
        frame.add(amountLabel);
        frame.add(amountTextField);
        frame.add(emptyLabel);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);

        try {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    
    
    public Connection connectToDatabase() {
        Connection connection = null;
        try {
  
            String url = "jdbc:mysql://localhost:3306/currency_converter";
            String user = "root";
            String password = "chinnu1975";

            
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
        return connection;
    }
    
    
    private void convertCurrency() {
        
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        double amount = Double.parseDouble(amountTextField.getText());

       
        double convertedAmount = performConversion(fromCurrency, toCurrency, year, amount);

        
        resultLabel.setText(String.format("%.2f %s", convertedAmount, toCurrency));
        
        frame.repaint();
    }
    
    private double performConversion(String fromCurrency, String toCurrency, String year, double amount) {
        String url = "jdbc:mysql://localhost:3306/currency_converter";
        String user = "root";
        String password = "chinnu1975";

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
                    double convertedAmount = amount * exchangeRate;
                    return convertedAmount;
                } else {
                    System.out.println("No exchange rate found for the specified criteria.");
                    return 0.0; 
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0; 
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverterApp();
            }
        });
    }


}




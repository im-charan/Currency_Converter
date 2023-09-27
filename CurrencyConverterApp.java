import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CurrencyConverterApp {
    private JFrame frame;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    //private JComboBox<String> Year;
    private JTextField amountTextField;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel fromLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "DIR", "INR","YEN"}); // Add more currencies as needed
        fromCurrencyComboBox.setSelectedItem("INR");

        JLabel toLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "DIR", "INR","YEN"}); // Add more currencies as needed
        toCurrencyComboBox.setSelectedItem("USD");

        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();

        JLabel emptyLabel = new JLabel(); // Placeholder for alignment

        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

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
        frame.add(amountLabel);
        frame.add(amountTextField);
        frame.add(emptyLabel);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void convertCurrency() {
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
            resultLabel.setText(String.format("%.2f %s", convertedAmount, toCurrency));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    // Replace this with actual currency conversion logic
    private double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        // Add your currency conversion logic here
        // You might fetch exchange rates from an API or use predefined rates
        // For simplicity, we'll use a predefined rate for USD to EUR conversion
        double usdToEurRate = 0.85;
        if ("USD".equals(fromCurrency) && "EUR".equals(toCurrency)) {
            return amount * usdToEurRate;
        } else {
            return amount;
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
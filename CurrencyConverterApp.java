import javax.swing.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CurrencyConverterApp {
    private final JFrame frame;
    private final JComboBox<String> fromCurrencyComboBox;
    private final JComboBox<String> toCurrencyComboBox;
    private final JComboBox<String> yearComboBox;
    private final JTextField amountTextField;
    private final JLabel resultLabel;

    public static final Logger logger = Logger.getLogger(CurrencyConverterApp.class.getName());

    public static Logger getLogger(){
        return logger;
    }


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
                ConvertCurrency.convertCurrency(
                        fromCurrencyComboBox,
                        toCurrencyComboBox,
                        yearComboBox,
                        amountTextField,
                        resultLabel,
                        frame);
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
            logger.log(Level.SEVERE,"Nimbus Look and Feel is not set "+ e.getMessage(),e);
        }
    }
}




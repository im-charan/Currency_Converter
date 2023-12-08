# Currency Converter App
***Currency Converter App is a Java Application which is used to convert currency values of past 10 years based on exchange rates.***
## Features
**-> User-Friendly Interface** : The app offers a simple and efficient GUI(Graphical User Interface) which is built using JAVA Swing library. The interface offers users to input Source Currency, Target Currency, Amount and Year of conversion.

**-> Exchange Rates Database** : Exchange rates of the currencies is stored in MySQL database table which make the conversions much efficient.

**-> Historic Conversions** : Users can choose from a selection of currencies and years, providing flexibility in performing historical currency conversions.
## Getting Started
To run the Currency Conversion App locally,follow these steps:
1. Clone the Repository to your Machine.
2. Create a Project folder and store all the Java Source Files in the Project folder.
3. Create a MySQL Database.
4. Run [schema.sql](https://github.com/im-charan/Currency_Converter/blob/main/schema.sql) to create a table named exchange_rates and run [data.sql](https://github.com/im-charan/Currency_Converter/blob/main/data.sql) to insert data into the table.
5. Update your MySQL username and password in [ConvertCurrency.java](https://github.com/im-charan/Currency_Converter/blob/main/ConvertCurrency.java) and [DatabaseConnection.java](https://github.com/im-charan/Currency_Converter/blob/main/DatabaseConnection.java).
6. Add [mysql-connector-j-8.1.0.jar](https://github.com/im-charan/Currency_Converter/blob/main/mysql-connector-j-8.1.0.jar) to your IDE's Dependency.
7. Now Compile and run [Main.java](https://github.com/im-charan/Currency_Converter/blob/main/Main.java) in IDE.

## How To?
1. Once you run [Main.java](https://github.com/im-charan/Currency_Converter/blob/main/Main.java), The application interface will appear.
2. Choose the intital Currency i.e the currency you want to convert from.
3. Choose the target Currency i.e the currency you want to conver to.
4. Choose the year on which you want to perform conversion.
5. Insert the amount in the Textfield and click Convert.
6. Now you can find the Result in the bottom left of the interface.
<img src = "https://github.com/im-charan/Currency_Converter/assets/120516633/1f97a892-e03e-405c-9786-dd78eb2e3f34" width=50% height=50%><img src = "https://github.com/im-charan/Currency_Converter/assets/120516633/1c641d05-82d4-4970-918d-7c02021c0ae2" width=50% height=50%>


## Dependency
1. [mysql-connector-j-8.1.0.jar](https://github.com/im-charan/Currency_Converter/blob/main/mysql-connector-j-8.1.0.jar) - MySQL JDBC used to connect the source code and Database.

## Contributions
Feel free to contribute to the development of this project. If you encounter any issues or have suggestions, please create an issue or submit a pull request.
### Connect with me at 
<div id="badges">
  <a href="https://www.linkedin.com/in/charanb5/">
    <img src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/>
  </a>
</div>
<img src="https://komarev.com/ghpvc/?username=im-charan&style=flat-square&color=blue" alt=""/>

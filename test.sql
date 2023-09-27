show databases;
use currency_tracker;
SHOW TABLES;
DROP TABLE currency_history;
CREATE TABLE currency_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    year INT,
    INR DECIMAL(10, 2),
    USD DECIMAL(10,2)
);


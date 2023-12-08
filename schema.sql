CREATE TABLE exchange_rates (
    id INT PRIMARY KEY AUTO_INCREMENT,
    from_currency VARCHAR(3),
    to_currency VARCHAR(3),
    rate DOUBLE,
    year INT
);

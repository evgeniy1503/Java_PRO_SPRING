CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    user_id INTEGER,
    account_number VARCHAR(255),
    amount NUMERIC,
    product_type VARCHAR(64)
);

INSERT INTO products (user_id, account_number, amount, product_type)  VALUES
    (1, 67891, 1000, 'CARD'),
    (1, 67889, 5000, 'CARD'),
    (1, 67888, 15000, 'CARD')

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    user_id INTEGER,
    account_number VARCHAR(255),
    amount NUMERIC,
    product_type VARCHAR(64)
);
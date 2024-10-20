CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100)
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10, 2),
    quantity INT,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
-- Insert data
INSERT INTO categories (category_name) VALUES ('Electronics');

INSERT INTO products (product_name, price, quantity, category_id) 
VALUES ('Smartphone', 499.99, 50, 1);

-- Filter products by category
SELECT * FROM products WHERE category_id = 1;

-- Update product stock
UPDATE products 
SET quantity = quantity - 1 
WHERE product_id = 1;

-- Generate product report
SELECT product_name, price, quantity 
FROM products 
WHERE quantity > 0 
ORDER BY price DESC;

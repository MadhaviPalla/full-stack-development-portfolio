CREATE TABLE suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(100),
    contact_info VARCHAR(100)
);

CREATE TABLE inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    quantity INT,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);
-- Insert supplier and inventory data
INSERT INTO suppliers (supplier_name, contact_info) VALUES ('ABC Supplies', '123-456-7890');

INSERT INTO inventory (product_name, quantity, supplier_id) 
VALUES ('Laptop', 100, 1);

-- Inventory status report
SELECT product_name, quantity 
FROM inventory 
WHERE quantity <= 10;

-- Supplier details for low stock items
SELECT s.supplier_name, i.product_name 
FROM suppliers s
JOIN inventory i ON s.supplier_id = i.supplier_id
WHERE i.quantity <= 10;


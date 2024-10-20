-- Table Creation Statements
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    position VARCHAR(50),
    salary DECIMAL(10, 2),
    hire_date DATE
);

CREATE TABLE performance_reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    review_date DATE,
    performance_score INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

-- Data Insertion
INSERT INTO employees (name, position, salary, hire_date) 
VALUES ('John Doe', 'Software Engineer', 75000, '2020-01-15');

-- Sample Queries
-- Read data
SELECT * FROM employees;

-- Update data
UPDATE employees 
SET salary = 80000 
WHERE employee_id = 1;

-- Delete data
DELETE FROM employees 
WHERE employee_id = 2;

-- Join query
SELECT e.name, p.performance_score 
FROM employees e
JOIN performance_reviews p ON e.employee_id = p.employee_id;

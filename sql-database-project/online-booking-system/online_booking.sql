CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    service VARCHAR(100),
    booking_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
-- Insert booking
INSERT INTO users (username, email) VALUES ('john_doe', 'john@example.com');

INSERT INTO bookings (user_id, service, booking_date, status) 
VALUES (1, 'Hotel Reservation', '2024-10-12', 'Confirmed');

-- View user booking history
SELECT u.username, b.service, b.booking_date, b.status 
FROM users u
JOIN bookings b ON u.user_id = b.user_id
WHERE u.user_id = 1;

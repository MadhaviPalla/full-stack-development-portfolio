# Online Booking System

## Description
This project implements an online booking system using MySQL. It manages user bookings for services such as hotels or events. The project demonstrates SQL JOINs, constraints, and transaction management.

## Database Structure
- **users**: Stores user details (ID, username, email).
- **bookings**: Tracks service bookings for users.

## Key Features
- Create and manage user bookings.
- Track booking statuses (confirmed, canceled, etc.).
- Generate booking history for each user.

## How to Run
1. Set up a MySQL database.
2. Run the `online_booking.sql` script to create the tables and insert sample data.
   ```sql
   source /path/to/online_booking.sql;

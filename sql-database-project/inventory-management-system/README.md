# Inventory Management System

## Description
This project implements an inventory management system using MySQL. It tracks inventory levels, orders, and suppliers for a business. The project demonstrates SQL triggers, subqueries, and optimization techniques.

## Database Structure
- **suppliers**: Stores supplier details (ID, name, contact information).
- **inventory**: Tracks inventory levels for each product and supplier.

## Key Features
- Manage product stock levels and supplier details.
- Generate reports for low-stock items.
- Link inventory data to suppliers.

## How to Run
1. Set up a MySQL database.
2. Run the `inventory_management.sql` script to create the tables and insert sample data.
   ```sql
   source /path/to/inventory_management.sql;

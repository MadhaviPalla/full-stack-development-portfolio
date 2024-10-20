# Student Grading System

## Description
This project implements a grading system for students using MySQL. It stores student data, course enrollments, and grades. The project demonstrates SQL aggregation, GROUP BY, and GPA calculation.

## Database Structure
- **students**: Stores student details (ID, name, enrollment date).
- **courses**: Stores course details.
- **grades**: Stores grade data for each student and course.

## Key Features
- Track student enrollments and grades.
- Calculate GPA for each student.
- Aggregate student data using SQL GROUP BY.

## How to Run
1. Set up a MySQL database.
2. Run the `student_grading.sql` script to create the tables and insert sample data.
   ```sql
   source /path/to/student_grading.sql;

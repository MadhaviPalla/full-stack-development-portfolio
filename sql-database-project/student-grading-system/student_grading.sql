CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    enrollment_date DATE
);

CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100),
    credit_hours INT
);

CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade DECIMAL(3, 2),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
-- Insert student and course data
INSERT INTO students (name, enrollment_date) VALUES ('Alice', '2021-09-01');

INSERT INTO courses (course_name, credit_hours) VALUES ('Mathematics', 4);

INSERT INTO grades (student_id, course_id, grade) 
VALUES (1, 1, 3.7);

-- Calculate GPA for a student
SELECT s.name, AVG(g.grade) AS gpa 
FROM students s
JOIN grades g ON s.student_id = g.student_id
GROUP BY s.student_id
HAVING gpa >= 3.0;

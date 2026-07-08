mysql> CREATE DATABASE scms_db;
Query OK, 1 row affected (0.07 sec)

mysql> use scms_db;
Database changed
mysql> CREATE TABLE roles(
    ->
    ->     role_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     role_name VARCHAR(30) NOT NULL UNIQUE
    ->
    -> );
Query OK, 0 rows affected (0.16 sec)

mysql> CREATE TABLE users(
    ->
    ->     user_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     username VARCHAR(50) NOT NULL UNIQUE,
    ->
    ->     password VARCHAR(255) NOT NULL,
    ->
    ->     email VARCHAR(100) NOT NULL UNIQUE,
    ->
    ->     role_id INT NOT NULL,
    ->
    ->     is_active BOOLEAN DEFAULT TRUE,
    ->
    ->     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ->
    ->     FOREIGN KEY(role_id)
    ->     REFERENCES roles(role_id)
    ->
    -> );
Query OK, 0 rows affected (0.10 sec)

mysql> CREATE TABLE departments(
    ->
    ->     department_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     department_name VARCHAR(100) NOT NULL,
    ->
    ->     department_code VARCHAR(10) NOT NULL UNIQUE
    ->
    -> );
Query OK, 0 rows affected (0.06 sec)

mysql> CREATE TABLE courses(
    ->
    ->     course_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     course_name VARCHAR(100) NOT NULL,
    ->
    ->     duration INT NOT NULL,
    ->
    ->     department_id INT,
    ->
    ->     FOREIGN KEY(department_id)
    ->
    ->     REFERENCES departments(department_id)
    ->
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> CREATE TABLE faculty(
    ->
    ->     faculty_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     user_id INT UNIQUE,
    ->
    ->     department_id INT,
    ->
    ->     faculty_name VARCHAR(100),
    ->
    ->     designation VARCHAR(100),
    ->
    ->     phone VARCHAR(15),
    ->
    ->     FOREIGN KEY(user_id)
    ->     REFERENCES users(user_id),
    ->
    ->     FOREIGN KEY(department_id)
    ->     REFERENCES departments(department_id)
    ->
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> CREATE TABLE students(
    ->
    ->     student_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     user_id INT UNIQUE,
    ->
    ->     department_id INT,
    ->
    ->     course_id INT,
    ->
    ->     roll_number VARCHAR(20) UNIQUE,
    ->
    ->     student_name VARCHAR(100),
    ->
    ->     gender VARCHAR(10),
    ->
    ->     dob DATE,
    ->
    ->     phone VARCHAR(15),
    ->
    ->     address VARCHAR(255),
    ->
    ->     admission_year INT,
    ->
    ->     FOREIGN KEY(user_id)
    ->     REFERENCES users(user_id),
    ->
    ->     FOREIGN KEY(department_id)
    ->     REFERENCES departments(department_id),
    ->
    ->     FOREIGN KEY(course_id)
    ->     REFERENCES courses(course_id)
    ->
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> CREATE TABLE subjects(
    ->
    ->     subject_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     subject_name VARCHAR(100),
    ->
    ->     subject_code VARCHAR(20) UNIQUE,
    ->
    ->     faculty_id INT,
    ->
    ->     course_id INT,
    ->
    ->     semester INT,
    ->
    ->     credits INT,
    ->
    ->     FOREIGN KEY(faculty_id)
    ->     REFERENCES faculty(faculty_id),
    ->
    ->     FOREIGN KEY(course_id)
    ->     REFERENCES courses(course_id)
    ->
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> CREATE TABLE enrollment(
    ->
    ->     enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     student_id INT,
    ->
    ->     subject_id INT,
    ->
    ->     semester INT,
    ->
    ->     academic_year VARCHAR(20),
    ->
    ->     FOREIGN KEY(student_id)
    ->     REFERENCES students(student_id),
    ->
    ->     FOREIGN KEY(subject_id)
    ->     REFERENCES subjects(subject_id)
    ->
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> CREATE TABLE attendance(
    ->
    ->     attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     student_id INT,
    ->
    ->     subject_id INT,
    ->
    ->     faculty_id INT,
    ->
    ->     attendance_date DATE,
    ->
    ->     status ENUM('Present','Absent','Late'),
    ->
    ->     FOREIGN KEY(student_id)
    ->     REFERENCES students(student_id),
    ->
    ->     FOREIGN KEY(subject_id)
    ->     REFERENCES subjects(subject_id),
    ->
    ->     FOREIGN KEY(faculty_id)
    ->     REFERENCES faculty(faculty_id)
    ->
    -> );
Query OK, 0 rows affected (0.10 sec)

mysql> CREATE TABLE marks(
    ->
    ->     mark_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     student_id INT,
    ->
    ->     subject_id INT,
    ->
    ->     internal_marks DECIMAL(5,2),
    ->
    ->     external_marks DECIMAL(5,2),
    ->
    ->     total DECIMAL(5,2),
    ->
    ->     grade CHAR(2),
    ->
    ->     FOREIGN KEY(student_id)
    ->     REFERENCES students(student_id),
    ->
    ->     FOREIGN KEY(subject_id)
    ->     REFERENCES subjects(subject_id)
    ->
    -> );
Query OK, 0 rows affected (0.09 sec)

mysql> CREATE TABLE announcements(
    ->
    ->     announcement_id INT PRIMARY KEY AUTO_INCREMENT,
    ->
    ->     faculty_id INT,
    ->
    ->     title VARCHAR(150),
    ->
    ->     description TEXT,
    ->
    ->     posted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ->
    ->     FOREIGN KEY(faculty_id)
    ->     REFERENCES faculty(faculty_id)
    ->
    -> );
Query OK, 0 rows affected (0.07 sec)

mysql> SHOW TABLES;
+-------------------+
| Tables_in_scms_db |
+-------------------+
| announcements     |
| attendance        |
| courses           |
| departments       |
| enrollment        |
| faculty           |
| marks             |
| roles             |
| students          |
| subjects          |
| users             |
+-------------------+
11 rows in set (0.03 sec)

mysql> DESC students;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| student_id     | int          | NO   | PRI | NULL    | auto_increment |
| user_id        | int          | YES  | UNI | NULL    |                |
| department_id  | int          | YES  | MUL | NULL    |                |
| course_id      | int          | YES  | MUL | NULL    |                |
| roll_number    | varchar(20)  | YES  | UNI | NULL    |                |
| student_name   | varchar(100) | YES  |     | NULL    |                |
| gender         | varchar(10)  | YES  |     | NULL    |                |
| dob            | date         | YES  |     | NULL    |                |
| phone          | varchar(15)  | YES  |     | NULL    |                |
| address        | varchar(255) | YES  |     | NULL    |                |
| admission_year | int          | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
11 rows in set (0.01 sec)
mysql> INSERT INTO roles(role_name)
    -> VALUES
    -> ('ADMIN'),
    -> ('FACULTY'),
    -> ('STUDENT');
Query OK, 3 rows affected (0.02 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO departments(department_name, department_code)
    -> VALUES
    -> ('Computer Science','CSE'),
    -> ('Electronics','ECE'),
    -> ('Mechanical','ME');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO courses(course_name,duration,department_id)
    -> VALUES
    -> ('B.Tech',4,1),
    -> ('M.Tech',2,1);
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0
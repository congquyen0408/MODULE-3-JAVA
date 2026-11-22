CREATE DATABASE student_mng;
USE student_mng;

CREATE TABLE Students ( student_id INT primary key auto_increment,
full_name VARCHAR(100) not null,
date_of_birth date not null,
email VARCHAR(100) not null unique);

DELIMITER //
CREATE PROCEDURE get_all_students()
BEGIN
SELECT * FROM Students;
END //
DELIMITER ;
CALL get_all_students;

DELIMITER //
CREATE PROCEDURE add_student(
IN in_full_name VARCHAR(100),
IN in_date_of_birth DATE,
IN in_email VARCHAR(100))

BEGIN
INSERT INTO Students (full_name,date_of_birth,email) 
VALUES (in_full_name,in_date_of_birth,in_email);
END //
DELIMITER ;
CALL add_student("LCCQ","1994-08-04","congquyen@gmail.com");

DELIMITER //
CREATE PROCEDURE update_student(
IN in_id INT,
IN in_full_name VARCHAR(100),
IN in_date_of_birth DATE,
IN in_email VARCHAR(100))

BEGIN
UPDATE Students
SET full_name = in_full_name,
	date_of_birth = in_date_of_birth,
    email = in_email
    WHERE student_id = in_id;
END //
DELIMITER ;
CALL update_student(1,"LCCQ1","1994-08-05","congquyen0405@gmail.com");

DELIMITER //
CREATE PROCEDURE find_student_by_id(
IN in_id INT)
BEGIN
SELECT * FROM Students
WHERE student_id = in_id;
END //
DELIMITER ;
CALL find_student_by_id(1);

DELIMITER //
CREATE PROCEDURE delete_student(
IN in_id INT)
BEGIN
DELETE FROM Students
WHERE student_id = in_id;
END //
DELIMITER ;
CALL delete_student(1);
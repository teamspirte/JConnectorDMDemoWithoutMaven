-- Create the database in mysql db
create database DMJConnector;
use DMJConnector;

-- create the table students
CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  course VARCHAR(50)
);

-- insert the data into students table
INSERT INTO students (name, course) VALUES ('John Doe','Math'), ('Jane Smith','Physics');

-- cross check the data inserted or not
select * from students;

Run the main file to check pre-defined mysql-connector-j-9.3.0.jar dependent jar is working or not
-- MyJDBCExample

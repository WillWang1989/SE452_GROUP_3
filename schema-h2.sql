DROP TABLE IF EXISTS course_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS aisle;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS admin;

CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

CREATE TABLE students (
  id INT AUTO_INCREMENT,
    stu_id VARCHAR(10),
    nm VARCHAR(50),
    email VARCHAR(50),
    admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);

CREATE TABLE course (
  id INT AUTO_INCREMENT,
    dept char(2),
    num int,
    PRIMARY KEY (ID)
);

CREATE TABLE course_students (
  id INT AUTO_INCREMENT,
  course_id long,
    students_id long,
    primary key(id)
);

CREATE TABLE payment (
  id INT,
    payment_type VARCHAR(50),
    amount FLOAT,
    card_num int,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cust_name VARCHAR(75),
    cust_id long,
    PRIMARY KEY (ID)
);

CREATE TABLE store (
  id INT,
    store_name VARCHAR(30),
    street_address VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(10),
    zip int,
    PRIMARY KEY (ID)
);

-- CREATE TABLE aisle (
--   id INT,
--     num int,
--     dept_id int,
--     PRIMARY KEY (ID)
-- );

CREATE TABLE department(
    id INT
);
CREATE TABLE product (
  id INT AUTO_INCREMENT,
    product_brand long,
    product_name long,
    product_description long,
    dept long,
    price float
);
CREATE TABLE admin (
  id INT AUTO_INCREMENT,
    username long,
    name long
);
DROP TABLE IF EXISTS course_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS custormer;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_products;
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

CREATE TABLE students (
  id serial  PRIMARY KEY,
  stu_id VARCHAR(10),
  nm VARCHAR(50),
  email VARCHAR(50),
  admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE course (
    id serial  PRIMARY KEY,
    dept char(2),
    num int
);

CREATE TABLE course_students (
     id serial  PRIMARY KEY,
     course_id int,
     students_id int
);



CREATE TABLE custormer (
    id serial  PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password varchar(80)  NOT NULL ,
    email VARCHAR(50),
    tel_no VARCHAR(25),
    address1 varchar(500),
    address2 varchar(100)
);

CREATE TABLE orders(
    id serial  PRIMARY KEY,
    order_id serial,
    customer_id serial NOT NULL,
    orderDate DATE,
    orderStatus INTEGER ,
    paymentId serial,
    deliverId serial,
    totalCost money
);

CREATE  TABLE  order_products (
    id serial  PRIMARY KEY,
    orderId serial,
    productId serial,
    count INTEGER
)
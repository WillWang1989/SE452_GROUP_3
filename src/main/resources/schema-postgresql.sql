
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_products;
DROP TABLE IF EXISTS cart_products;
DROP TABLE IF EXISTS shopping_cart;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS  product;
DROP TABLE IF EXISTS runner;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS account_profiles;
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;


CREATE TABLE customer (
    id serial  PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password varchar(80)  NOT NULL ,
    firstname varchar(50),
    middlename varchar(50),
    lastname varchar(50),
    dob DATE,
    email VARCHAR(50),
    tel_no VARCHAR(25),
    address1 varchar(500),
    address2 varchar(100)
);

CREATE TABLE orders(
    id serial  PRIMARY KEY,
    customer_id serial NOT NULL,
    order_date DATE,
    order_status INTEGER ,
    payment_id serial,
    delivery_id serial,
    total_cost money
);

CREATE  TABLE  order_products (
    id serial  PRIMARY KEY,
    order_id serial,
    product_id serial,
    count INTEGER
);
CREATE TABLE shopping_cart(
    id serial primary key ,
    customer_id serial,
    total_cost money
);

CREATE TABLE cart_products (
    id serial PRIMARY KEY,
    shoppingcart_id serial,
    product_id serial,
    count INTEGER
);

CREATE TABLE department(
    id serial PRIMARY KEY,
    name varchar(50)
);
CREATE TABLE product (
     id SERIAL PRIMARY KEY ,
     product_brand varchar(50),
     product_name varchar(50),
     product_description varchar(150),
     dept_id SERIAL,
     price money
);

CREATE TABLE runner (
    id serial PRIMARY KEY,
    runner_name varchar(50),
    runner_phone varchar(10)
);

CREATE TABLE inventory(
    id serial PRIMARY KEY ,
    name varchar(50),
    quantity int,
    brand varchar(50),
    count int
);

CREATE TABLE account_profiles(
    id serial PRIMARY KEY ,
    firstname varchar(100),
    lastname varchar (100),
    email varchar(100),
    address varchar (100),
    payment long,
    phone long
);
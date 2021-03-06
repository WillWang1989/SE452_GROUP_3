
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_products;
DROP TABLE IF EXISTS cart_products;
DROP TABLE IF EXISTS shopping_cart;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_img;
DROP TABLE IF EXISTS runner;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS account_profiles;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS store;
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
    total_cost money,
    order_note varchar(200)
);

CREATE  TABLE order_products (
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
    name varchar(50),
    store_id serial
);
CREATE TABLE product (
     id SERIAL PRIMARY KEY ,
     product_brand varchar(50),
     product_name varchar(50),
     product_description varchar(150),
     dept_id SERIAL,
     store_id SERIAL,
     price money
);
CREATE TABLE product_img(
    id SERIAL PRIMARY KEY,
    product_id serial,
    img_path varchar(150),
    img_desc varchar(200)

);

CREATE TABLE runner (
    id serial PRIMARY KEY,
    runner_name varchar(50),
    runner_phone varchar(10),
    password varchar(80)  NOT NULL
);
CREATE TABLE admin(
    id serial PRIMARY KEY,
    user_name varchar(50),
    name varchar(100),
    password varchar(80)  NOT NULL
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
    payment varchar(100),
    phone varchar(20)
);

CREATE TABLE payment (
     id serial PRIMARY KEY,
     payment_type VARCHAR(50),
     amount FLOAT,
     card_num int,
     payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     cust_name VARCHAR(75),
     cust_id integer
);

CREATE TABLE store (
    id serial PRIMARY KEY ,
    store_name VARCHAR(30),
    street_address VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(10),
    zip varchar(5)
);
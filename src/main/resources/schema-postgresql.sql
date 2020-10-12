
CREATE TABLE custormer (
    id serial  PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password varchar(80)  NOT NULL ,
    email VARCHAR(50),
    tel_no VARCHAR(25),
    address1 varchar(500),
    address2 varchar(100)
);

CREATE TABLE order(
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
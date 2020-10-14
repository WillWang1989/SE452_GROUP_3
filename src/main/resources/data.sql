/*INSERT INTO Runner (name, phone) VALUES
            ('Roxxy Andrews', 3122241234),
            ('RuPaul Charles', 3122341234),
            ('Bianca Del Rio', 7732241234);*/
INSERT INTO Department (id,name) VALUES
            (101,'Protein'),
            (102,'Dairy'),
            (103,'Fruit'),
            (104,'Vegetables'),
            (105,'Grains');
/*
INSERT INTO AccountProfiles (firstname, lastname, email, address, payment, phone) VALUES
            ('Roxxy', 'Andrews', 'RoxxyDrag@aol.com', '1234 Main Street', '1236256554788956', 1235218475),
            ('Ivy', 'Winters', 'IvyFrozen@aol.com', '1234 Main Street', '1236256554788956', 1235218475),
            ('Shangela', 'Wodley', 'ShangelaHaleloo@aol.com', '1234 Main Street', '1236256554788956', 1235218475);

INSERT INTO Inventory (id, name, quantity, brand, availability) VALUES
            (1, peanut butter, 12, Skippy, 5),
            (2, peanut butter, 9, Jif, 8),
            (3, mustard, 23, Heinz, 9);
*/
/*
INSERT INTO PAYMENT (id, payment_type, amount, card_num, cust_name, cust_id) VALUES
            (1, 'Debit', 123.12, 123456789, 'Bryan Harris', 12),
            (2, 'Credit', 23.00, 1290830921, 'Michael Jordan', 23),
            (3, 'Debit', 50.20, 21321321, 'Nick Foles', 13)

INSERT INTO store(id, store_name, street_address, city, state, zip) VALUES
            (1, 'Walmart', '123 Main Street', 'Chicago','IL', 23452),
            (2, 'Target', '234 Bears Avenue', 'Chicago','IL', 23436)

-- INSERT INTO aisle(id, num, dept_id) VALUES
--             (1, 3, 4),
--             (2, 2, 4)
*/
INSERT INTO product(product_brand,product_name, product_description, dept_id, price) VALUES
            ('Skippy', 'Peanut Butter', 'smooth peanut butter', 101, 5.99),
            ('Perdue', 'Chicken Breast', 'organic',  101, 7.99),
            ('Fuji', 'Apple', 'large',  101, 2.99),
            ('Green Giant', 'Broccoli', 'florets',  102, 1.99),
            ('Jewel', 'Milk', 'whole',  103, 1.99);
/*
INSERT INTO admin(user_name, name) VALUES
            ('jsmith', 'John Smith'),
            ('jdoe', 'Jane Doe'),
            ('dmill','David Miller'),
            ('ssanders', 'Sarah Sanders')

 */

 INSERT INTO customer(id,username,password,firstname,middlename,lastname,tel_no,email,dob,address1,address2) VALUES
            (100001,'tom','passsw0rd!','Tom','M','Cat','+1 312 222 2222','tom.cat@gmail.com','1940-02-10','33RD ST','Chicago'),
            (100002,'jerry','passsw0rd!','Jerry','M','Mouse','+1 312 666 6666','jerry.mouse@gmail.com','1940-02-10','33RD ST','Chicago'),
            (100003,'test1','passsw0rd!',null,null,null,null,null ,null ,null,null ),
            (100004,'test2','passsw0rd!',null,null,null,null,null ,null ,null,null );

INSERT INTO orders(id,customer_id ,order_date,order_status,payment_id,delivery_id,total_cost) VALUES
            (20001,100001,'2020-10-13',1,20001,300001,199.99),
            (20002,100002,'2020-10-13',2,20002,300003,99.99),
            (20003,100003,'2020-10-13',3,20003,300004,399.99);
INSERT INTO order_products(id ,order_id ,product_id ,count) VALUES
            (default,20001,1,2),
            (default,20001,2,4),
            (default,20001,3,6),
            (default,20002,1,1),
            (default,20002,3,5),
            (default,20003,4,2),
            (default,20003,6,3);

INSERT INTO shopping_cart(id,customer_id,total_cost) VALUES
            (101,100001,88.99),
            (102,100003,288.99),
            (103,100002,66.99);
INSERT INTO cart_products(id,shoppingcart_id,product_id,count) VALUES
            (default,101,1,2),
            (default,101,2,3),
            (default,101,2,1),
            (default,102,3,1),
            (default,102,4,2),
            (default,103,1,5);

INSERT INTO inventory (id, quantity, brand, count) values
            (default, 1, 'Skippy', 2),
            (default, 1, 'Fuji', 3),
            (default, 1, 'Jewel', 2);

INSERT INTO account_profiles(id, firstname, lastname, email, address, payment, phone) values
            (default,'John','Doe', 'thefirst@aol.com', '123 Main Street', 125.00, 3122222222),
            (default,'Jane','Smith', 'thesecond@aol.com', '456 Main Street', 25.00,3125647859),
            (default,'Joe','Glasswell', 'thethird@aol.com', '789 Main Street', 55.00, 3125541235);


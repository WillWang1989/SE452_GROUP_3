INSERT INTO Runner (runner_name, runner_phone,password) VALUES
            ('Roxxy Andrews', 3122241234,'$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),
            ('RuPaul Charles', 3122341234,'$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),
            ('Bianca Del Rio', 7732241234,'$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),
            ('runner01', 7732241234,'$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW');
INSERT INTO Department (id,name,store_id) VALUES
            (101,'Protein',1),
            (102,'Dairy',1),
            (103,'Fruit',1),
            (104,'Vegetables',1),
            (105,'Grains',1),
            (106,'Protein',2),
            (107,'Dairy',2),
            (108,'Fruit',2),
            (109,'Vegetables',2);

INSERT INTO account_profiles (firstname, lastname, email, address, payment, phone) VALUES
            ('Roxxy', 'Andrews', 'RoxxyDrag@aol.com', '1234 Main Street', '1236256554788956', 1235218475),
            ('Ivy', 'Winters', 'IvyFrozen@aol.com', '1234 Main Street', '1236256554788956', 1235218475),
            ('Shangela', 'Wodley', 'ShangelaHaleloo@aol.com', '1234 Main Street', '1236256554788956', 1235218475);
/*
INSERT INTO Inventory (id, name, quantity, brand, availability) VALUES
            (1, peanut butter, 12, Skippy, 5),
            (2, peanut butter, 9, Jif, 8),
            (3, mustard, 23, Heinz, 9);
*/

INSERT INTO PAYMENT (id, payment_type, amount, card_num, cust_name, cust_id) VALUES
            (1, 'Debit', 123.12, 123456789, 'Bryan Harris', 12),
            (2, 'Credit', 23.00, 1290830921, 'Michael Jordan', 23),
            (3, 'Debit', 50.20, 21321321, 'Nick Foles', 13);

INSERT INTO store(id, store_name, street_address, city, state, zip) VALUES
            (1, 'Walmart', '123 Main Street', 'Chicago','IL', 23452),
            (2, 'Target', '234 Bears Avenue', 'Chicago','IL', 23436);
/*
-- INSERT INTO aisle(id, num, dept_id) VALUES
--             (1, 3, 4),
--             (2, 2, 4)
*/
INSERT INTO product(product_brand,product_name, product_description, dept_id, price,store_id) VALUES
            ('Skippy', 'Peanut Butter', 'smooth peanut butter', 101, 5.99,1),
            ('Perdue', 'Chicken Breast', 'organic',  101, 7.99,1),
            ('Fuji', 'Apple', 'large',  101, 2.99,1),
            ('Green Giant', 'Broccoli', 'florets',  102, 1.99,1),
            ('Jewel', 'Milk', 'whole',  103, 1.99,1),
            ('Skippy', 'Peanut Butter', 'smooth peanut butter', 101, 5.99,2),
            ('Perdue', 'Chicken Breast', 'organic',  101, 7.99,2),
            ('Fuji', 'Apple', 'large',  101, 2.99,2),
            ('Green Giant', 'Broccoli', 'florets',  102, 1.99,2),
            ('Jewel', 'Milk', 'whole',  103, 1.99,2),
            ('', 'Perdue Boneless Chicken Breast', 'Perdue Boneless Chicken Breast description', 101, 8.88,1),
            ('', ' Lucerne Milk Reduced Fat 2% ', ' Lucerne Milk Reduced Fat 2%  description', 101, 2.99,1),
            ('', 'Maxwell House Coffee', 'Maxwell House Coffee description', 101, 6.99,1),
            ('', 'Birds Eye Steamfresh Assorted Vegetables', 'Birds Eye Steamfresh Assorted Vegetables description', 101, 2.99,1),
            ('', ' Kerrygold Pure Irish Butter ', ' Kerrygold Pure Irish Butter  description', 101, 4.49,1),
            ('', ' O Organics Organic Brown Eggs Large ', ' O Organics Organic Brown Eggs Large  description', 101, 3.99,1),
            ('', ' Dave''s Killer Bread Organic 21 Grains ', ' Dave''s Killer Bread Organic 21 Grains  description', 101, 5.99,1),
            ('', ' Thomas'' English Muffins ', ' Thomas'' English Muffins  description', 101, 3.49,1),
            ('', ' Digiorno Original Risng Crust Pizza ', ' Digiorno Original Risng Crust Pizza  description', 101, 5.99,1),
            ('', ' Breyer''s Ice Cream - Natural Vanilla ', ' Breyer''s Ice Cream - Natural Vanilla  description', 101, 3.99,1),
            ('', ' Amy''s Cheese Enchiladas ', ' Amy''s Cheese Enchiladas  description', 101, 3.99,1),
            ('', ' Banana - Each ', ' Banana - Each  description', 101, 0.59,1),
            ('', ' Strawberries - 1lb ', ' Strawberries - 1lb  description', 101, 3.99,1),
            ('', ' Large Hass Avocado - Each ', ' Large Hass Avocado - Each  description', 101, 0.98,1),
            ('', ' Fresh Express Caesar Salad Kit i ', ' Fresh Express Caesar Salad Kit i  description', 101, 3.33,1),
            ('', ' RITZ Crackers ', ' RITZ Crackers  description', 101, 2.99,1),
            ('', ' Sabra Classic Hummus ', ' Sabra Classic Hummus  description', 101, 3.59,1),
            ('', ' Oscar Meyer Oven Roasted Turkey Breast ', ' Oscar Meyer Oven Roasted Turkey Breast  description', 101, 7.49,1),
            ('', ' Skippy Peanut Butter Spread Creamy ', ' Skippy Peanut Butter Spread Creamy  description', 101, 6.49,1),
            ('', ' Sargento Mozzarella Sliced Cheese ', ' Sargento Mozzarella Sliced Cheese  description', 101, 3.50,1)
            ;
INSERT INTO product_img(id,product_id,img_path,img_desc) VALUES
            (default,1,'/uploaded/1.jpg',''),
            (default,1,'/uploaded/2.jpg',''),
            (default,1,'/uploaded/3.jpg',''),
            (default,2,'/uploaded/1.jpg',''),
            (default,2,'/uploaded/1.jpg',''),
            (default,3,'/uploaded/1.jpg',''),
            (default,11,'https://images.albertsons-media.com/is/image/ABS/188300166?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,12,'https://images.albertsons-media.com/is/image/ABS/136010246?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,13,'https://images.albertsons-media.com/is/image/ABS/960074879?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,14,'https://images.albertsons-media.com/is/image/ABS/960143200?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,15,'https://images.albertsons-media.com/is/image/ABS/138250237?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,16,'https://images.albertsons-media.com/is/image/ABS/138350308?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,17,'https://images.albertsons-media.com/is/image/ABS/960038380?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,18,'https://images.albertsons-media.com/is/image/ABS/196100807?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,19,'https://images.albertsons-media.com/is/image/ABS/960083417?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,20,'https://images.albertsons-media.com/is/image/ABS/142100392?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,21,'https://images.albertsons-media.com/is/image/ABS/148010415?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,22,'https://images.albertsons-media.com/is/image/ABS/184060007?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,23,'https://images.albertsons-media.com/is/image/ABS/184070124?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,24,'https://images.albertsons-media.com/is/image/ABS/184040158?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,25,'https://images.albertsons-media.com/is/image/ABS/184650224?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,26,'https://images.albertsons-media.com/is/image/ABS/960087287?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,27,'https://images.albertsons-media.com/is/image/ABS/182310178?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,28,'https://images.albertsons-media.com/is/image/ABS/960041860?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,29,'https://images.albertsons-media.com/is/image/ABS/960081797?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available',''),
            (default,30,'https://images.albertsons-media.com/is/image/ABS/960430784?$ecom-product-card-desktop-jpg$&defaultImage=Not_Available','');

INSERT INTO admin(user_name, name,password) VALUES
            ('admin01','admin01','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),
            ('jsmith', 'John Smith','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),
            ('jdoe', 'Jane Doe','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),
            ('dmill','David Miller','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW'),

            ('ssanders', 'Sarah Sanders','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW');



 INSERT INTO customer(id,username,password,firstname,middlename,lastname,tel_no,email,dob,address1,address2) VALUES
            (100001,'tom','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW','Tom','M','Cat','+1 312 222 2222','tom.cat@gmail.com','1940-02-10','33RD ST','Chicago'),
            (100002,'jerry','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW','Jerry','M','Mouse','+1 312 666 6666','jerry.mouse@gmail.com','1940-02-10','33RD ST','Chicago'),
            (100003,'test1','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW',null,null,null,null,null ,null ,null,null ),
            (100004,'test2','$2a$10$9Hrj/lFS8tZpZH2FU7MO7eHg4LJ4Kewarv2iuYPLFE1WqauDlcHeW',null,null,null,null,null ,null ,null,null );

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
            (default,101,3,1),
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


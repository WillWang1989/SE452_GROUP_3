/*INSERT INTO Runner (name, phone) VALUES
            ('Roxxy Andrews', 3122241234),
            ('RuPaul Charles', 3122341234),
            ('Bianca Del Rio', 7732241234);*/
INSERT INTO Department (name) VALUES
            ('Protein'),
            ('Dairy'),
            ('Fruit'),
            ('Vegetables'),
            ('Grains');
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
            ('Skippy', 'Peanut Butter', 'smooth peanut butter', 1, 5.99),
            ('Perdue', 'Chicken Breast', 'organic',  1, 7.99),
            ('Fuji', 'Apple', 'large',  1, 2.99),
            ('Green Giant', 'Broccoli', 'florets',  2, 1.99),
            ('Jewel', 'Milk', 'whole',  3, 1.99)
/*
INSERT INTO admin(user_name, name) VALUES
            ('jsmith', 'John Smith'),
            ('jdoe', 'Jane Doe'),
            ('dmill','David Miller'),
            ('ssanders', 'Sarah Sanders')

 */
INSERT INTO Runner (name, phone) VALUES
            ('Roxxy Andrews', 3122241234),
            ('RuPaul Charles', 3122341234),
            ('Bianca Del Rio', 7732241234);

INSERT INTO AccountProfiles (firstname, lastname, email, address, payment, phone) VALUES
            ('Roxxy', 'Andrews', 'RoxxyDrag@aol.com', '1234 Main Street', '1236256554788956', 1235218475),
            ('Ivy', 'Winters', 'IvyFrozen@aol.com', '1234 Main Street', '1236256554788956', 1235218475),
            ('Shangela', 'Wodley', 'ShangelaHaleloo@aol.com', '1234 Main Street', '1236256554788956', 1235218475);

INSERT INTO Inventory (id, name, quantity, brand, availability) VALUES
            (1, peanut butter, 12, Skippy, 5),
            (2, peanut butter, 9, Jif, 8),
            (3, mustard, 23, Heinz, 9);

INSERT INTO students (stu_id, nm, email) VALUES
            ('11101', 'Sheena Wyre', 'swyre0@un.org'),
            ('11100', 'Dilly Caffery', 'dcaffery1@blogspot.com'),
            ('22200', 'Marysa Alyonov', 'malyonov3@utexas.edu'),
            ('22201', 'Julie Venturoli', 'jventuroli4@marketwatch.com'),
            ('22202', 'SFrieda Liddiatt', 'fliddiatt6@yahoo.co.jp');

INSERT INTO course(dept, num) VALUES
            ('SE', 452),
            ('SE', 352);


INSERT INTO course_students(students_id) select id from students where stu_id like '111%';
UPDATE course_students set course_id = (select id from course where num=452);

INSERT INTO course_students(students_id) select id from students where stu_id like '222%';
UPDATE course_students set course_id =( select id from course where num=352) where course_id is null;

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
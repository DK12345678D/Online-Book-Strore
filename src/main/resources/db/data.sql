-- BOOKS
INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (1, 'Effective Java', '45.99', 'Joshua Bloch', '9780134685991', 'Addison-Wesley', '2018-01-06');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (2, 'Clean Code', '40.00', 'Robert C. Martin', '9780132350884', 'Prentice Hall', '2008-08-11');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (3, 'JavaScript: The Good Parts', '25.89', 'Douglas Crockford', '9780596517748', 'Reilly Media', '2008-05-15');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (4, 'Python Crash Course', '32.95', 'Eric Matthes', '9781593276034', 'No Starch Press', '2015-11-01');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (5, 'Learning SQL', '28.00', 'Alan Beaulieu', '9780596520830', 'Reilly Media', '2009-04-01');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (6, 'The Go Programming Language', '38.50', 'Alan Donovan, Brian Kernighan', '9780134190440', 'Addison-Wesley', '2015-10-26');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (7, 'C Programming Language', '50.00', 'Brian Kernighan, Dennis Ritchie', '9780131103627', 'Prentice Hall', '1988-03-22');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (8, 'Head First Design Patterns', '44.95', 'Eric Freeman, Elisabeth Robson', '9780596007126', 'Reilly Media', '2004-10-25');

INSERT INTO BOOKS (id, name, price, authors, isbn, publisher, published_on) 
VALUES (9, 'You Don’t Know JS Yet', '34.95', 'Kyle Simpson', '9781098124045', 'Reilly Media', '2020-01-28');


-- USERS
INSERT INTO USERS (username, password, enabled) 
	VALUES ('admin', '{noop}admin', 1);
	

-- AUTHORITIES
INSERT INTO AUTHORITIES (username, authority) 
	VALUES ('admin', 'ADMIN');
insert into book (id, author, release_date, title)VALUES (1,'Dan Brown',2003,'The Da Vinci Code');
insert into book (id, author, release_date, title)VALUES(2,'J. K. Rowling',1998,'Harry Potter and the Chamber of Secrets');
insert into book (id, author, release_date, title) VALUES(3,'Paulo Coelho',1988,'The Alchemist');
insert into book(id, author, release_date, title) VALUES(4,'Gabriel García Márquez',1967,'One Hundred Years of Solitude');
insert into book (id, author, release_date, title) VALUES(5,'George Orwell',1945,'Animal Farm');
insert into book (id, author, release_date, title) VALUES (6,'Dan Brown',1998,'Digital Fortress');
insert into book (id, author, release_date, title) VALUES (7,'Test Auth',2020,'Test TitleDan');

insert into customer(id, create_account_date, firstname, lastname) VALUES(1,'2021-01-01','John','Smith') ;
insert into customer(id, create_account_date, firstname, lastname) VALUES(2,'2022-02-02','Antonio','Banderas') ;
insert into customer(id, create_account_date, firstname, lastname) VALUES(3,'2000-11-11','John','Rambo') ;

insert into copy (id, signature, status, book_id) VALUES (1,'sig-001', 'AVAILABLE',1);
insert into copy (id, signature, status, book_id) VALUES (2,'sig-002', 'LOST',1);
insert into copy (id, signature, status, book_id) VALUES (3,'sig-003', 'IN_USE',1);
insert into copy (id, signature, status, book_id) VALUES (4,'sig-004', 'DESTROYED',1);
insert into copy (id, signature, status, book_id) VALUES (5,'sig-001', 'AVAILABLE',2);
insert into copy (id, signature, status, book_id) VALUES (6,'sig-001', 'AVAILABLE',3);
insert into copy (id, signature, status, book_id) VALUES (7,'sig-001', 'AVAILABLE',4);
insert into copy (id, signature, status, book_id) VALUES (9,'sig-001', 'AVAILABLE',6);
insert into copy (id, signature, status, book_id) VALUES (10,'sig-001', 'AVAILABLE',7);
insert into copy (id, signature, status, book_id) VALUES (11,'sig-001', 'IN_USE',7);

insert into borrow (id, book_id, borrow_date, copy_id, return_date, customer_id) VALUES (1,1,'2021-01-01',1,'2021-01-02',1);
insert into borrow (id, book_id, borrow_date, copy_id, return_date, customer_id) VALUES (2,1,'2021-01-01',2,null,2);
insert into borrow (id, book_id, borrow_date, copy_id, return_date, customer_id) VALUES (3,2,'2022-02-02',1,'2022-05-12',3);


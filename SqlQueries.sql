-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
    pid integer NOT NULL,
    pname character varying(30) COLLATE pg_catalog."default",
    unitprice integer,
    CONSTRAINT product_pkey PRIMARY KEY (pid)
)

TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;



 create table orderItem(
 itemId integer Primary Key,
 pid integer REFERENCES public.product(pid),
 pname varchar(30),
 quantity integer,
 unitPrice integer,
 itemTotalPrice integer NOT NULL
);

SELECT pname, unitPrice*quantity  AS itemTotalPrice
FROM orderItem;

SELECT p.pname,
 oi.unitPrice*oi.quantity  AS itemTotalPrice
FROM orderItem oi
JOIN product p ON p.pid=oi.pid;

UPDATE orderItem SET itemTotalPrice=quantity*unitPrice

insert into orderItem values(1,1,'T-shirts',2,9999,22);
insert into orderItem values(3,2,'Dresses',2,100000,20000);

select * from orderItem;

ALTER TABLE orderItem
ADD itemTotalPrice AS quantity*unitPrice;

create table books(bookid int ,bookname varchar(50),description varchar(50))

create table authors(authorid int ,authorname varchar(50),desription varchar(50),bookid int)

insert into books values(1,'Book1','Sample book');
insert into books values(2,'Book2','Sample book');
insert into books values(3,'Book3','Sample book');

select * from books;

insert into authors values (101,'Author1','Novels',1);
insert into authors values (102,'Author2','Novels',2);
insert into authors values (103,'Author3','Novels',3);

select * from authors;

INSERT INTO public.orderitem(
	itemid, pid, pname, quantity, unitprice, itemTotalPrice)
	VALUES (5, 3, 'Tops', 2, 300, 600);


 create table public.order 
 (
 orderId integer Primary Key,
 custId integer REFERENCES public.customer(custId),
 itemId integer REFERENCES public.orderItem(itemId),
 orderDate varchar(30),
 totalOrderPrice integer
);

SELECT pname, unitPrice*quantity  AS itemTotalPrice
FROM orderItem;

SELECT p.pname,
 oi.unitPrice*oi.quantity  AS itemTotalPrice
FROM orderItem oi
JOIN product p ON p.pid=oi.pid;

UPDATE orderItem SET itemTotalPrice=quantity*unitPrice

insert into order values(1,1,'T-shirts',2,9999,22);
insert into order values(3,2,'Dresses',2,100000,20000);

CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers (first_name, last_name, age, country)
values ('Oleg', 'Ivanov', 23, 'Russia');
insert into customers (first_name, last_name, age, country)
values ('Stepan', 'Smirnov', 45, 'Russia');
insert into customers (first_name, last_name, age, country)
values ('Alex', 'Petrov', 30, 'Russia');

select * from customers
where age = (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders (amount, customer_id)
values (83, 1);
insert into orders (amount, customer_id)
values (72, 3);


select * from customers
where id not in (select customer_id from orders);
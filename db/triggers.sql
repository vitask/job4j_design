create table products(
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

insert into products(name, producer, count, price) values ('product1', 'producer1', 5, 100);
insert into products(name, producer, count, price) values ('product2', 'producer2', 2, 230);
insert into products(name, producer, count, price) values ('product3', 'producer3', 8, 70);

create function tax_statement()
returns trigger as
$$
    begin
        update products
        set price = price + price * 0.13
        where id = (select id from inserted);
        return new;
     end;
$$
language 'plpgsql';

create trigger tax_statement
after insert
on products
referencing new table as inserted
for each statement
execute procedure tax_statement();

insert into products(name, producer, count, price) values ('product4', 'producer4', 3, 90);
insert into products(name, producer, count, price) values ('product5', 'producer5', 7, 160);
insert into products(name, producer, count, price) values ('product6', 'producer6', 10, 200);

alter table products disable trigger tax_statement;

create function tax_row()
returns trigger as
$$
    begin
        new.price = new.price + new.price * 0.13;
        return new;
    end;
$$
language 'plpgsql'

create trigger tax_row
before insert
on products
for each row
execute procedure tax_row();

insert into products(name, producer, count, price) values ('product7', 'producer7', 1, 20);
insert into products(name, producer, count, price) values ('product8', 'producer8', 4, 100);
insert into products(name, producer, count, price) values ('product9', 'producer9', 11, 220);

alter table products disable trigger tax_row;

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create function insert_history()
returns trigger as
$$
    begin
        insert into history_of_price (name, price, date)
        values (new.name, new.price, now());
        return new;
    end;
$$
language 'plpgsql'

create trigger insert_history
after insert
on products
for each row
execute procedure insert_history();
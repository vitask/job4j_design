create table type(
    id serial primary key,
    type_name varchar(255)
);

create table product(
    id serial primary key,
    product_name varchar(255),
    type_id int references type(id),
    expired_date date,
    price real
);

insert into type(type_name) values ('Сыр'), ('Молоко'), ('Мясо'), ('Крупа'), ('Мороженное');

insert into product(product_name, type_id, expired_date, price) values ('Сыр Российский', 1, '2024.02.24', 229);
insert into product(product_name, type_id, expired_date, price) values ('Сыр Адыгейский', 1, '2021-11-05', 419);
insert into product(product_name, type_id, expired_date, price) values ('Сыр Моцарелла', 1, '2025-06-10', 959);

insert into product(product_name, type_id, expired_date, price) values ('Молоко коровье', 2, '2023-12-02', 89);
insert into product(product_name, type_id, expired_date, price) values ('Молоко козье', 2, '2022-12-22', 229);
insert into product(product_name, type_id, expired_date, price) values ('Молоко кокосовое', 2, '2025-12-24', 169);

insert into product(product_name, type_id, expired_date, price) values ('Говядина', 3, '2024-02-04', 619);
insert into product(product_name, type_id, expired_date, price) values ('Баранина', 3, '2024-01-20', 469);
insert into product(product_name, type_id, expired_date, price) values ('Конина', 3, '2023-12-03', 919);
insert into product(product_name, type_id, expired_date, price) values ('Свинина', 3, '2023-12-22', 369);
insert into product(product_name, type_id, expired_date, price) values ('Курица', 3, '2023-12-23', 189);

insert into product(product_name, type_id, expired_date, price) values ('Рис', 4, '2024-04-04', 149);
insert into product(product_name, type_id, expired_date, price) values ('Греча', 4, '2025-08-25', 129);
insert into product(product_name, type_id, expired_date, price) values ('Пшено', 4, '2026-10-09', 109);

insert into product(product_name, type_id, expired_date, price) values ('Сливочное', 5, '2024-02-27', 129);
insert into product(product_name, type_id, expired_date, price) values ('Шоколадное', 5, '2023-12-22', 109);
insert into product(product_name, type_id, expired_date, price) values ('Фруктовый лёд', 5, '2021-04-12', 39);
insert into product(product_name, type_id, expired_date, price) values ('Сорбет', 5, '2024-02-05', 69);

select * from product;

select product_name as "Наименование продукта", expired_date as "Срок годности", type_name as Тип, price as Прайс
from product p
join type t on p.type_id = t.id
where t.type_name = 'Сыр';

select product_name as "Наименование продукта", expired_date as "Срок годности", price as Прайс
from product
where product_name like '%Сыр%';

select * from product
where expired_date < now();

select product_name as "Наименование продукта", price as Прайс
from product
where price = (select max(price) from product);

select t.type_name as Имя_типа, COUNT(t.type_name) as Количество
from product p
join type as t
on p.type_id = t.id
group by t.type_name;

select t.type_name as Имя_типа, p.product_name as Продукт
from product p
join type as t
on p.type_id = t.id
where t.type_name like 'Сыр'
or t.type_name like 'Молоко';

select type_name from type
join product as p
on p.type_id = type.id
group by type_name
having count(type_name) < 10;

select t.type_name as "Тип продукта", p.product_name as "Наименование продукта", p.expired_date as "Срок годности", p.price as Прайс
from type as t
join product as p
on p.type_id = t.id;
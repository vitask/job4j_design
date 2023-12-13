create table devices(
    id serial primary key,
    devices_name varchar(255),
    price real
);

create table people(
    id serial primary key,
    people_name varchar(255)
);

create table devices_people(
    id serial primary key,
    devices_id int references devices(id),
    people_id int references people(id)
);

insert into devices(devices_name, price) values ('phone', 73.2);
insert into devices(devices_name, price) values ('car', 251.4);
insert into devices(devices_name, price) values ('tv', 28.9);
insert into devices(devices_name, price) values ('microwave', 7.5);

insert into people(people_name) values ('Oleg');
insert into people(people_name) values ('Kolya');
insert into people(people_name) values ('Petr');

insert into devices_people(devices_id, people_id)
values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3), (4, 1), (4, 2), (4, 3);

select avg(price) as "Средняя цена" from devices;

select p.people_name as Имя, avg(d.price) as "Средняя цена"
from devices_people as dp
join devices as d on dp.devices_id = d.id
join people as p on dp.devices_id = p.id
group by p.people_name;

select p.people_name as Имя, avg(d.price) as "Средняя цена"
from devices_people as dp
join devices as d on dp.devices_id = d.id
join people as p on dp.people_id = p.id
group by p.people_name
having avg(d.price) > 50;
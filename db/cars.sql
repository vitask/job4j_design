create table car_bodies(
    id serial primary key,
    bodies_name varchar(255)
);

create table car_engines(
    id serial primary key,
    engines_name varchar(255)
);

create table car_transmissions(
    id serial primary key,
    transmissions_name varchar(255)
);

create table car(
    id serial primary key,
    car_name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies (bodies_name) values ('седан'), ('хэтчбек'), ('пикап'), ('кабриолет');

insert into car_engines (engines_name) values ('1.0'), ('1.5'), ('2.0');

insert into car_transmissions (transmissions_name) values ('АКПП'), ('МКПП');

insert into car (car_name, body_id, engine_id, transmission_id)
values ('toyota', 1, 1, 1),
        ('bmw', 1, 3, 2),
        ('ford', 3, 2, 1),
        ('audi', 2, 2, 2),
        ('tesla', 1, null, 1),
        ('nissan', 1, 3, null);

select c.id, car_name, bodies_name, engines_name, transmissions_name
from car as c
left join car_bodies as b on b.id = c.body_id
left join car_engines as e on e.id = c.engine_id
left join car_transmissions as t on t.id = c.transmission_id;

select b.bodies_name as "Неиспользованные кузова"
from car as c
right join car_bodies as b on b.id = c.body_id
where c.car_name is null;

select e.engines_name as "Неиспользованные двигатели"
from car as c
right join car_engines as e on e.id = c.engine_id
where c.car_name is null;

select t.transmissions_name as "Неиспользованные КПП"
from car as c
right join car_transmissions as t on t.id = c.transmission_id
where c.car_name is null;
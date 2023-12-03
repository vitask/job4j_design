create table fauna
(
    id serial primary key,
    name_fauna text,
    avg_age int,
    discovery_date date
);

insert into fauna (name_fauna, avg_age, discovery_date) values ('cat', 5000, '1790-01-24');
insert into fauna (name_fauna, avg_age, discovery_date) values ('dog', 7500, '1932-05-21');
insert into fauna (name_fauna, avg_age, discovery_date) values ('fish', 1000, null);
insert into fauna (name_fauna, avg_age, discovery_date) values ('elephant', 25000, '1922-10-01');
insert into fauna (name_fauna, avg_age, discovery_date) values ('mouse', 400, null);
insert into fauna (name_fauna, avg_age, discovery_date) values ('bird', 4000, '1810-11-22');
insert into fauna (name_fauna, avg_age, discovery_date) values ('snake', 10000, null);

select * from fauna where name_fauna like '%fish%';
select * from fauna where avg_age between 10000 and 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
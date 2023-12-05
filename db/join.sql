create table departments
(
    id serial primary key,
    departments_name text,
    insurance boolean
);

create table employee
(
    id serial primary key,
    first_name text,
    start_date date,
    departments_id int references departments(id)
);

insert into departments (departments_name, insurance) values ('IT', true);
insert into departments (departments_name, insurance) values ('Manager', true);
insert into departments (departments_name, insurance) values ('Accounting', false);
insert into departments (departments_name, insurance) values ('Sales', false);

insert into employee (first_name, start_date, departments_id) values ('Oleg', '2009-01-08', 1);
insert into employee (first_name, start_date, departments_id) values ('Stepan', '2011-02-23', 1);
insert into employee (first_name, start_date, departments_id) values ('Petr', '2007-11-30', 2);
insert into employee (first_name, start_date, departments_id) values ('Vitalya', '2008-05-21', 2);
insert into employee (first_name, start_date, departments_id) values ('Katya', '2007-04-22', 3);
insert into employee (first_name, start_date, departments_id) values ('Marat', '2010-06-11', 3);
insert into employee (first_name, start_date, departments_id) values ('Ira', '2015-11-13', null);

select e.first_name, e.start_date, d.departments_name, d.insurance
from employee as e join departments as d on e.departments_id = d.id;

select e.first_name as Имя, e.start_date as "Первый рабочий день", d.departments_name as Департамент, d.insurance as Страховка
from employee as e join departments as d on e.departments_id = d.id;

select e.first_name as Имя, e.start_date as "Первый рабочий день", d.departments_name as Департамент, d.insurance as Страховка
from employee as e join departments as d on e.departments_id = d.id where start_date > '2008-01-01' and insurance = false;
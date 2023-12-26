create table department(
    id serial primary key,
    department_name varchar(255)
)

create table employee(
    id serial primary key,
    employee_name varchar(255),
    department_id int references department(id)
)

insert into department (department_name)
values ('dep1'), ('dep2'), ('dep3'), ('dep4');

insert into employee (employee_name, department_id)
values ('empl1', 1), ('empl2', 2), ('empl3', 3), ('empl4', null), ('empl5', 1), (null, null);

select employee_name, department_id, department_name from employee e join department d on e.department_id = d.id;
select employee_name, department_id, department_name from employee e left join department d on e.department_id = d.id;
select employee_name, department_id, department_name from employee e right join department d on e.department_id = d.id;
select employee_name, department_id, department_name from employee e full join department d on e.department_id = d.id;
select employee_name, department_id, department_name from employee cross join department;

select * from employee e left join department d on e.department_id = d.id where employee_name is null;

select * from employee e left join department d on e.department_id = d.id;
select * from department d right join employee e on e.department_id = d.id;

create table teens(
    id serial primary key,
    teens_name varchar(255),
    genger varchar(1)
)

insert into teens(teens_name, genger) values ('Oleg', 'M'), ('Anton', 'M'), ('Ira', 'W'), ('Kolya', 'M'), ('Masha', 'W');

select m.teens_name, w.teens_name from teens m cross join teens w where m.genger = 'M' and w.genger = 'W';
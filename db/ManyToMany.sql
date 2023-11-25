create table employee(
    id serial primary key,
    employee_name varchar(255)
);

create table departments(
    id serial primary key,
    departments_key varchar(255)
);

create table company(
    id serial primary key,
    employee_id int references employee(id),
    departments_id int references departments(id)
);

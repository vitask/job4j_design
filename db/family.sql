create table family (
	id serial primary key,
	first_name varchar(255),
	age integer,
	work text,
	have_car boolean
);
insert into family (first_name, age, work, have_car) values ('Олег', 33, 'Водитель', true);
update family set work = 'Программист';
delete from family;
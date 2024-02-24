/*    read committed      */

create table people (
    id serial primary key,
    name varchar(50),
    age integer
);

insert into people (name, age) values ('Oleg', 34);
insert into people (name, age) values ('Masha', 33);
insert into people (name, age) values ('Semen', 9);


/*  first transaction  */
begin transaction;
select * from people;
insert into people (name, age) values ('Stepan', 12);
delete from people where name = 'Oleg';
update people set age = 10 where name = 'Semen';
commit;
select * from people;


/*  second transaction  */
begin transaction;
select * from people;
select * from people;
commit;


/*    repeatable read      */

create table people1 (
    id serial primary key,
    name varchar(50),
    age integer
);

insert into people1 (name, age) values ('Oleg', 34);
insert into people1 (name, age) values ('Masha', 33);
insert into people1 (name, age) values ('Semen', 9);

/*  first transaction  */
begin transaction isolation level repeatable read;
select * from people;
insert into people (name, age) values ('Stepan', 12);
delete from people where name = 'Oleg';
update people set age = 10 where name = 'Semen';
rollback;

/*  second transaction  */
begin transaction isolation level repeatable read;
select * from people;
update people set age = 10 where name = 'Semen';
commit;


/*    serializable      */


create table people (
    id serial primary key,
    name varchar(50),
    age integer
);

insert into people (name, age) values ('Oleg', 34);
insert into people (name, age) values ('Masha', 33);
insert into people (name, age) values ('Semen', 9);

/*  first transaction  */
begin transaction isolation level serializable;
select sum(age) from people;
insert into people(name, age) values ('Kolya', 14);
commit;

/*  second transaction  */
begin transaction isolation level serializable;
select sum(age) from people;
insert into people(name, age) values ('Kolya', 14);
commit;
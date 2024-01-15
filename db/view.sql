create table students(
    id serial primary key,
    students_name varchar(50)
);

insert into students(students_name)
values ('Олег Олегов'), ('Борис Борисов'), ('Степан Степанов');

create table author(
    id serial primary key,
    author_name varchar(50)
);

insert into author(author_name)
values ('Пушкин'), ('Грибоедов'), ('Лермонтов');

create table books(
    id serial primary key,
    books_name varchar(200),
    author_id integer references author(id)
);

insert into books(books_name, author_id)
values ('Евгений Онегин', 1),
       ('Капитанская Дочь', 1),
       ('Руслан и Людмила', 1),
       ('Горе от ума', 2),
       ('Студент', 2),
       ('Герой нашего времени', 3);

create table orders(
    id serial primary key,
    active boolean default true,
    books_id integer references books(id),
    students_id integer references students(id)
);

insert into orders(books_id, students_id)
values (1, 1), (2, 1), (5, 2),
       (3, 2), (6, 1), (4, 3),
       (1, 2), (2, 3), (6, 3);


create view students_with_book_gore_ot_yma_and_evgeniy_onegin
as
select s.students_name as Имя_студента, a.author_name as Автор_книги, b.books_name as Книга
from orders as o
            full join students as s on s.id = o.students_id
            full join books as b on o.books_id = b.id
            full join author as a on b.author_id = a.id
where students_name = (select students_name
					from orders
					where books_name like 'Горе от ума'
					    or books_name like 'Евгений Онегин'
					group by students_name
					 )
order by s.students_name;

select * from students_with_book_gore_ot_yma_and_evgeniy_onegin;
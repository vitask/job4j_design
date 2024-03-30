CREATE TABLE movie
(
    id       SERIAL PRIMARY KEY,
    name     text,
    director text
);

CREATE TABLE book
(
    id     SERIAL PRIMARY KEY,
    title  text,
    author text
);

INSERT INTO movie (name, director)
VALUES ('Марсианин', 'Ридли Скотт'),
       ('Матрица', 'Братья Вачовски'),
       ('Властелин колец', 'Питер Джексон'),
       ('Гарри Поттер и узник Азкабана', 'Альфонсо Куарон'),
       ('Железный человек', 'Джон Фавро');

INSERT INTO book (title, author)
VALUES ('Гарри Поттер и узник Азкабана', 'Джоан Роулинг'),
       ('Властелин колец', 'Джон Толкин'),
       ('1984', 'Джордж Оруэлл'),
       ('Марсианин', 'Энди Уир'),
       ('Божественная комедия', 'Данте Алигьери');

select name
from movie
intersect
select title
from book;

select name
from movie
except
select title
from book;

select name
from movie
union
select title
from book;
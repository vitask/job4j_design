create table driving_license(
    id serial primary key,
    seria int,
    number int
);

create table people(
    id serial primary key,
    driving_license_id int references driving_license(id) unique
);
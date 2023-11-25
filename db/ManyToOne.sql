create table doctor(
    id serial primary key,
    doctor_name varchar(255)
);

create table patient(
    id serial primary key,
    diagnose varchar(255),
    doctor_id int references doctor(id)
);

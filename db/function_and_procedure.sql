create table products(
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create
or replace procedure del_id(d_id integer)
language 'plpgsql'
as $$
	begin
		if d_id > 0 then
 			delete from products
			where id = d_id;
		else
			delete from products;
			end if;
	end
$$;

insert into products (name, producer, count, price) values ('product1', 'producer1', 12, 30);
insert into products (name, producer, count, price) values ('product2', 'producer2', 0, 120);
insert into products (name, producer, count, price) values ('product3', 'producer3', 7, 60);

call del_id(3);
call del_id(0);

DELETE FROM products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

create
or replace function del_price(dp_price integer)
returns void
language 'plpgsql'
as
$$
	begin
		delete from products
		where price < d_price;
	end;
$$;

insert into products (name, producer, count, price) values ('product1', 'producer1', 12, 30);
insert into products (name, producer, count, price) values ('product2', 'producer2', 0, 120);
insert into products (name, producer, count, price) values ('product3', 'producer3', 7, 60);

select del_price(50);

DELETE FROM products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

create
or replace function del_name(dn_name varchar)
returns void
language 'plpgsql'
as
$$
	begin
		delete from products
		where name = dn_name;
	end;
$$;

insert into products (name, producer, count, price) values ('product1', 'producer1', 12, 30);
insert into products (name, producer, count, price) values ('product2', 'producer2', 0, 120);
insert into products (name, producer, count, price) values ('product3', 'producer3', 7, 60);
insert into products (name, producer, count, price) values ('product1', 'producer2', 4, 50);

select del_name('product2');
select del_name('product1');
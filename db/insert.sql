insert into roles(roles_name) values ('ADMIN');
insert into roles(roles_name) values ('USER');

insert into rules(rules_name) values ('create');
insert into rules(rules_name) values ('read');
insert into rules(rules_name) values ('update');
insert into rules(rules_name) values ('delete');

insert into users(user_name, users_id) values ('Oleg', 1);
insert into users(user_name, users_id) values ('Stas', 2);
insert into users(user_name, users_id) values ('Anton', 3);

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (1, 2);
insert into roles_rules(roles_id, rules_id) values (1, 3);
insert into roles_rules(roles_id, rules_id) values (1, 4);
insert into roles_rules(roles_id, rules_id) values (2, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);

insert into categories(categories_name) values ('sale');
insert into categories(categories_name) values ('buy');

insert into states(states_name) values ('sale closed');
insert into states(states_name) values ('sale is open');
insert into states(states_name) values ('sold');

insert into item(item_name, users_id, categories_id, states_id) values ('car', 2, 1, 2);
insert into item(item_name, users_id, categories_id, states_id) values ('house', 2, 2, 3);

insert into attachs(attachs_name, item_id) values ('IMG', 1);
insert into attachs(attachs_name, item_id) values ('PDF', 2);

insert into comments(comments_name, item_id) values ('Audi A4 2014', 1);
insert into comments(comments_name, item_id) values ('house have 4 rooms', 1);

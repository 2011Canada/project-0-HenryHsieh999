drop schema if exists e720 cascade;
create schema e720;
set schema 'e720';


create table users (
	user_id serial primary key,
	fname text not null,
	lname text not null,
	user_name text,
	user_password text not null,
	user_status text not null,
	tpe text
);


create table customer (
	user_id int unique not null references users (user_id),
	customer_id serial primary key
);
create table employee (
	user_id int unique not null references users (user_id),
	customer_id int not null references customer(customer_id),
	employee_id serial primary key
);

create table account (
	balance numeric(10,2) not null,
	customer_id int not null references users (user_id)
	account_id serial primary key
);
--drop table money_transfer ;
create table money_transfer(
	receiver_account_id int,
	balance numeric(10,2),
	sender_account_id int,
	money_transfer_status text,
	transfer_id serial primary key
);

begin;

insert into users (fname, lname, user_name, user_password , user_status, tpe) values ('ww', 'www','wwww', 'pword1','active','employee') returning user_id;
insert into customer (user_id) values (1);
insert into account (balance, customer_id) values (10.00, 1);
insert into users(fname, lname, user_name, user_password , user_status, tpe) values ('aa','aaa', 'aaaa','pword', 'active', 'customer')returning user_id;
insert into customer (user_id) values (2);
insert into account (balance, customer_id) values (223.12, 2);

insert into users(fname, lname, user_name, user_password , user_status, tpe) values ('bb','bbb', 'bbbb','pword2', 'active', 'customer')returning user_id;
insert into customer (user_id) values (3);
insert into account (balance, customer_id) values (221.44, 3);

insert into users(fname, lname, user_name, user_password , user_status, tpe) values ('cc','ccc', 'cccc','pword2', 'active', 'customer')returning user_id;
insert into account (balance, customer_id) values (10.00 , 4);

insert into users(fname, lname, user_name, user_password , user_status, tpe) values ('dd','ddd', 'dddd','pword2', 'active', 'customer')returning user_id;
insert into account (balance, customer_id) values (0 , 6);
insert into users(fname, lname, user_name, user_password , user_status, tpe) values ('Melody','Tavi', 'mtv','cat5', 'active', 'employee')returning user_id;
insert into account (balance, customer_id) values (0 , 9);
insert into users(fname, lname, user_name, user_password , user_status, tpe) values ('laser','beam', 'Cloud','muramana3$2', 'active', 'employee')returning user_id;
insert into account (balance, customer_id) values (0 , 11);
commit;

update users set user_status = 'inactive' where user_id = 1;

select * from users u left join account a on u.user_id = a.customer_id where user_id = 1;
--money transfer
select * from money_transfer;
--see both users and account table together
select * from users u left join account a on u.user_id = a.customer_id;

select * from users u left join money_transfer mt on u.user_id = mt.receiver_account_id;
select * from users u left join money_transfer mt on u.user_id = mt.receiver_account_id where receiver_account_id = 1;

select * from money_transfer where sender_account_id = 2;
select * from money_transfer where receiver_account_id = 15;
select * from money_transfer where transfer_id = 3;
delete from money_transfer where transfer_id = 5;
insert into money_transfer (receiver_account_id, balance, sender_account_id, money_transfer_status) values (1, 24.11,2, 'pending');

select * from money_transfer where receiver_account_id = 1;
update account as a set balance = a.balance + mt.balance from money_transfer as mt where a.account_id = mt.receiver_account_id;
update account;

update account set balance = 400.12 where customer_id = 1;
--select active users
select * from users where user_status = 'active' order by user_id asc;
select * from users;
--see both users and account table together
select * from users u left join account a on u.user_id = a.customer_id;
select * from users u left join account a on u.user_id = a.customer_id where user_id = 3;
select * from users u left join account a on u.user_id = a.customer_id where user_password = 'pword';

select * from account where customer_id = 4;

update account set balance = 30012.20 where customer_id = 5;
update account set balance = 2123.12 where customer_id = 1 returning customer_id , balance;
select * from users u left join account a on u.user_id = a.account_id where tpe = 'customer';
select * from users where user_id = 1;
select * from account;
delete from account where account_id = 7;

select * from users where user_name = 'wwww' and user_password = 'pword1';
select * from users;
select * from users where user_id = 1;
select * from employee where user_id = 1;
select * from customer;
select * from transaction_logs;
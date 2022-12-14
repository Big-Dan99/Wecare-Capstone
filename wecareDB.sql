#My database : 
drop database if exists wecaredb;
create database wecaredb;
use wecaredb;
show tables;

desc coach_entity;
desc booking_entity;
desc user_entity;
desc hibernate_sequence;

select * from user_entity;
select * from coach_entity;
select * from booking_entity;
select * from hibernate_sequence;


-- drop table booking_entity;
-- drop table coach_entity;
-- drop table user_entity;

#select * from customer;



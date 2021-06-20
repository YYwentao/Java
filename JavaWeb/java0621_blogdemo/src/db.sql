drop database if exists java0621_blogdemo;
create database java0621_blogdemo;
use java0621_blogdemo;

create table user (
    userId int primary key auto_increment,
    name varchar(50) unique,
    password varchar(50)
);

create table article(
    articleId int primary key auto_increment,
    title varchar (255),
    content text,
    userId int,
    foreign key(userId) references user(userId)
);
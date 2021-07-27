create database if not exists RocketBlog;

use RocketBlog;

drop table if exists  blog;

create table blog(
    blogId int primary key auto_increment,
    title varchar (512),
    content text,
    userId int,
    postTime datetime
);

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar (50),
    password varchar (50)
);
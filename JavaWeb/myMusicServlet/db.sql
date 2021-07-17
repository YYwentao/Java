-- 数据库
drop database if exists `myMusicServer`;
create database if not exists `myMusicServer` character set utf8;
-- 使用数据库
use `myMusicServer`;
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `title` varchar(50) NOT NULL,
    `singer` varchar(30) NOT NULL,
    `time` varchar(13) NOT NULL,
    `url` varchar(100) NOT NULL,
    `userId` int(11) NOT NULL
);
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` varchar(20) NOT NULL,
    `password` varchar(32) NOT NULL,
    `age` INT NOT NULL,
    `gender` varchar(2) NOT NULL,
    `email` varchar(50) NOT NULL
);
DROP TABLE IF EXISTS `lovemusic`;
CREATE TABLE `lovemusic` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `music_id` int(11) NOT NULL
);
INSERT INTO user(username,password,age,gender,email)
VALUES("wt","123","18","男","1938145653@qq.com");
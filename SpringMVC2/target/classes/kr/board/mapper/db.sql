create database mvc2db;
use mvc2db;
create table myboard(
   idx int not null auto_increment,
   memID varchar(20) not null,  
   title varchar(100) not null,
   content varchar(2000) not null,
   writer varchar(30) not null,
   indate datetime default now(),
   count int default 0,
   primary key(idx)
);

create table members(
  memIdx int auto_increment, 
  memID varchar(20) not null,  
  memPassword varchar(20) not null,
  memName varchar(20) not null,
  memAge int,
  memGender varchar(20),
  memEmail varchar(50),
  memProfile varchar(50),
  primary key(memIdx)
);
-- drop table myboard;
insert into members(memID, memPassword,memName) values('admin','1234','관리자'),('qwer','1234','박연미'),('test1','1234','테스트1');

insert into myboard(title,content,writer,memID)
values('게시판 연습','게시판 연습','관리자','admin'),('게시판 연습','게시판 연습','박연미','qwer'),('게시판 연습','게시판 연습','테스트1','test1');

select * from myboard order by idx desc;
select * from members;
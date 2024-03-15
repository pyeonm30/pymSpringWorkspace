create table mem_stbl(
  memIdx int not null, 
  memID varchar(20) not null,  
  memPassword varchar(68) not null,
  memName varchar(20) not null,
  memAge int,
  memGender varchar(20),
  memEmail varchar(50),
  memProfile varchar(50),
  primary key(memID)
);


create table mem_auth(
  no int not null auto_increment,
  memID varchar(50) not null,
  auth varchar(50) not null,
  primary key(no),
  constraint fk_member_auth foreign key(memID) references mem_stbl(memID)
);

select * from mem_auth;

select * from mem_stbl;

select * from mem_auth where memID='test';

delete from mem_auth;
delete from mem_stbl;
delete from myboard;
delete from members;

select IFNULL(MAX(memIdx)+1,1) from mem_stbl mem;

select * from mem_stbl mem LEFT OUTER JOIN mem_auth auth on
 mem.memID=auth.memID where mem.memID='test'

delete from member;
drop table member;

CREATE TABLE ijuju.room(
rno int(3) primary key AUTO_INCREMENT ,
rname VARCHAR(20),
rsize int(2) ,
men int(2) ,
addman int(6) DEFAULT 0,
weekday int(6) ,
weekend int(6) ,
sweekday int(6) ,
sweekend int(6),
constraint room_rname_uk unique(rname)
);


insert into room(rname, rsize, men, addman, weekday, weekend, sweekday, sweekend) values('방1',40,10,6,20000,25000,30000,35000);
insert into room(rname, rsize, men, addman, weekday, weekend, sweekday, sweekend) values('방2',35,8,5,18000,22000,28000,33000);

CREATE TABLE ijuju.PUBLICPENSION(
sseason	VARCHAR(5) NOT NULL,
eseason VARCHAR(5) NOT NULL,
bankname VARCHAR(20) NOT NULL,
banknumber VARCHAR(30) NOT NULL,
bankuser VARCHAR(20) NOT null
);

insert into PUBLICPENSION values('11-01','12-20','대구','111-111-11-1','대구');


CREATE TABLE ijuju.MEMBER (
mno int(5) NOT NULL primary key auto_increment,
id VARCHAR(12) NOT NULL,
passwd VARCHAR(12) NOT NULL,
name VARCHAR(12) NOT NULL,
jumin1 CHAR(6) NOT NULL,
jumin2 CHAR(7) NOT NULL,
email VARCHAR(50) ,
recv_yn CHAR(1) NOT NULL,
phone1 VARCHAR(5) NULL,
phone2 VARCHAR(5) NULL,
phone3 VARCHAR(5) NULL,
cell1 VARCHAR(5) NOT NULL,
cell2 VARCHAR(5) NOT NULL,
cell3 VARCHAR(5) NOT NULL,
zip CHAR(7) NOT NULL,
addr1 VARCHAR(100) NOT NULL,
addr2 VARCHAR(50) NULL,
reg_date TIMESTAMP default now()
);

insert into member(id, passwd, name, jumin1, jumin2, email, recv_yn, phone1, phone2, phone3, cell1, cell2, cell3, zip, addr1, addr2, reg_date)
 values('admin','admin','관리자',0,0,'admin@aaaa.com','n','0','0','0','0','0','0','0','펜션','펜션',now());

CREATE TABLE reservation(
rsno int(11) primary key auto_increment,
rno int(3),
uno int(11),
res_date TIMESTAMP default now(),
night int(2),
usemen int(2),
price int(7) ,
payment CHAR DEFAULT 'C',
pay_name VARCHAR(20) ,
pay_number VARCHAR(20),
pay_yn CHAR DEFAULT 'N',
reg_date TIMESTAMP default now(),
constraint reservation_rno_fk foreign key(rno) references room(rno) ON DELETE CASCADE,
constraint reservation_uno_fk foreign key(uno) references member(mno) ON DELETE CASCADE,
constraint reservation_pay_ck CHECK(pay_yn IN ('Y','N')),
constraint reservation_payment_ck CHECK(payment IN ('C','V')) 
);


create table board (
num int primary key auto_increment,
writer VARCHAR(10),
email VARCHAR(30),
subject VARCHAR(50),
passwd VARCHAR(12),
reg_date date,
readcount int,
ref int,
re_step int,
re_level int,
content long
);

CREATE TABLE BO(
  NO  int(10)  PRIMARY KEY,
  CATEGORY VARCHAR(10),
  TITLE  VARCHAR(100),
  USERNAME VARCHAR(20),
  USERIP  VARCHAR(15),
  PASSWORD VARCHAR(20),
  CONTENT  long,
  FILE_NAME VARCHAR(100),
  HIT  int(10),
  FILE_SIZE  int,
  TIME  DATE
 ) ;

create table notice(
   num int(5) NOT NULL primary key auto_increment,
   id VARCHAR(12) ,
   passwd VARCHAR(12) ,
   name VARCHAR(12) ,
   title VARCHAR(50) ,
   content VARCHAR(1000),
   readcount int(5),
   writedate date
);


 commit;


drop table PUBLICPENSION;
drop sequence member_seq;
drop table  board;
drop sequence seq_board_id;
drop table reservation;
drop sequence room_seq;
drop sequence reservation_seq;
drop table MEMBER;
drop table room;

--// 객실
CREATE TABLE room(
rno NUMBER(3) primary key,
rname VARCHAR2(20 byte),
rsize NUMBER(2) ,
men NUMBER(2) ,
addman NUMBER(6) DEFAULT 0,
weekday NUMBER(6) ,
weekend NUMBER(6) ,
sweekday NUMBER(6) ,
sweekend NUMBER(6),
constraint room_rname_uk unique(rname)
);


--// 객실 시퀀스
CREATE sequence room_seq
minvalue 1
maxvalue 999
increment BY 1
START with 1;


insert into room values(ROOM_SEQ.NEXTVAL,'방1',40,10,6,20000,25000,30000,35000);
insert into room values(ROOM_SEQ.NEXTVAL,'방2',35,8,5,18000,22000,28000,33000);

--// 펜션관리(성수기,계좌)
CREATE TABLE PUBLICPENSION(
sseason	VARCHAR2(5) NOT NULL,
eseason VARCHAR2(5) NOT NULL,
bankname VARCHAR2(20 byte) NOT NULL,
banknumber VARCHAR2(30 byte) NOT NULL,
bankuser VARCHAR2(20 byte) NOT null
);

insert into PUBLICPENSION values('11-01','12-20','대구','111-111-11-1','대구');
--// 회원
CREATE TABLE MEMBER (
mno NUMBER(5) NOT NULL primary key,
id VARCHAR2(12) NOT NULL,
passwd VARCHAR2(12) NOT NULL,
name VARCHAR2(12) NOT NULL,
jumin1 CHAR(6) NOT NULL,
jumin2 CHAR(7) NOT NULL,
email VARCHAR2(50) ,
recv_yn CHAR(1) NOT NULL,
phone1 VARCHAR2(5) NULL,
phone2 VARCHAR2(5) NULL,
phone3 VARCHAR2(5) NULL,
cell1 VARCHAR2(5) NOT NULL,
cell2 VARCHAR2(5) NOT NULL,
cell3 VARCHAR2(5) NOT NULL,
zip CHAR(7) NOT NULL,
addr1 VARCHAR2(100) NOT NULL,
addr2 VARCHAR2(50) NULL,
reg_date TIMESTAMP 
);


--// 예약
CREATE TABLE reservation(
rsno NUMBER(11) primary key,
rno NUMBER(3),
uno NUMBER(11),
res_date DATE,
night NUMBER(2),
usemen NUMBER(2),
price NUMBER(7) ,
payment CHAR DEFAULT 'C',
pay_name VARCHAR2(20 byte) ,
pay_number VARCHAR2(20 byte),
pay_yn CHAR DEFAULT 'N',
reg_date DATE DEFAULT SYSDATE,
constraint reservation_rno_fk foreign key(rno) references room(rno) ON DELETE CASCADE,
constraint reservation_uno_fk foreign key(uno) references member(mno) ON DELETE CASCADE,
constraint reservation_pay_ck CHECK(pay_yn IN ('Y','N')),
constraint reservation_payment_ck CHECK(payment IN ('C','V')) 
);


--// 예약 시퀀스
CREATE sequence reservation_seq
minvalue 1
maxvalue 99999999999
increment BY 1
START with 1;


--// 관리자 입력
insert into member values(0,'admin','admin','관리자',0,0,'admin@aaaa.com','n','0','0','0','0','0','0','0','펜션','펜션',sysdate);

--// 회원시퀀스
create sequence member_seq
start with 1
increment by 1
nocycle nocache;

--// 게시판
create table board (
num number primary key,
writer varchar2(10),
email varchar2(30),
subject varchar2(50),
passwd varchar2(12),
reg_date date,
readcount number,
ref number,
re_step number,
re_level number,
content long
);

--// 게시판
create sequence seq_board_id
increment by 1
start with 1
maxvalue 999999;


drop table bo;

CREATE TABLE BO(
  NO  NUMBER(10)  PRIMARY KEY,
  CATEGORY VARCHAR2(10),
  TITLE  VARCHAR2(100),
  USERNAME VARCHAR2(20),
  USERIP  VARCHAR2(15),
  PASSWORD VARCHAR2(20),
  CONTENT  long,
  FILE_NAME VARCHAR2(100),
  HIT  NUMBER(10),
  FILE_SIZE  NUMBER,
  TIME  DATE
 ) ;

 commit;

 --공지사항게시판
create table notice(
   num NUMBER(5) NOT NULL primary key,
   id VARCHAR2(12) ,
   passwd VARCHAR2(12) ,
   name varchar2(12) ,
   title varchar2(50) ,
   content varchar2(1000),
   readcount number(5),
   writedate date
);

create sequence notice_seq
minvalue 1
maxvalue 999
increment BY 1
START with 1;
 
select * from board;




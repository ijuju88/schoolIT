drop table Accountregistration;
CREATE TABLE Accountregistration
(
  ANO VARCHAR2(15) PRIMARY KEY 
, ANAME VARCHAR2(30) unique NOT NULL 
, ABOSS VARCHAR2(50) NOT NULL 
, ALOC VARCHAR2(100) NOT NULL 
, ACATEGORY VARCHAR2(100)
, AEVENT VARCHAR2(100) 
);
select * from Accountregistration;

insert into ACCOUNTREGISTRATION values(
'221-11-12121', '상호' ,'홍사장','부산시 00구 00동 0000-00','부동산' ,'도매업');
insert into ACCOUNTREGISTRATION values(
'221-11-33333', '상호1' ,'김사장','부산시 00구 00동 0000-00','양식업' ,'김/파래');
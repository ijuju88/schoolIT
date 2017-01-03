drop table Tax;
drop table Tax_key;

create table Tax(
 TNUM VARCHAR2(15) not null,
 Tdate date DEFAULT sysdate not null,
 Tlist varchar2(30)not null, 
 Tstandard varchar2(30)not null,
 Tamount number(10)not null,
 Tunit_price number(20)not null,
 Tprovision number(20)not null,
 Tect varchar2(100 char)
);

create table Tax_key(
TNUM VARCHAR2(15) not null,
 CNO VARCHAR2(15) not NULL,
 ANO VARCHAR2(15) not NULL,
  Ttotal number(20) not null,
 Tcash number(20) not null,
 Tcheck number(20) not null,
 Tpromissory number(20) not null,
 Tcredit number(20) not null,
 Tpay varchar2(10)not null
); 

select * from Tax;

select * from Tax_key;


--CNO VARCHAR2(15) not NULL,
-- CNAME VARCHAR2(30) not NULL ,
-- CBOSS VARCHAR2(50) NOT NULL ,
-- CLOC VARCHAR2(100) NOT NULL ,
-- CCATEGORY VARCHAR2(100),
-- CEVENT VARCHAR2(100),
-- ANO VARCHAR2(15)not NULL,
-- ANAME VARCHAR2(30)NOT NULL ,
-- ABOSS VARCHAR2(50) NOT NULL,
-- ALOC VARCHAR2(100) NOT NULL ,
-- ACATEGORY VARCHAR2(100),
-- AEVENT VARCHAR2(100),




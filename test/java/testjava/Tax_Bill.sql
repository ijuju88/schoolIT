drop table Tax_bill;
drop table Tax_bill_key;

create table Tax_Bill(
 TBNUM VARCHAR2(15) not null, --일련번호(자세한건 코드설명에서..)
 TBdate date DEFAULT sysdate not null, --날짜
 TBlist varchar2(30)not null, --품목
 TBstandard varchar2(30)not null, --규격
 TBamount number(10)not null, --수량
 TBunit_price number(20)not null, --단가
 TBprovision number(20)not null, --공급가액
 TBtax_amount number(20)not null, --세액
 TBect varchar2(100 char) --비고
);
create table Tax_Bill_key(
TBNUM VARCHAR2(15) not null, --일련번호
 CNO VARCHAR2(15) not NULL, -- 회사사업자번호
 ANO VARCHAR2(15) not NULL, --거래처사업자번호
  TBtotal number(20) not null, --합계
 TBcash number(20) not null, --현금
 TBcheck number(20) not null, --수표
 TBpromissory number(20) not null, --어음
 TBcredit number(20) not null, --외상미수금
 TBpay varchar2(10)not null --이금액을 청구/영수
); 

select * from Tax_Bill;

select * from Tax_Bill_key;

select substr(TBNUM, 1,6) from TAX_BILL;

select * from TAX_BILL_KEY
nuion select * from TAX_BILL where substr(TBNUM, 1,6) >= TO_DATE
('2016-10-17','YYYY-MM-DD') AND  substr(TBNUM, 1,6) 
<  TO_DATE('2016-10-17','YYYY-MM-DD')+1;



select tk.TBNUM, max(tk.CNO), max(tk.ANO), max(tk.TBtotal),
max(tk.TBcash),max(tk.TBcheck),max(tk.TBpromissory),
max(tk.TBcredit),max(tk.TBpay),
 t.TBlist, t.TBstandard,t.TBamount,
 t.TBunit_price ,t.TBprovision,
 t.TBtax_amount, t.TBect 
 from TAX_BILL t,TAX_BILL_KEY tk
 where substr(tk.TBNUM, 1,6) >= TO_DATE
('2016-10-17','YYYY-MM-DD') AND  substr(tk.TBNUM, 1,6) 
<  TO_DATE('2016-10-17','YYYY-MM-DD')+1 and tk.tbnum=t.tbnum
group by t.TBlist, t.TBstandard,t.TBamount,
 t.TBunit_price ,t.TBprovision,
 t.TBtax_amount, t.TBect, rollup(tk.TBNUM) order by tk.TBNUM;
 

 select distinct TBNUM, CNO, ANO, TBtotal,
TBcash,TBcheck,TBpromissory,
TBcredit,TBpay
 from TAX_BILL_KEY;
 
 update TAX_BILL set TBNUM='161020-121050'
 where TBNUM='161021-091050';
 
 update TAX_BILL_key set TBNUM='161020-121050'
 where TBNUM='161021-091050';
 
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
 161019-102128 2016-10-19 검색용    묶음             1200         1110     1332000       133200 NULL





drop table Accountregistration;
CREATE TABLE Accountregistration
(
  ANO VARCHAR2(15) PRIMARY KEY --거래처사업자번호
, ANAME VARCHAR2(30) unique NOT NULL --거래처회사명
, ABOSS VARCHAR2(50) NOT NULL --거래처대표
, ALOC VARCHAR2(100) NOT NULL --거래처주소
, ACATEGORY VARCHAR2(100) --거래처 업태
, AEVENT VARCHAR2(100)  --거래처 종목
);
select * from Accountregistration;

desc Accountregistration;

--update Accountregistration set CNAME='g', CBOSS='g', CLOC='dfdfdfd', 
--CCATEGORY='dfd', CEVENT='dd',CSTAMP='C:dd.txt' where CNO='11';

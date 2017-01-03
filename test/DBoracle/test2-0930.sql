--복습합시당
create table employee(
  eNo NUMBER(4),
  eName varchar2(12),
  eDept varchar2(20),
  ePosition VARCHAR2(20),
  ePay NUMBER(15)
);

INSERT INTO EMPLOYEE VALUES(1001,'홍길동', '기획부', '대리', 1800000);

select * from employee;

create table employee2 as select * from employee;
select * from employee2;

create table employee3 as select ENAME,EPAY from employee;
select * from employee3;

create table employee4 as select * from employee where 1=2;
desc employee4;
--------------------------------------------------------------------
--가상칼럼테이블 만들기(11g)
CREATE TABLE vtbl_1( 
no1 NUMBER ,
no2 NUMBER ,
no3 NUMBER GENERATED ALWAYS AS (no1 + no2 ) VIRTUAL ) ;

--값을 넣어 봅니다
INSERT INTO vtbl_1 VALUES (1,2,3);
/*
no3은 두값을 더한값이 나오기 때문에 이렇게 넣으면 안됩니다.
오류 보고 -
SQL 오류: ORA-54013: INSERT operation disallowed on virtual columns
54013. 0000 -  "INSERT operation disallowed on virtual columns"
*Cause:    Attempted to insert values into a virtual column
*Action:   Re-issue the statment without providing values for a virtual column
*/

--다시 테이블에 값을 넣어봅시다
INSERT INTO vtbl_1(no1, no2) VALUES (1,2);

--가상컬럼에 반영되었는지 확인합니다
UPDATE vtbl_1 SET no1=10 ; --업데이트합니다
select * from VTBL_1; --업데이트 안해도 나오네요 ㅋㅋ

--새로운 가상컬럼을 추가합니다
ALTER TABLE vtbl_1 ADD (no4 GENERATED ALWAYS AS ((no1*12)+no2)) ;

--테이블에서 가상 컬럼 내역을 조회합니다.
SELECT column_name, data_type, data_default
FROM user_tab_columns WHERE table_name = 'VTBL_1'
ORDER BY column_id ;

--제약조건설정하기
--기본(테이블 생성시 설정)
CREATE TABLE emp3
( no NUMBER(4)
CONSTRAINT emp3_no_pk PRIMARY KEY ,
name VARCHAR2(10)
CONSTRAINT emp3_name_nn NOT NULL,
jumin VARCHAR2(13)
CONSTRAINT emp3_jumin_nn NOT NULL
CONSTRAINT emp3_jumin_uk UNIQUE ,
area NUMBER(1)
CONSTRAINT emp3_area_ck CHECK ( area < 5 ),
deptno VARCHAR2(6)
CONSTRAINT emp3_deptno_fk REFERENCES dept2(dcode)
) ;

--약식(테이블 생성시 설정) - !!제약조건이 여러개이면 ','넣으면 안됨
CREATE TABLE emp4
( no NUMBER(4) PRIMARY KEY ,
name VARCHAR2(10) NOT NULL,
jumin VARCHAR2(13) NOT NULL UNIQUE ,
area NUMBER(1) CHECK ( area < 5 ),
deptno VARCHAR2(6) REFERENCES dept2(dcode)
) ;
--------------------------------------------------------------------
--실습합시당
create table dept(
  deptno NUMBER(3) PRIMARY KEY,
  dname VARCHAR2(30) UNIQUE not NULL
);

INSERT into dept VALUES(101,'영문');
INSERT into dept VALUES(102,'국문');
INSERT into dept VALUES(103,'경영');

--확인용 ㅋ
--INSERT into dept(DEPTNO)VALUES(104);
--INSERT into dept VALUES(101,'컴공');

INSERT into dept VALUES(104,'컴공');

select * from dept;


create table student(
  sno NUMBER PRIMARY KEY,
  sname VARCHAR2(10) not NULL,
  sgrade NUMBER(1) CHECK (sgrade in(1,2,3,4)),
  sdeptno NUMBER(3) REFERENCES dept(deptno)
);

desc student;

insert into student values(1,'홍길동',1,101);
--insert into student values(1,'김철수',1,101); --PRIMARY KEY때문에 같은수 못넣음
insert into student values(2,'김철수',1,101);

--insert into student(sno, SGRADE, SDEPTNO) values(3,1,101);--sname가 not null임
--insert into student values(3,'김준엽',5,101);--sgrade에 제약조건 걸음 : 1~4
--insert into student values(3,'김준엽',2,105); 
--sdeptno는 dept테이블에 deptno를 참조하는데 그곳의 값이 없으니 안넣어짐
insert into student values(3,'김준엽',4,103); 
select * from STUDENT;

--------------------------------------------------------------
create table emp_dept(
  deptno NUMBER(3) PRIMARY KEY,
  dname VARCHAR2(30) UNIQUE not null,
  loc  NUMBER(1) CHECK (loc<5)
);


CREATE table emp(
  empno number PRIMARY KEY,
  ename VARCHAR2(15) not null,
  eposition VARCHAR2(30) CHECK (eposition in('사원','대리','과장','부장')),
  edeptno NUMBER(3) REFERENCES dept(deptno)
);

desc EMP;

INSERT into emp_dept values(101,'영업부',1);
INSERT into emp_dept values(102,'기획부',2);
INSERT into emp_dept values(103,'홍보부',1);

DELETE FROM EMP_DEPT WHERE deptno=101;
select * from EMP_DEPT ORDER BY 1;

insert into emp values(1, '박영주', '사원', 101);
select * from emp;

CREATE TABLE prodeuct(
  pcode VARCHAR2(5) PRIMARY KEY,
  pname VARCHAR2(30) not null UNIQUE,
  price NUMBER(3) not null
);

create table p_salse(
  sno VARCHAR2(4) PRIMARY KEY,
  pcode VARCHAR2(5) REFERENCES prodeuct(pcode),
  count number not null,
  s_date date DEFAULT SYSDATE
);

INSERT into PRODEUCT values('p001', 'tv', 120);
INSERT into PRODEUCT values('p002', '에어컨', 150);
INSERT into PRODEUCT values('p003', '냉장고', 200);

select * from PRODEUCT;

insert into P_SALSE(sno, pcode, count) VALUES('s001','p001', 5);
insert into P_SALSE(sno, pcode, count) VALUES('s002','p001', 10);
insert into P_SALSE(sno, pcode, count) VALUES('s003','p003', 8);

select * from P_SALSE;
-------------------------------------------------------------------
--ALTER (구조변경)
--새 칼럼 추가
ALTER table emp_dept add(Dline number(4));
select * from EMP_DEPT;

alter table emp add(ehiredate date DEFAULT SYSDATE);
select * from emp;

alter table PRODEUCT add(pro_com VARCHAR2(30));
select * from PRODEUCT;


--칼럼제거
alter table PRODEUCT drop column pro_com;
select * from PRODEUCT;
--참조하고 있는 칼럼 지우기 (권장안함~)
--alter table PRODEUCT drop column pcode CASCADE constraints;

--칼럼명 변경
alter table p_salse RENAME COLUMN count TO cnt;
alter table p_salse RENAME COLUMN s_date TO sales_dete;

select * from P_SALSE;

--테이블 명 변경
RENAME p_salse TO prodeuct_salse;
select * from prodeuct_salse;

--칼럼 데이터 크기 변경
desc PRODEUCT;
alter table prodeuct modify(pname VARCHAR2(20));
alter table prodeuct add(pro_com VARCHAR2(10));
alter table prodeuct MODIFY (pro_com number(4)); --데이터가 들어있으면 하지마세요


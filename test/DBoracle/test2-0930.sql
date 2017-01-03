--�����սô�
create table employee(
  eNo NUMBER(4),
  eName varchar2(12),
  eDept varchar2(20),
  ePosition VARCHAR2(20),
  ePay NUMBER(15)
);

INSERT INTO EMPLOYEE VALUES(1001,'ȫ�浿', '��ȹ��', '�븮', 1800000);

select * from employee;

create table employee2 as select * from employee;
select * from employee2;

create table employee3 as select ENAME,EPAY from employee;
select * from employee3;

create table employee4 as select * from employee where 1=2;
desc employee4;
--------------------------------------------------------------------
--����Į�����̺� �����(11g)
CREATE TABLE vtbl_1( 
no1 NUMBER ,
no2 NUMBER ,
no3 NUMBER GENERATED ALWAYS AS (no1 + no2 ) VIRTUAL ) ;

--���� �־� ���ϴ�
INSERT INTO vtbl_1 VALUES (1,2,3);
/*
no3�� �ΰ��� ���Ѱ��� ������ ������ �̷��� ������ �ȵ˴ϴ�.
���� ���� -
SQL ����: ORA-54013: INSERT operation disallowed on virtual columns
54013. 0000 -  "INSERT operation disallowed on virtual columns"
*Cause:    Attempted to insert values into a virtual column
*Action:   Re-issue the statment without providing values for a virtual column
*/

--�ٽ� ���̺� ���� �־�ô�
INSERT INTO vtbl_1(no1, no2) VALUES (1,2);

--�����÷��� �ݿ��Ǿ����� Ȯ���մϴ�
UPDATE vtbl_1 SET no1=10 ; --������Ʈ�մϴ�
select * from VTBL_1; --������Ʈ ���ص� �����׿� ����

--���ο� �����÷��� �߰��մϴ�
ALTER TABLE vtbl_1 ADD (no4 GENERATED ALWAYS AS ((no1*12)+no2)) ;

--���̺��� ���� �÷� ������ ��ȸ�մϴ�.
SELECT column_name, data_type, data_default
FROM user_tab_columns WHERE table_name = 'VTBL_1'
ORDER BY column_id ;

--�������Ǽ����ϱ�
--�⺻(���̺� ������ ����)
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

--���(���̺� ������ ����) - !!���������� �������̸� ','������ �ȵ�
CREATE TABLE emp4
( no NUMBER(4) PRIMARY KEY ,
name VARCHAR2(10) NOT NULL,
jumin VARCHAR2(13) NOT NULL UNIQUE ,
area NUMBER(1) CHECK ( area < 5 ),
deptno VARCHAR2(6) REFERENCES dept2(dcode)
) ;
--------------------------------------------------------------------
--�ǽ��սô�
create table dept(
  deptno NUMBER(3) PRIMARY KEY,
  dname VARCHAR2(30) UNIQUE not NULL
);

INSERT into dept VALUES(101,'����');
INSERT into dept VALUES(102,'����');
INSERT into dept VALUES(103,'�濵');

--Ȯ�ο� ��
--INSERT into dept(DEPTNO)VALUES(104);
--INSERT into dept VALUES(101,'�İ�');

INSERT into dept VALUES(104,'�İ�');

select * from dept;


create table student(
  sno NUMBER PRIMARY KEY,
  sname VARCHAR2(10) not NULL,
  sgrade NUMBER(1) CHECK (sgrade in(1,2,3,4)),
  sdeptno NUMBER(3) REFERENCES dept(deptno)
);

desc student;

insert into student values(1,'ȫ�浿',1,101);
--insert into student values(1,'��ö��',1,101); --PRIMARY KEY������ ������ ������
insert into student values(2,'��ö��',1,101);

--insert into student(sno, SGRADE, SDEPTNO) values(3,1,101);--sname�� not null��
--insert into student values(3,'���ؿ�',5,101);--sgrade�� �������� ���� : 1~4
--insert into student values(3,'���ؿ�',2,105); 
--sdeptno�� dept���̺� deptno�� �����ϴµ� �װ��� ���� ������ �ȳ־���
insert into student values(3,'���ؿ�',4,103); 
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
  eposition VARCHAR2(30) CHECK (eposition in('���','�븮','����','����')),
  edeptno NUMBER(3) REFERENCES dept(deptno)
);

desc EMP;

INSERT into emp_dept values(101,'������',1);
INSERT into emp_dept values(102,'��ȹ��',2);
INSERT into emp_dept values(103,'ȫ����',1);

DELETE FROM EMP_DEPT WHERE deptno=101;
select * from EMP_DEPT ORDER BY 1;

insert into emp values(1, '�ڿ���', '���', 101);
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
INSERT into PRODEUCT values('p002', '������', 150);
INSERT into PRODEUCT values('p003', '�����', 200);

select * from PRODEUCT;

insert into P_SALSE(sno, pcode, count) VALUES('s001','p001', 5);
insert into P_SALSE(sno, pcode, count) VALUES('s002','p001', 10);
insert into P_SALSE(sno, pcode, count) VALUES('s003','p003', 8);

select * from P_SALSE;
-------------------------------------------------------------------
--ALTER (��������)
--�� Į�� �߰�
ALTER table emp_dept add(Dline number(4));
select * from EMP_DEPT;

alter table emp add(ehiredate date DEFAULT SYSDATE);
select * from emp;

alter table PRODEUCT add(pro_com VARCHAR2(30));
select * from PRODEUCT;


--Į������
alter table PRODEUCT drop column pro_com;
select * from PRODEUCT;
--�����ϰ� �ִ� Į�� ����� (�������~)
--alter table PRODEUCT drop column pcode CASCADE constraints;

--Į���� ����
alter table p_salse RENAME COLUMN count TO cnt;
alter table p_salse RENAME COLUMN s_date TO sales_dete;

select * from P_SALSE;

--���̺� �� ����
RENAME p_salse TO prodeuct_salse;
select * from prodeuct_salse;

--Į�� ������ ũ�� ����
desc PRODEUCT;
alter table prodeuct modify(pname VARCHAR2(20));
alter table prodeuct add(pro_com VARCHAR2(10));
alter table prodeuct MODIFY (pro_com number(4)); --�����Ͱ� ��������� ����������


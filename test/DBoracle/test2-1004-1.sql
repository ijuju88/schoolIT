select * from tabs;

drop table student;
drop table dept;

create table dept(
  deptno number(3) PRIMARY KEY,
  dname varchar2(20) not null UNIQUE,
  loc varchar2(30)
);

insert into dept VALUES(101,'컴공','1호관');
insert into dept VALUES(102,'영문','2호관');
insert into dept VALUES(103,'일어','3호관');

create table student(
  sno number(4) PRIMARY KEY,
  name varchar2(20) not null,
  grade number(1) CHECK(grade in(1,2,3,4)),
  deptno number(3) REFERENCES dept(deptno)
);

insert into student VALUES(1001, '윤주현',1, 101);

select * from STUDENT;

alter table student add(tel VARCHAR2(15));
alter table student RENAME COLUMN tel to phone;
RENAME dept to department;
select * from DEPARTMENT;
alter table student MODIFY(phone varchar2(20));

alter table department add CONSTRAINT dept_loc_uk UNIQUE(loc);

-------------------------------------------------------------------

create table professor(
  pno number(3),
  name VARCHAR2(20),
  position VARCHAR2(30),
  deptno number(3)
);

--기본키 추가
alter table professor add CONSTRAINT pnof_pno_pk PRIMARY KEY(pno);
--not null
alter table professor modify(name VARCHAR2(20) not null);
--UNIQUE
alter table professor add CONSTRAINT pnof_name_uk UNIQUE(name);
--fk
alter table professor add CONSTRAINT 
pnof_deptno_fk FOREIGN key(deptno) references department(deptno);

desc PROFESSOR;
------------------------------------------------------------------
drop table e_dept;
create table e_dept(
  dcode number(3),
  dname VARCHAR2(20),
  line VARCHAR2(4)
);
alter table e_dept add CONSTRAINT edeptf_dcode_pk PRIMARY KEY(dcode);
alter table e_dept add CONSTRAINT edeptf_dname_uk UNIQUE(dname);
alter table e_dept MODIFY (line VARCHAR2(4) NOT NULL);

desc e_dept;

create table emp(
  eno NUMBER(4) PRIMARY KEY,
  ename VARCHAR2(20) not null,
  job VARCHAR2(20) not null,
  dcode number(3)
);
alter table emp add CONSTRAINT empf_dcode_fk FOREIGN key(dcode) 
references e_dept(dcode);

alter table emp read only; --읽기전용
alter table emp read write; --쓰기전용

insert into e_dept VALUES(101, '컴공','A111');
insert into emp VALUES(100,'홍길동','프로그래머', 101);
select * from emp;
--View
--계정에 권한에 있어야함
--CONN / AS SYSDBA; GRANT CREATE VIEW TO scott ;

--생성
create or replace view v_prof as 
select profno, name, email, hpage from PROFESSOR;

SELECT * FROM v_prof ;

--데이터가 없어서 인덱스를 생성할수 없습니다
CREATE INDEX idx_v_prof_name ON v_prof(name);

--Complex View(조인으로 만들기)
create or replace view v_prof_dept as
select p.profno "교수번호", p.name "교수명", d.dname "소속학과명"
 FROM professor p , department d WHERE p.deptno = d.deptno ;
 
--INLINE View - 일회용 뷰
SELECT d.dname "학과명" , s.max_height "최대키" , s.max_weight "최대몸무게"
 FROM ( SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight
 FROM student GROUP BY deptno1) s , department d WHERE s.deptno1 = d.deptno ;
 
/*
Student 테이블과 department 테이블을 사용하여 학과별로 가장 키가 큰 학생들
의 이름과 키 , 학과이름을 Inline View 를 사용하여 아래와 같이 출력
*/
select d.dname 학과명, a.max_height 최대키, s.name 학생이름, s.height 키 from 
(select deptno1, max(height)max_height from student group by deptno1)a, student s, department d
where s.deptno1=d.deptno and a.max_height=height;
 
select * from student;

select d.dname, e.ename, e.sal from emp e, dept d
where(e.deptno,e.sal) in
(select deptno, max(sal) from emp group by deptno)
and e.deptno=d.deptno;

select d.dname, e.ename, e.sal from emp e, dept d
where(e.deptno, e.sal) in
(select deptno, max(sal) from emp group by deptno)
and e.deptno=e.deptno;

select d.dname 부서명, max_sal 최대급여, e.ename 사원명, e.sal 급여
from(select deptno, max(sal) max_sal from emp group by deptno)a,
emp e, dept d where e.deptno=d.deptno and a.max_sal=e.sal;

select d.dname, e.ename, e.sal from emp e, dept d where(e.sal)>
(select avg(sal) from emp e2 where e.deptno=e2.deptno)
and e.deptno=d.deptno;

select d.dname 부서명, round(avg_sal) 평균급여, e.ename 사원명, e.sal 급여 
from(select deptno, avg(sal) avg_sal from emp group by deptno)a, emp e, dept d
where e.sal>a.avg_sal and a.deptno=e.deptno and e.deptno=d.deptno;

select s.grade 학년, s.name 이름, s.height 키, a.avg_height 평균키
from(select grade, avg(height) avg_height from student group by grade)a,
student s
where s.height>a.avg_height and a.grade=s.grade;

--------------------------------------------------------------------

--SEQUENCE - 연속번호
/*
 ┌────────────────────────────────────────────────────────┐
 	CREATE SEQUENCE sequence_name
	[INCREMENT BY n] <- 시퀀스 번호의 증가 값으로 기본값은 1
	[START WITH n] <- 시퀀스 시작번호로 기본값은 1
	[MAXVALUE n | NOMAXVALUE] <- 생성 가능한 시퀀스 최대값
	[MINVALUE n | NOMINVALUE] <-CYCLE일 경우 새로 시작되는 값
	[CYCLE | NOCYCLE] <- 시퀀스 번호를 순환 사용할 것인지 지정
	[CACHE n | NOCACHE] <- 시퀀스 생성속도를 개선하기 위해 캐싱여부 지정
└────────────────────────────────────────────────────────┘
 */
/*
 SEQUENCE 명: seq_jumun_no
 시작 번호: 1000
 끝 번 호: 1010
 증 가 값: 1
 반복 되고 캐싱은 2개씩 되도록 하세요.*/

CREATE SEQUENCE seq_jumun_no INCREMENT BY 1 START WITH 1000 
MAXVALUE 1010 MINVALUE 990 CYCLE CACHE 5 ;

--예제용 테이블
CREATE TABLE jumun( j_no number(4) ,j_name varchar2(10)) ;

--넣기 --그냥 같은거 10개이상 만들랍니다
insert into jumun values(seq_jumun_no.NEXTVAL,'AAAA');

select * from jumun;

BEGIN FOR i in 1..11 LOOP INSERT INTO jumun V
ALUES(seq_jumun_no.NEXTVAL ,
 DBMS_RANDOM.STRING('A',4) ); END LOOP;
 COMMIT 
 END 
--
CREATE TABLE jumun3( j_no number(4) ,j_name varchar2(10)) ;
insert into jumun3 values(seq_jumun_no1.NEXTVAL,'AAAA');
commit

/* cmd에서
 C:\Users\it>sqlplus sys/ as sysdba

SQL*Plus: Release 11.2.0.2.0 Production on 수 10월 12 12:16:47 2016

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

Enter password:

Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL> shutdown abort;  --오라클종료
ORACLE instance shut down.

SQL> startup; --오라클시작
ORACLE instance started.

Total System Global Area 1068937216 bytes
Fixed Size                  2260048 bytes
Variable Size             696255408 bytes
Database Buffers          364904448 bytes
Redo Buffers                5517312 bytes

*/

insert into jumun3 values(seq_jumun_no1.NEXTVAL,'AAAA');
select * from jumun3;

--삭제
DROP SEQUENCE seq_jumun_no1 ;

----------------------------------------------------------------
--SYNONYM (동의어) - 긴테이블에 씀
/*
CREATE [PUBLIC] SYNONYM synonym이름
FOR [schema.]대상객체 ;

권한이 있어야함
GRANT create (public) synonym TO scott ;
*/
create public synonym d2 for department;
select * from d2;


CREATE public SYNONYM e2 FOR emp2 ;
--SYNONYM 조회하기 --공개는 안나옴
SELECT synonym_name, table_owner , table_name
 FROM user_synonyms;
 WHERE table_name='department' ;
 
DROP public SYNONYM d2 ;

--Cartesian Product - 두 테이블 행수를 모두 곱한 값의 결과가 만들어 짐
/*
테이블1  테이블2   결과
------- -------  ---------
  A 1    1 가     A 1 1 가
  B 2    2 나     A 1 2 나
                 B 2 1 가
                 B 2 2 나

Oracle Join 문법
┌--------------------------┐
│SELECT e.ename , d.dname  │
│FROM emp e, dept d ;      │
└--------------------------┘
ANSI Join 문법 --표준쿼리문 (모든 sql에서 사용가능)
┌--------------------------------┐
│SELECT e.ename , d.dname        │
│FROM emp e CROSS JOIN dept d ;  │
└--------------------------------┘
*/
select e.ename, e.deptno ,d.deptno, d.dname
from emp e, dept d;

select e.ename, e.deptno ,d.deptno, d.dname
from emp e CROSS JOIN dept d;

--EQUI Join (등가 Join) - 양쪽 테이블에 같은 조건이 존재할 경우의 값만 가져 옴
/*
Oracle Join 문법
┌-------------------------------------------------------------┐
│SELECT s.name "학생이름", s.deptno1 "학과번호", d.dname "학과명" │
│FROM student s, department d                                 │
│WHERE s.deptno1=d.deptno;                                    │
└-------------------------------------------------------------┘
ANSI Join 문법
┌-------------------------------------------------------------┐
│SELECT s.name "학생이름", s.deptno1 "학과번호", d.dname "학과명" │
│FROM student s JOIN department d                             │
│ON(s.deptno1=d.deptno);                                      │
└-------------------------------------------------------------┘
*/
select s.name, s.profno, p.name
from student s, professor p where s.PROFNO=p.PROFNO;

select s.name, s.profno, p.name
from student s JOIN professor p on(s.PROFNO=p.PROFNO);

--실습하기
select s.name, p.name
from student s JOIN PROFESSOR p on(s.PROFNO=p.PROFNO);

--3개의 테이블 조인하기
/*
학생 테이블(student)과 학과 테이블(department) , 교수 테이블(professor) 
을 Join하여 학생의 이름과 학과이름, 지도교수 이름을 출력
*/
select s.name 학생이름, d.dname 학과이름, p.name 교수이름
 from student s, DEPARTMENT d, PROFESSOR p
 where s.DEPTNO1=d.DEPTNO and d.DEPTNO=p.DEPTNO;
 
select s.name 학생이름, d.dname 학과이름, p.name 교수이름
 from student s JOIN DEPARTMENT d on(s.DEPTNO1=d.DEPTNO)
 JOIN PROFESSOR p on(d.DEPTNO=p.DEPTNO);
 
/*
emp2 테이블과 p_grade 테이블을 조회하여 사원의 이름과 
직급, 현재 연봉, 해당 직급의 연봉의 하한금액과 상한 금액을 출력
*/
select e.NAME 사원이름, e.POSITION 현재직급, e.PAY 현재연봉,
 pg.s_PAY 하한금액, pg.E_PAY 상한금액
from emp2 e, p_grade pg 
where e.POSITION=pg.POSITION;

select e.NAME 사원이름, e.POSITION 현재직급, e.PAY 현재연봉,
 pg.s_PAY 하한금액, pg.E_PAY 상한금액
 from emp2 e JOIN P_GRADE pg on(e.POSITION=pg.POSITION);

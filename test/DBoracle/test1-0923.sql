DESC EMP;
SELECT * FROM tabs;
SELECT * FROM emp;
/*emp테이블 중에서 name, job, sal 필드만 조회됩니다*/
SELECT ename, job, sal FROM emp;
/*job중에 CLERK랑 일치하는걸 찾습니다*/
SELECT * FROM emp WHERE job='CLERK';
/*데이터 값+해서 출력 - 결합연산자||*/
SELECT ename||'사원의 급여는' ||sal|| '입니다' FROM emp;
SELECT * FROM student;
SELECT name||'학생의 키는'||HEIGHT ||'이고 몸무게는' || weight ||'입니다.' "이름_키_몸무게" FROM student;
/*별칭사용하기*/
SELECT studno AS "학번", name "이름", height 키 FROM student;
SELECT empno 사원번호, ename 사원명, job 직업 FROM emp;
SELECT DEPTNO AS "부서#", dname AS "부서명", loc AS "위치" FROM dept;
SELECT DISTINCT deptno FROM emp;
/*이름+(~교수)로 출력하기*/
select name|| '('||position||')' from professor;
/*수식*/
select ename, sal, sal+100, sal+100/2, (sal+100)/2 from emp;
select ename, sal, sal*12+comm from emp;
 /*emp테이블의 ename, sal, sal*12+comm인 값출력
   이런 경우 comm값이 null인 값은 더해도 null로 출력되는 현상이 나옵니다
   그래서 아래와 같이 수정합니다
*/

/*조건검색 where*/
select ename, sal, sal*12+comm from emp where comm is not NULL; /*그중에 comm값이 null이 아닌값만 출력함*/
select ename, job, deptno from emp where deptno=10;
select name, position from professor where POSITION='정교수';
/*날짜 검색하기 - 입사일이 2000-01-01이전인 사람만 출력*/
select * from PROFESSOR where HIREDATE<'2000-01-01';

select name, height from STUDENT where HEIGHT>=180;
select name, height from STUDENT where HEIGHT BETWEEN 175 and 180; /*HEIGHT>=175 and HEIGHT<=180*/
select name, deptno1 from STUDENT where deptno1 in(101,201);/*deptno1=101 or deptno1=201*/
select name, height, weight from student where  height>=180 and weight<=70;
select name, height, weight from student where height<170 or weight>75;

select name, deptno1 from student where name Like '김%';
select name, position form from professor where POSITION Like'%교수';

select name,grade, height from STUDENT where grade=4 and height>170;
select name, HEIGHT, GRADE, WEIGHT from student where WEIGHT>=80 or GRADE=1;
select name, GRADE, HEIGHT, WEIGHT from student 
where grade=2 and (HEIGHT>180 and WEIGHT>170);

select name, GRADE, HEIGHT, WEIGHT from student
where grade=2 and (HEIGHT>180 or WEIGHT>170);

select * from Professor where name BETWEEN '자'and '차';

/*정렬하기 order by*/
select name from student order by name;
select ename, deptno, sal from emp order by deptno,sal desc;

/*연습문제*/
select name, pay, position from emp2 where pay>=50000000;

select name"이름", pay"급여", pay*0.5 as "보너스", pay*0.1 as "세금" from emp2;

select * from emp2 where hobby in('운동', '자전거타기', '마라톤','등산');

select name, hpage from PROFESSOR where id like 's%';

select name, HPAGE from PROFESSOR where HPAGE is not null;

select name, POSITION, HIREDATE from PROFESSOR 
where HIREDATE>'1990-01-01' and POSITION in('정교수','조교수');

select name, pay from emp2 where pay between 30000000 and 50000000;

select name, id, POSITION from PROFESSOR 
order by Position, id desc;

select name,HEIGHT, WEIGHT from student where HEIGHT>=180 and WEIGHT<=70 order by name asc;

select ename, job, sal from emp where job='SALESMAN' order by sal desc;
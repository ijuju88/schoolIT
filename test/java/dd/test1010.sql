--조인 복습 
--칼럼명이 다르다면 p., d. 등 을 생략할수 있음
select name, d.dname, pay from professor p, department d
where p.deptno=d.deptno;

select s.name, p.name from student s, professor p
where s.profno=p.profno;

--Sub Query
/*
 sql 작성시 여러 조건을 한꺼번에 나오는것
┌──────────────────────────────────────┐
 SELECT select_list
	FROM table 또는 View
	WHERE 조건 연산자 ( SELECT select_list
	FROM table
	WHERE 조건 ) ;
└──────────────────────────────────────┘
*/

select * from student;
select * from professor;
select ename, sal from emp where sal>
(select sal from emp where ename='SCOTT');

select name, position from professor where position=
(select position from professor where name='조인형');

/*
Student 테이블과 department 테이블을 사용하여 이윤나 학생과 1 전공(deptno1)이 
동일한 학생들의 이름과 1전공 이름을 출력하세요
*/
select s.name, d.dname from student s, department d where
s.deptno1=d.deptno and s.deptno1=
(select deptno1 from student where name='이윤나');

/*
Professor 테이블에서 입사일이 송도권 교수보다
 나중에 입사한 사람의 이름과 입사일, 학과명을 출력
 */
select p.name, p.hiredate, d.dname 
from professor p, department d
where p.deptno=d.deptno and p.hiredate>=
(select hiredate from professor where name='송도권');

/*
 Student 테이블에서 1 전공(deptno1)이 101번 인 학과학과의 
 평균 몸무게보다 몸무게가 많은 학생들의 이름과 몸무게를 출력*/
select name, weight from student where weight>(
select avg(weight) from student where deptno1=101); 

/*
 Professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중에서 조인형 교수보다
월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요
 */
select name, pay, hiredate from professor where hiredate=
(select hiredate from professor where name='심슨')
and pay<(select pay from professor where name='조인형');

--다중 행 Sub Query
/*
 IN   -같은 값을 찾음
>ANY  -최소값을 반환함(하나) : >ANY(10,20,30) 이면  10보다 크면 됨
<ANY  -최대값을 반환함(하나) : <ANY(10,20,30) 이면  30보다 작으면 됨
<ALL  -최소값을 반환함           : >ALL(10,20,30) 이면  10,20,30(모두)보다 크면 됨
>ALL  -최대값을 반환함           : <ALL(10,20,30) 이면  10,20,30(모두)보다 작으면 됨
EXIST -Sub Query 의 값이 있을 경우 반환함 
 */

/*
Emp2 테이블과 Dept2 테이블을 참조하여 근무지역(dept2 테이블의 area 컬럼)
이 서울 지사인 모든 사원들의 사번과 이름, 부서번호를 출력하세요
*/
select * from dept2;
select empno, name, deptno from emp2 where deptno in
(select dcode from dept2 where area='서울지사');

/*
 Emp2 테이블을 사용하여 전체 직원 중 과장 직급의 최소 연봉자보다 
 연봉이 높은 사람의 이름과 직급 , 연봉을 출력하세요. 
 단 연봉 출력 형식은 아래와 같이 천 단위 구분기호와 원 표시
 */
select name 이름, position 직급, pay 연봉 from emp2
where pay>any(select pay from emp2 where position='과장');

/*
Student 테이블을 조회하여 전체 학생 중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 
 학생보다 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요
*/
select name, grade, weight from student where weight<all
(select weight from student where grade=4);

--다중 칼럼 Sub Query
/*Student 테이블을 조회하여 각 학년별로 최대키를 가진 학생들의 학년과 이름과 키를 출력*/
select grade, name, height from student where(grade, height)
in(select grade, Max(height) from student group by grade) 
order by 1;

/*
Professor 테이블을 조회하여 각 학과별로 입사일이 가장 오래된 교수의 
 교수번호와 이름, 학과명을 출력하세요. (학과이름순으로 오름차순 정렬하세요)*/
select * from  DEPARTMENT;
select profno 교수번호, name 교수명, hiredate 입사일, dname 학과명
from professor p, department d where p.deptno=d.deptno
and(p.deptno, p.hiredate) in
(select deptno, Min(hiredate) from professor group by deptno)
order by 4;
/*
 Emp2 테이블을 조회하여 직급별로 해당 직급에서 최대 연봉을 받는 
 직원의 이름과 직급, 연봉을 출력. 연봉순으로 오름차순 정렬
*/
select name, position, pay from emp2 where(position, pay)
in(select position, Max(pay) from emp2 group by position)
order by pay;

/*
Dept2,Emp2 테이블을 조회하여 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 
 가장 적은 부서의 평균 연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력
*/
select d.dname 부서명, e.name 사원명, e.pay 연봉 from
dept2 d, emp2 e where d.dcode=e.deptno and pay<all
(select avg(pay) from emp2 e group by deptno);

--상호 연관 Sub Query
/*
Main Query 값을 Sub Query에 주고 Sub Query를 수행한 후 
그 결과 값을 다시 Main Query로 반환
*/

/*
Emp2 테이블을 조회해서 직원 들 중에서 자신의 직급의 평균연봉과 
같거나 많이 받는 사람들의 이름과 직급, 현재 연봉을 출력
*/
select name 사원이름, position 직급, pay 급여 from emp2 a where pay>=
(select avg(pay) from emp2 b where a.position= b.position);

select grade, name, height from student a where height>=
(select avg(height) from student b where a.height=b.height);

--스칼라 서버 쿼리
--select 절에 오는 서버 쿼리로 한번에 결과를 1행씩 반환(데이터명이 적을때는 빠름)
select name 사원이름,(select dname from dept2 d
where e.deptno=d.dcode) 부서이름 from emp2 e;

select name 학생명,(select dname from department d where
d.deptno=s.deptno1) 학과명 from student s;

--연습문제
select e.name, d.dname, e.position from emp2 e, dept2 d
where e.deptno=d.dcode and position =
(select position from emp2 where name='최일도');

select name, pay from emp2 
where pay>(select avg(pay) from emp2 where 
deptno=(select dcode from dept2 where dname='총무팀'));

select name, position, pay from emp2 where pay>any
(select min(pay) from emp2 where position='부장'); 

select name, position, pay from emp2 where(position, pay)
in(select position, avg(pay) from emp2 group by position);

select e.name, d.dname, e.pay from emp2 e, dept2 d 
where(e.deptno, pay) in(select deptno, max(pay) 
from emp2 group by deptno);
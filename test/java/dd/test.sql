--Cartesian Product
/*
Oracle Join 문법
SELECT e.ename , d.dname
FROM emp e, dept d ;

ANSI Join 문법
SELECT e.ename , d.dname
FROM emp e CROSS JOIN dept d ;
*/

--등가JOIN 
--양쪽 테이블에 같은 조건이 존재할 경우의 값만 가져 옴
/*
 학생 테이블 (student) 과 학과 테이블 (department) 테이
블을 사용하여 학생이름, 1 전공학과번호(deptno1) , 1전공 학과
이름을 출력하세요.

 Oracle Join 구문
SELECT s.name "학생이름", s.deptno1 "학과번호", d.dname "학과명"
FROM student s, department d
WHERE s.deptno1=d.deptno;

 Ansi Join 구문
SELECT s.name "학생이름", s.deptno1 "학과번호", d.dname "학과명"
FROM student s JOIN department d
ON(s.deptno1=d.deptno);
  */

/*
학생 테이블 (student) 과 교수 테이블 (professor) 을 join 하여 학생의 이름
과 지도교수번호, 지도교수 이름을 출력
*/
SELECT s.name "학생이름", s.profno "교수번호", p.name "교수이름"
FROM student s, professor p WHERE s.profno=p.profno;

SELECT s.name "학생이름", s.profno "교수번호", p.name "교수이름"
FROM student s JOIN professor p ON( s.profno=p.profno);

/*
 학생 테이블(student)과 학과 테이블(department) , 교수 테이블(professor) 을
Join하여 학생의 이름과 학과이름, 지도교수 이름을 출력
*/

SELECT s.name "학생이름" , d.dname "학과이름" , p.name "교수이름"
FROM student s , department d , professor p
WHERE s.deptno1 = d.deptno
AND s.profno = p.profno ;

SELECT s.name "학생이름" , d.dname "학과이름" , p.name "교수이름"
FROM student s JOIN department d
ON s.deptno1 = d.deptno
JOIN professor p ON s.profno = p.profno ;

/*
emp2 테이블과 p_grade 테이블을 조회하여 사원의 이름과 직급, 현재 연봉, 해
당 직급의 연봉의 하한금액과 상한 금액을 출력
*/

SELECT e.name "사원이름" ,
e.position "현재직급" , e.pay "현재연봉",
p.s_pay "하한금액" , p.e_pay "상한금액"
FROM emp2 e , p_grade p WHERE e.position = p.position ;

SELECT e.name "사원이름" ,
e.position "현재직급" , e.pay "현재연봉",
p.s_pay "하한금액" , p.e_pay "상한금액"
FROM emp2 e JOIN p_grade p ON e.position = p.position ;

/*
1전공(deptno1)이 101번인 학생들의 학생 이름과 지도교수 이름을 출력
*/

select s.name 학생이름, p.name 지도교수명 
from STUDENT s, PROFESSOR p
where s.profno=p.profno and s.deptno1=101;

select s.name 학생이름, p.name 지도교수명 
from STUDENT s join PROFESSOR p
on s.profno=p.profno and s.deptno1=101;

--Non-Equi Join (비등가 Join) 점수등 사이값~~
/*
Gogak 테이블과 gift 테이블을 Join하여 고객의 마일리지 포인트별로 받을 수
있는 상품을 조회하여 고객의 이름과 상품 명을 출력
*/
select * from GOGAK;
select * from GIFT;

select go.gname 고객명, go.point point, gi.gname 상품명
from GOGAK go, GIFT gi where go.point between gi.g_start and gi.g_end;

select go.gname 고객명, go.point point, gi.gname 상품명
from GOGAK go join GIFT gi on go.point between gi.g_start and gi.g_end;

--조회한 상품의 이름과 필요 수량이 몇 개 인지
select gi.gname 상품명, count(*) 필요수량 from GOGAK go, GIFT gi
where go.point between gi.g_start and g_end group by gi.gname;
/*
 Student 테이블과 exam_01테이블 , hakjum 테이블을
조회하여 학생들의 이름과점수와 학점을 출력
 */

select * from HAKJUM;

select s.name 학생이름, e.total 점수 , h.grade 학점
from STUDENT s, EXAM_01 e, HAKJUM h
where s.studno=e.studno and e.total between h.min_point and h.max_point;

select s.name 학생이름, e.total 점수 , h.grade 학점
from STUDENT s join EXAM_01 e on s.studno=e.studno
join HAKJUM h  on e.total between h.min_point and h.max_point;

/*
Gogak 테이블과 gift 테이블을 Join하여 고객이 자기 포인트보다 낮은 포인트의
상품 중 한가지를 선택할 수 있다고 할 때 산악용 자전거를 선택할 수 있는 고객명
과 포인트, 상품명을 출력
*/

SELECT go.gname "고객명" ,go.point "POINT" ,gi.gname "상품명"
FROM gogak go , gift gi
WHERE gi.g_start <= go.point AND gi.gname ='산악용자전거';

SELECT go.gname "고객명" ,go.point "POINT" ,gi.gname "상품명"
FROM gogak go join gift gi on gi.g_start <= go.point 
AND gi.gname ='산악용자전거';
/*
Emp 2 테이블과 p_grade 테이블을 조회하여 사원들의 이름과 나이,
현재 직급 , 예상 직급 을 출력하세요. 예상 직급은 나이로 계산하며
해당 나이가 받아야 하는 직급을의미합니다. 나이는 오늘(sysdate)
를 기준으로 하되 trunc 로 소수점이하는 절삭해서 계산
*/

select e.name 이름, trunc((sysdate-e.birthday)/365,0) 현재나이,
e.position 현재직급, g.position 예상직급 from EMP2 e, P_GRADE g
where trunc((sysdate-e.birthday)/365,0) between g.s_age and g.e_age;

--OUTER Join (아우터 조인) vs INNER Join (이너 조인)
/*
Student 테이블과 Professor 테이블을 Join하여 학생이름과 지도교수 이름을 출
력하세요. 단 지도교수가 결정되지 않은 학생의 명단도 함께 출력
*/

--OUTER Join
SELECT s.name "학생이름", p.name "교수이름"
FROM student s, professor p
WHERE s.profno = p.profno(+) ;

SELECT s.name "학생이름", p.name "교수이름"
FROM student s left outer join professor p
on s.profno = p.profno ;

SELECT s.name "학생이름", p.name "교수이름"
FROM student s, professor p
WHERE s.profno(+) = p.profno ;

SELECT s.name "학생이름", p.name "교수이름"
FROM student s right outer join professor p
on s.profno = p.profno ;

--**양쪽 아웃조인 --;
/*
 --오라클에는 양쪽이 없기 때문에 이렇게 적습니다
 SELECT s.name "학생이름", p.name "교수이름"
FROM student s , professor p
WHERE s.profno(+) = p.profno
UNION
SELECT s.name "학생이름", p.name "교수이름"
FROM student s , professor p
WHERE s.profno = p.profno(+) ;

--ANSI 문법
SELECT s.name "학생이름", p.name "교수이름"
FROM student s FULL OUTER JOIN professor p
ON s.profno = p.profno ;
 */

SELECT s.name "학생이름", p.name "교수이름"
FROM student s FULL OUTER JOIN professor p
ON s.profno = p.profno ;

--SELF Join 경영지원부의 상위부서는사장실이다 ~~
select a.ename 부서명, b.ename 상위부서명 from emp a, emp b
where a.mgr=b.empno;

select * from dept2;

select d.dname , avg(e.total)
from STUDENT s,DEPARTMENT d, EXAM_01 e
where s.deptno1 =d.deptno and s.studno=e.studno
group by d.dname;

select d.dname 학과명, h.grade 학점, count(*)인원수
from STUDENT s,DEPARTMENT d, EXAM_01 e, HAKJUM h
where s.deptno1 =d.deptno and s.studno=e.studno
and (e.total between h.min_point and h.max_point)
group by d.dname, h.grade;

select s.name 학생이름, d.dname 학과명, p.name 교수명
from STUDENT s,DEPARTMENT d, PROFESSOR p
where s.deptno1=d.deptno and s.profno=p.profno(+)
and d.dname='컴퓨터공학과';

select a.dname 부서명, b.dname 상위부서명, b.area 상위부서위치
from dept2 a, dept2 b where a.pdept=b.dcode(+);


select deptno, job, count(*), sum(sal), round(avg(sal)) from emp 
GROUP BY deptno, job;
--GROUP BY cube(deptno, job) 소계+합;
--GROUP BY ROLLUP(deptno, job) 소계;
--GROUP BY DEPTNO HAVING avg(sal)>=2000;

select deptno1, LISTAGG(name, ', ') WITHIN GROUP (ORDER BY name)
from STUDENT GROUP BY DEPTNO1;

/*Professor 테이블을 사용하여 교수 중에서 급여(Pay)와 보너스(bonus)를 합
친 금액이 가장 많은 경우와 가장 적은 경우 , 평균 금액을 구하세요. 단 보너스
가 없을 경우는 보너스를 0 으로 계산하고 출력 금액은 모두 소수점 첫째 자리
까지만 나오게 하세요.*/
select max(PAY+nvl(BONUS,0)) MAX, min(PAY+nvl(BONUS,0)) MIN, 
to_char(avg(PAY+nvl(BONUS,0)),'999.9') AVG from PROFESSOR;

/*Professor 테이블을 사용하여 교수 중에서 급여(Pay)와 보너스(bonus)를
합친 금액이 가장 많은 경우와 가장 적은 경우 , 평균 금액을 구하세요. 단 보
너스가 없을 경우는 급여를 0 으로 계산하고 출력 금액은 모두 소수점 첫째
자리까지만 나오게 하세요.*/
select max(NVL2(BONUS,pay+BONUS, pay*0)) MAX, 
min(NVL2(BONUS,pay+BONUS, pay*0)) MIN, 
ROUND(avg(NVL2(BONUS,pay+BONUS, 0)),1)AVG from PROFESSOR;

/*Student 테이블의 birthday 칼럼을 사용하여 아래 화면처럼 월별로 태어난
인원수를 출력하세요.*/

select count(*) 합계, 
count(decode(SUBSTR(jumin,3,2),01,0)) "1월",
count(decode(SUBSTR(jumin,3,2),02,0)) "2월",
count(decode(SUBSTR(jumin,3,2),03,0)) "3월",
count(decode(SUBSTR(jumin,3,2),04,0)) "4월",
count(decode(SUBSTR(jumin,3,2),05,0)) "5월",
count(decode(SUBSTR(jumin,3,2),06,0)) "6월",
count(decode(SUBSTR(jumin,3,2),07,0)) "7월",
count(decode(SUBSTR(jumin,3,2),08,0)) "8월",
count(decode(SUBSTR(jumin,3,2),09,0)) "9월",
count(decode(SUBSTR(jumin,3,2),10,0)) "10월",
count(decode(SUBSTR(jumin,3,2),11,0)) "11월",
count(decode(SUBSTR(jumin,3,2),12,0)) "12월"
from STUDENT;

/*Student 테이블의 tel 칼럼을 참고하여 아래와 같이 지역별 인원수를 출력.
(02 ?서울 , 031 ? 경기 , 051 ? 부산 , 052 ? 울산 , 053 ? 대구 , 055 ? 경남)
*/

select count(*) 합계, 
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),02,0))"서울",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),031,0))"경기",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),051,0))"부산",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),052,0))"울산",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),053,0))"대구",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),055,0))"경남"
from STUDENT;

/*Emp 테이블을 사용하여 아래의 화면과 같이 부서별로 직급별로 급여 합계
결과를 출력하세요. 먼저 아래의 두 건의 데이터를 입력 하신 후 작업하세요.*/
insert into emp (empno , deptno , ename , sal)
values (1000,10,'홍길동',3600) ;

insert into emp (empno , deptno , ename , sal)
values (2000,30,'일지매',3000);

select deptno, 
sum(DECODE(job,'CLERK',sal, 0)) CLERK,
sum(DECODE(job,'MANAGER',sal, 0)) MANAGER,
sum(DECODE(job,'PRESIDENT',sal, 0)) PRESIDENT,
sum(DECODE(job,'ANALYST',sal, 0)) ANALYST,
sum(DECODE(job,'SALESMAN',sal, 0)) SALESMAN,
sum(nvl2(job,sal, 0)) 합계
from emp group by cube(deptno) order by 1;

--LAG 함수(이전행의 값을 가져올때)
/*
LAG(출력할 컬럼명 , OFFSET , 기본 출력값) 
OVER (Query_partition구문 , ORDER BY 정렬할 컬럼)
*/
select name,HIREDATE, pay, 
LAG(pay, 1, 0) OVER (ORDER BY HIREDATE) lag from PROFESSOR;

select name,HIREDATE, pay, 
LAG(pay, 3, 2) OVER (ORDER BY HIREDATE) lag from PROFESSOR;
--LEAD 함수 (이후의 값을 가져올때)
select name,HIREDATE, pay, 
LEAD(pay, 1, 0) OVER (ORDER BY HIREDATE) lag from PROFESSOR;

select name,HIREDATE, pay, 
LEAD(pay, 3, 2) OVER (ORDER BY HIREDATE) lag from PROFESSOR;

--RANK 함수
select profno, name, pay, 
RANK() OVER(ORDER BY pay) RANK, RANK() OVER(ORDER BY pay DESC) RANK_DESC
from PROFESSOR;

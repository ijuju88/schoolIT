--count 함수
select count(*), count(hpage) from PROFESSOR;

--sum 함수
select count(bonus), sum(bonus) from PROFESSOR;

--avg 함수
select count(bonus), sum(bonus), avg(bonus), avg(nvl(bonus,0)) 
from PROFESSOR;

--max/ min 함수 (속도와 성능문제가 될수 있어 인덱스를 활용해 사용할 것을 권장)
select max(pay), min(pay) from PROFESSOR;

--stddev/variance 함수 (표준편차/ 분산)
select stddev(pay), VARIANCE(pay) from PROFESSOR; 

----------------------------------------------------------------------------

--GROUP BY 절 (특정조건으로 그룹화하기)
SELECT deptno,count(deptno), to_char(AVG(NVL(pay,0)),'999.99')"평균급여" 
FROM professor GROUP BY deptno order by deptno;

--그룹함수에 취해진 필드명만 올수 있습니다.
--SELECT deptno,count(deptno), to_char(AVG(NVL(pay,0)),'999.99')"평균급여", name  
--FROM professor GROUP BY deptno order by deptno;
--다음과 같이 수정하면 가능합니다.
--여기서는 그룹기준이 deptno, name으로 되어있습니다
SELECT deptno,count(deptno), to_char(AVG(NVL(pay,0)),'999.99')"평균급여", name  
FROM professor GROUP BY deptno, name order by deptno;

--그룹기준 : deptno, job
--GROUP BY 절에 사용된 칼럼은 SELECT 절에 사용되지 않아도 됩니다. deptno, job
select deptno, job, count(deptno), round(avg(sal)) from emp 
GROUP by deptno, job;

select count(deptno), round(avg(sal)) from emp 
GROUP by deptno, job;
----------------------------------------------------------------------------

--having 절(GROUP BY 절에서 조건넣기 where가 아님!!)
/*SELECT deptno, AVG(NVL(pay,0)) FROM professor 
WHERE AVG(pay)>450 GROUP BY deptno;*/

--순서는 GROUP BY절 다음에 씁니다.
--avg(pay)가 450 이상인 것만 deptno를 기준으로 다음을 출력
SELECT deptno, AVG(NVL(pay,0)) FROM professor
GROUP BY deptno HAVING AVG(pay)>450;

SELECT deptno dno, count(deptno), round(avg(sal)) from emp
group by deptno having avg(sal)>2000 order by deptno;

select grade, avg(height) from STUDENT GROUP BY grade HAVING avg(height)>175;

--그렇다고 where문이 안들어가는건 아닙니다만....
select position, round(avg(pay)) from emp2 where EMP_TYPE='정규직'
GROUP BY POSITION HAVING avg(pay)>50000000;

----------------------------------------------------------------------------
--이다음 부터는 잘사용안합니다.
----------------------------------------------------------------------------

--rollup함수(소계값구하기-말아용 ㅋㅋ)
select deptno, job, count(*) from emp GROUP BY deptno, job;

--deptno별로 job는 몇명~~~
select deptno, job, count(*) from emp GROUP BY ROLLUP(deptno, job);

--소계는 deptno별로 하고 position을 기준으로 출력
SELECT deptno, position, SUM(pay) FROM professor 
GROUP BY position, ROLLUP(deptno);

--소계는 position별로 하고 deptno를 기준으로 출력
SELECT deptno, position, SUM(pay) FROM professor
GROUP BY deptno, ROLLUP(position);

----------------------------------------------------------------------------

--cube 함수 (소계+총계)
select deptno, job, count(*) from emp GROUP BY cube(deptno, job);

--grouping 함수 (그루핑 작업에 사용 유뮤 확인하기 1=사용x 0=사용o)
--아래의 경우 맨밑에 열에는 소계를 구해진 것이라서 그루핑이 되어있지 않음
SELECT deptno, SUM(pay), GROUPING(deptno) g_deptno FROM professor
GROUP BY ROLLUP(deptno);

SELECT deptno, position, SUM(pay),
GROUPING(deptno) g_deptno, GROUPING(position)g_position from PROFESSOR
GROUP BY ROLLUP(deptno, POSITION);

--group_id 함수 
/*
  (GROUPING 컬럼)(결과)
      A, B         0  --두칼럼 다 사용
        A          1  --A칼럼만 사용
        B          2  --B칼럼만 사용
        -          3  --두칼럼 다 사용 x
*/
SELECT deptno, position, SUM(pay), 
GROUPING_ID(deptno, position) g_dp, GROUPING_ID(position, deptno) g_pd
from PROFESSOR GROUP BY ROLLUP(deptno, POSITION);

----------------------------------------------------------------------------

--grouping sets

--기존
SELECT grade, COUNT(*) FROM student 
GROUP BY(grade) UNION SELECT deptno1, COUNT(*) 
FROM student GROUP BY(deptno1);

--사용
SELECT grade, COUNT(*) FROM student
GROUP BY GROUPING SETS(grade,deptno1);

----------------------------------------------------------------------------

--LISTAGG 함수(11g에서 추가됨)
--문법 : LISTAGG(list_column, [‘구분자’]) WITHIN GROUP(ORDER BY column)
SELECT deptno, LISTAGG(name, '**') WITHIN GROUP(ORDER BY hiredate)
"LISTAGG" FROM professor GROUP BY deptno;

----------------------------------------------------------------------------

select max(PAY+nvl(BONUS,0)), min(PAY+nvl(BONUS,0)), 
to_char(avg(PAY+nvl(BONUS,0)),'999.9')from PROFESSOR;

select max(PAY+nvl(BONUS,0)), min(PAY+nvl(BONUS,0)), 
to_char(avg(PAY+nvl(BONUS,0)),'999.9')from PROFESSOR;
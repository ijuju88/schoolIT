select CONCAT(name, POSITION) from PROFESSOR;
select name 이름, SUBSTR( JUMIN,3,2) 달 from STUDENT;
select name, tel from STUDENT where SUBSTR(tel, 1,INSTR(tel,')')-1)=055;

select name, SUBSTR(tel,-4,4) 전화번호,
SUBSTR(tel,INSTR(tel,')')+1, INSTR(tel,'-')-INSTR(tel,')')-1)국번
from STUDENT;

select REPLACE(name,SUBSTR(name, 2,1),'#'),
REPLACE(tel,SUBSTR(tel,-4,4),'####')
from STUDENT;
--숫자함수
select ROUND(12.345) ROUND1, ROUND(12.345,2) ROUND2, ROUND(12.345, -1) ROUND3
from dual; /*반올림*/
select TRUNC(12.345) TRUNC1, TRUNC(12.345,2) TRUNC2, TRUNC(12.345, -1) TRUNC3
from dual;/*버림*/
--MOD(나머지), CEIL(근접한 큰 정수), FLOOR(근접한 작은 정수)
select MOD(12,10) MOD, CEIL(12.345) CEIL, FLOOR(12.345) FLOOR from dual;
SELECT POWER(3,2) FROM dual;/*3의 2승*/

--날짜함수
select SYSDATE from dual; --sysdate : 컴퓨터 현재날짜

ALTER SESSION SET NLS_DATE_FORMAT='yyyy-mm-dd hh24:mi:ss'; --날짜 형식 바꾸기
SELECT SYSDATE FROM dual;
--MONTHS_BETWEEN : 사이의 날짜 구하기 (경우에 따라 다름)
SELECT MONTHS_BETWEEN('2012-03-01', '2012-01-01') FROM dual;
SELECT MONTHS_BETWEEN('2012-02-29', '2012-01-31') FROM dual;
SELECT MONTHS_BETWEEN('2012-01-31', '2012-01-01') FROM dual;
select MONTHS_BETWEEN(sysdate,'2016-01-01') from dual;

/*교수테이블에서 deptno=101일때 hiredate와 SYSDATE를 이용 근무 개월 수 
구하기 소수점 2자리에서 반올림*/
select hiredate, ROUND(MONTHS_BETWEEN(sysdate, HIREDATE),2) 근무개월수 from PROFESSOR where deptno=101;
       
-- ADD_MONTHS(날짜 더하기(달)), NEXT_DAY(해당날짜 이후의 요일에 해당하는 날짜 구하기)
-- LAST_DAY(해당날짜를 포함한 마지막 날짜 구하기)
SELECT ADD_MONTHS(SYSDATE, 3)"ADD_MONTHS",
NEXT_DAY(SYSDATE,'월') 다음날, LAST_DAY(SYSDATE) 마지막날
from dual;
--ROUND(반올림), TRUNC(절삭)
SELECT SYSDATE, ROUND(SYSDATE), TRUNC(SYSDATE) FROM dual;

--형변환
SELECT 1 + '1' FROM dual; --자동으로 아래와 같이 형변환됨
SELECT 1 + to_number('1') FROM dual ;
--SELECT 1 + 'A' FROM dual;--안됨

--TO_CHAR 함수
SELECT TO_CHAR(SYSDATE, 'YYYY') "YYYY", TO_CHAR(SYSDATE, 'RRRR') "RRRR", 
TO_CHAR(SYSDATE, 'YY') "YY", TO_CHAR(SYSDATE, 'YEAR') "YEAR" FROM dual;

select TO_CHAR(SYSDATE, 'MM')MM,TO_CHAR(SYSDATE, 'MON')
MON, TO_CHAR(SYSDATE, 'MONTH') MONTH from dual;

SELECT TO_CHAR(SYSDATE, 'DD') DD,TO_CHAR(SYSDATE, 'DAY') DAY,
TO_CHAR(SYSDATE, 'DDTH') DDTH FROM dual;

select TO_CHAR(SYSDATE, 'YYYY-MM-DD:HH24:MI:SS') from dual;

/*Student 테이블의 birthday 칼럼을 참조, 생일이 3월인 학생의 이름과 birthday 출력*/
select name, TO_CHAR(BIRTHDAY, 'YYYY-MM-DD:HH24:MI:SS') birthday 
from STUDENT where to_char(BIRTHDAY, 'MM')=03;

/*professor 테이블에서 101번 학과 교수들의 이름과 연봉을 출력하세요. 
단 연봉은 (pay *12)+bonus 로 계산하시고 천 단위 구분기호로 표시하세요.*/
select TO_CHAR((pay*12)+NVL(BONUS,0),'99,999') from PROFESSOR
where BONUS is not null and deptno=101; --NVL 좀있다 합니당, null값을 해당값으로~

--TO_NUMBER
select to_number('1') from dual;
--TO_DATE
select to_date('2014-01-01', 'yyyy-mm-dd') from dual;

/*Professor 테이블을 사용하여 1990년 이전에 입사한 교수명 과 입사일,
현재 연봉과 10% 인상 후 연봉을 출력하세요. 연봉은 상여금(bonus)를
제외한 (pay*12) 로 계산하고 연봉과 인상 후 연봉은 천 단위 구분 기호를
추가하여 출력하세요.*/
select name, TO_CHAR(HIREDATE, 'YYYY-MM-DD')입사일 , 
TO_CHAR(pay*12, '99,999') 연봉, TO_CHAR((pay*12)*(1+0.1), '99,999') 인상후
from PROFESSOR where HIREDATE<'1990-01-01';


--일반함수
--NUL은 위에 했으니 생략함
Select TO_CHAR(NVL2(BONUS,(pay*12)+BONUS,(pay*12)),'99,999') from PROFESSOR
where deptno=101;

select ename, sal, nvl(comm,0), sal+nvl(comm,0) 연봉, 
(sal+nvl(comm,0))*0.1 세금  from emp;
select ename, sal, nvl(comm,0), nvl2(comm,sal+comm, sal) 연봉, 
nvl2(comm,sal+comm, sal*0.1) 세금  from emp;

--DECODE if문임 DECODE (A, B, ‘1’, null) - A=B이면 1, 아니면 null(생략가능)
/*professor 테이블에서 교수명과 학과번호 , 학과명을 출력하되 
deptno 가 101 번인 교수만 컴퓨터 공학과로 출력하고 101번이 아닌 
교수들은 학과명에 아무것도 출력하지 마세요*/
select name, DECODE(deptno,101,'컴퓨터 공학과', '기타')deptno from PROFESSOR;

/*Professor 테이블에서 교수의 이름과 학과명을 출력하되 
학과 번호가 101 번 이면 ‘컴퓨터 공학과’ , 102 번이면 ‘멀티미디어 공학과” , 
103 번이면 ‘소프트웨어공학과 ‘ 나머지는 ‘기타학과’ 로 출력하세요.*/
select name, DECODE
(deptno,101,'컴퓨터 공학과',102,'멀티미디어 공학과',103,'소프트웨어공학과', '기타')
deptno from PROFESSOR;

select ename, decode(deptno,10,'영업',20,'기획',30 ,'홍보') 부서 from emp;

--DECODE함수의 중첩 if DECODE ( A , B , DECODE( A , C , ‘1’ , ‘2’ ) ’2’ )
/*professor 테이블에서 교수의 이름과 부서번호를 출력하고 101 번 부서 중에서 
이름이 조인형 교수에게 석좌교수 후보라고 출력. 나머지는 NULL 값을 출력*/
select name, deptno, decode(deptno, 101, decode(name, '조인형','석좌교수', '다른교수'),'기타')결과
from PROFESSOR;
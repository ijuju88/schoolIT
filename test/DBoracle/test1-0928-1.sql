select name 이름, TO_CHAR(HIREDATE, 'YYYY-MM-DD') 고용일 from PROFESSOR;

select name 이름, TO_CHAR(PAY, '999,999,999') 연봉 from emp2;

select name, pay, nvl(bonus,0) 보너스, TO_CHAR(pay*12+nvl(bonus,0)) 연봉 from PROFESSOR;
select name, pay, nvl(bonus,0) 보너스, nvl2(bonus,pay*12+BONUS, pay*12) 연봉 from PROFESSOR;

select name, height, weight, case 
when height-weight>120 then '저체중'
when height-weight>=110 then '정상'
when height-weight>=100 then '과체중'
else'비만' end as 비만도
from STUDENT;

select name, height, weight, case 
when height-weight BETWEEN 0 and 100 then '비만'
when height-weight BETWEEN 101 and 110 then '과체중'
when height-weight BETWEEN 111 and 120 then '정상'
else '저체중' end as 비만도 from STUDENT;

select name, deptno1, decode(deptno1, 101,'컴공', 102,'컴멸', 103,'소프트웨어공학', '기타') 학과명 
from STUDENT;

select name, deptno1, case
when deptno1 in (101,102,103) then '컴공'
when deptno1 in (201,202,203) then '수리학'
else '자연과학' end 학과명 from STUDENT;

--select substr(jumin, 7,1) from STUDENT;
--select substr(tel, 1, instr(tel, ')')-1) from STUDENT;

select name, jumin, decode(substr(jumin, 7,1),1,'남',2,'여',3,'남',4,'여') 성 from STUDENT;
select name, tel, decode(substr(tel, 1, instr(tel, ')')-1)
,02,'서울',051, '부산', 052, '울산', 055, '경남','기타') 지역 from STUDENT ;
--위에 같은 답나옴
select name, tel, case(substr(tel,1, instr(tel, ')')-1))
when '02' then '서울' when '031' then '경기' when '051' then '부산'
when '052' then '울산' when '055' then '경남' else '기타'end 지역
from student;

/*교수테이블 (professor)로 교수의 급여액수를 기준으로 
200 미만은 4급, 201 ? 300 까지는 3급, 
301 ? 400 까지는 2급, 401 이상은 1급으로 표시
교수의 번호, 교수이름, 급여, 등급을 출력. 
(단 pay 컬럼을 내림차순으로 정렬하세요)*/
select PROFNO, name, pay, case
when pay>=400 then '1급'
when pay>=300 then '2급'
when pay>=200 then '3급'
else '4급' end 등
from PROFESSOR order by pay desc;

select PROFNO, name, pay, case
when pay BETWEEN 0 and 200 then '4급'
when pay BETWEEN 201 and 300 then '3급'
when pay BETWEEN 301 and 400 then '2급'
else '4급' end 등
from PROFESSOR order by pay desc;


select name, substr(jumin,3,2) "출생일",
case
when(substr(jumin,3,2)) between '01' and '03' then '1/4 분기'
when(substr(jumin,3,2)) between '04' and '06' then '2/4 분기'
when(substr(jumin,3,2)) between '07' and '09' then '3/4 분기'
when(substr(jumin,3,2)) between '10' and '12' then '4/4 분기'
else '안태어 남'
end "분기별"
from student;

select name, to_char(pay,'999,999,999') 연봉, case
when pay BETWEEN 0 and 30000000 then to_char(pay*0.03,'999,999,999')
when pay BETWEEN 30000001 and 50000000 then to_char(pay*0.05,'999,999,999')
when pay BETWEEN 50000001 and 70000000 then to_char(pay*0.07,'999,999,999')
else to_char(pay*0.1,'999,999,999') end 세금
from emp2;


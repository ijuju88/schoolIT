--PL/SQL sub program
/*PROCEDURE (프로시저)
익명 블록과 서브프로그램 차이

익 명 블 록                              서브 프로그램
──────────────────────────────────────────────────
이름이 지정되지 않은 PL/SQL | 블록 이름이 지정된 PL/SQL 블록
매번 사용시마다 컴파일됩니다   | 최초 실행될 때 한번만 컴파일 됩니다
데이터베이스에 저장x       | 데이터베이스에 저장o
다른 응용프로그램호출 x     | 다른 응용프로그램 호출o
값 반환x                | 함수일 경우 값을 반환o
파라미터를 사용x          | 파라미터를 사용o

PROCEDURE (프로시저)
- 프로시저는 지정된 특정 처리를 실행하는 서브 프로그램의 한 유형.
- 단독(standalone)으로 실행되거나 
   다른 프로시저나 다른 툴(Oracle Developer…) 
   또는 다른 환경(Pro*C…)등에서 호출되어 실행됨

생성문법
CREATE [OR REPLACE] PROCEDURE procedure_name
[( parameter1 [mode1] datatype1,
parameter2 [mode2] datatype2,
… )]
IS | AS
PL/SQL Block ;

Parameter Mode

*/

--부서번호가 20번 인 사람들의 job 을 ‘CLERK’ 으로 변경하는 프로시저
set serveroutput on;
create or REPLACE PROCEDURE update_20
is BEGIN
 update emp set job='CLERK' where deptno=20;
END;  
/
execute update_20;


--사번을 입력 받아 급여를 인상하는 프로시저
SELECT empno , ename, sal FROM emp WHERE empno=7902;

set serveroutput on
CREATE OR REPLACE PROCEDURE up_sal
 ( vempno emp.empno%TYPE ) 
 IS
 BEGIN
 UPDATE emp SET sal=5000 WHERE empno=vempno ;
 END;
 /
 EXEC up_sal(7902); 
 --프로시저를 실행할 때 사원번호를 함께 입력
 
 
--사 번을 입력 받아 그 사원의 이름과 급여를 출력하는 프로시저
CREATE OR REPLACE PROCEDURE ename_sal
 ( vempno emp.empno%TYPE)
 IS
 vename emp.ename%TYPE;
 vsal emp.sal%TYPE;

 BEGIN
 SELECT ename, sal
 INTO vename , vsal
 FROM emp
 WHERE empno=vempno;

 DBMS_OUTPUT.PUT_LINE('사원명은 '||vename||' 입니다');
 DBMS_OUTPUT.PUT_LINE('급여는 '||vsal||'입니다');
 END;
 /
 
 /* 결과
  사원명은 FORD 입니다
급여는 5000입니다
*/


--------------------------------------------------- 
--OUT 모드 파라미터
 
CREATE OR REPLACE PROCEDURE info_prof
 ( v_profno IN professor.profno%TYPE,
 v_name OUT professor.name%TYPE, -- 이름값을 저장할 변수
 v_pay OUT professor.pay%TYPE) -- 급여를 저장할 변수
 IS
 BEGIN
 SELECT name, pay INTO v_name , v_pay
 FROM professor
 WHERE profno = v_profno ;
 END info_prof ;
 /

DECLARE
 v_name professor.name%TYPE ;
 v_pay professor.pay%TYPE ;
 BEGIN
 info_prof(1001,v_name , v_pay) ; -- 프로시저를 호출하면서 IN 변수값을 지정.
 DBMS_OUTPUT.PUT_LINE(v_name||' 교수의 급여는 '||v_pay||' 입니다.');
 END ;
 /

/*
 조인형 교수의 급여는 550 입니다.
 */

DECLARE
 v_name professor.name%TYPE ;
 v_pay professor.pay%TYPE ;
 BEGIN
 info_prof(1001,v_name,v_pay) ;
 DBMS_OUTPUT.PUT_LINE('이 름: '||v_name) ;
 DBMS_OUTPUT.PUT_LINE('급 여: '||v_pay) ;
 END ;
/
/* 결과
 이 름: 조인형
급 여: 550
*/


--실습중
CREATE OR REPLACE PROCEDURE emp_pro (
 v_empno IN EMP.EMPNO%TYPE,
 v_ename OUT EMP.ENAME%TYPE,
 v_sal OUT EMP.SAL%TYPE)
IS
BEGIN
   SELECT ename, sal
     INTO v_ename, V_sal
     FROM emp
    WHERE empno = v_empno;
END;
/

DECLARE
 v_ename EMP.ENAME%TYPE;
 v_sal EMP.SAL%TYPE;
 BEGIN
 emp_pro(7902,v_ename,v_sal) ;
 DBMS_OUTPUT.PUT_LINE('이 름: '||v_ename) ;
 DBMS_OUTPUT.PUT_LINE('급 여: '||v_sal) ;
 END ;
 /
/* 결과
이 름: FORD
급 여: 5000
*/

VARIABLE name VARCHAR2(10);
VARIABLE pay NUMBER;
EXEC info_prof(1001,:name,:pay);

PRINT name pay;

--------------------------------------------------
--PL/SQL 에서 파라미터 이름 지정하는 방식

DECLARE
 v_name professor.name%TYPE ;
 v_pay professor.pay%TYPE ;
 BEGIN
 info_prof(v_profno =>1001,
 v_name => v_name ,
 v_pay => v_pay);
 DBMS_OUTPUT.PUT_LINE('이름:'||v_name);
 DBMS_OUTPUT.PUT_LINE('급여:'||v_pay);
 END ;
 /
 
 
DECLARE
v_name professor.name%TYPE ;
v_pay professor.pay%TYPE ;
BEGIN 
 info_prof(1001, -- 첫 번째 위치 변수의 값을 직접 지정
 v_name => v_name , -- 이름을 직접 지정함
 v_pay => v_pay);
 DBMS_OUTPUT.PUT_LINE('이름:'||v_name);
 DBMS_OUTPUT.PUT_LINE('급여:'||v_pay);
 END ;
/
 
/*결과
이름:조인형
급여:550
*/

------------------------------------------------

--생성된 프로시저 내용확인
select text from user_source where name='INFO_PROF';

------------------------------------------------------

--연습문제
/*
Emp 테이블에 신입 사원의 아래 정보를 입력 받아 등록하는 프로시저를 작성
( 나머지 컬럼의 값은 null 입니다)
(프로시저 이름과 변수 명은 마음대로 하세요)
* Empno : 4000
* Name : Smith
* Job : Clerk
* Manger no: 7900
* Salary : 3500
*/

create or REPLACE PROCEDURE emp_test(
t_empno in EMP.EMPNO%TYPE,
t_name out EMP.ENAME%TYPE,
t_job out EMP.JOB%TYPE,
t_manger out EMP.MGR%TYPE,
t_salary out EMP.SAL%TYPE)
is
	BEGIN
		insert into emp(ename, job, mgr, sal)  
		values(t_name, t_job, t_manger, t_salary); 
	END;
	/
	
exec emp_test(4000,Smith, CLERK, 7902, 3500);

/*
Emp 테이블을 사용하여 부서번호를 입력 받아서 보너스(comm) 
를 아래의 조건으로 계산하는 프로시저를 작성하세요
(프로시저 이름과 변수 명은 적당하게 정하세요)
* 조건
Deptno = 10 이면 급여의 20%
Deptno = 20 이면 급여의 30%
Deptno = 30 이면 급여의 10%
나머지는 0%
*/
create or replace procedure cal_comm
(vempno emp.empno%type)
is
vdeptno emp.deptno%type;
begin
  select deptno into vdeptno from emp
  where empno=vempno;
   
  dbms_output.put_line('Calculating commission');
  update emp
  set comm=sal * decode(vdeptno, 10, 0.2,
                                 20, 0.3,
                                 30, 0.1,
                                 0)
  where empno=vempno and deptno=vdeptno;
  dbms_output.put_line(SQL%ROWCOUNT||' rows updated.');
end;
/
--exec cal_comm(7499);
select empno, sal, comm, deptno from emp
where empno in(7369, 7499, 7934);
/*
사원 번호를 입력 받아 삭제 하는 프로시저를 작성하세요.
이 실습을 위해서 emp 테이블을 emp2 로 복사하신 후 emp2 테이블을 사용하여 작업하세요
(프로시저 이름과 변수명은 마음대로 하세요)
*/

CREATE table emp20 as select * from emp;

create or REPLACE  PROCEDURE  emp_test1(
t_empno EMP20.EMPNO%TYPE)
is 
	BEGIN
		delete from emp20 where empno=t_empno;
	END;
/	

--exec emp_test1(7902);
select * from emp;
select * from emp20;

/*
emp , dept 테이블을 사용하여 사원의 사원번호를 입력 받아서 
아래처럼 그 사원의 사원번호와 ,이름, 부서명 ,급여, 상여금 을 출력하는 
프로시저를 작성하세요.
(프로시저 이름과 변수명은 마음대로 하세요)
*/
create or REPLACE PROCEDURE CAL_dept_pro(
v_empno EMP.empNO%TYPE)
is 
v_name emp.ename%type;
d_name DEPT.DNAME%TYPE;
v_sal EMP.SAL%TYPE;
v_comm EMP.COMM%TYPE;
BEGIN
	select e.ename, d.dname, e.sal, e.comm
	into v_name, d_name, v_sal, v_comm 
	from emp e, dept d
	where e.deptno=d.deptno and e.empno=v_empno;
	DBMS_OUTPUT.PUT_LINE('사  번:'||v_empno);
	DBMS_OUTPUT.PUT_LINE('이  름 :'||v_name);
	DBMS_OUTPUT.PUT_LINE('부서명:'||d_name);
	DBMS_OUTPUT.PUT_LINE('급  여:'||v_sal);
	DBMS_OUTPUT.PUT_LINE('상여금:'||v_comm);
END;
/
--exec CAL_dept_pro(7499);
/* 결과
사  번:7499
이  름 :ALLEN
부서명:SALES
급  여:1600
상여금:160
*/

---------------------------------------------------

--FUNCTION(내장함수)
/*
--정해진 작업을 수행 한 후 결과를 돌려준다(RETURN)
CREATE [OR REPLACE] FUNCTION function_name
[( parameter1 [mode1] datatype1,
parameter2 [mode2] datatype2,
… )]
RETURN datatype
IS | AS
PL/SQL Block ;
*/

--부서번호를 입력 받아 최고 급여액을 출력하는 함수
CREATE OR REPLACE FUNCTION s_max_sal
 (s_deptno emp.deptno%TYPE)
 return number
 IS
 max_sal emp.sal%TYPE ;
 BEGIN
 SELECT max(sal) INTO max_sal
 FROM emp
 WHERE deptno=s_deptno;
 RETURN max_sal ; -- 이 부분의 데이터 형이 위 3번 줄의 형과 같아야 함
 END;
 /

select DISTINCT s_max_sal(10) from emp;
--select s_max_sal(10) from dual;

--부서번호를 입력 받은 후 해당 부서의 인원수를 구해주는 함수
create or REPLACE FUNCTION count_men(count NUMBER)
RETURN NUMBER
is
	max_count NUMBER;
	BEGIN
		select count(*) into max_count from emp
		where deptno=count;
		RETURN max_count; -- 이부분의 데이터 형이 위 3번줄 데이터 형과 같아야 함
	END;
/

SELECT DISTINCT deptno, count_men(deptno) FROM emp;


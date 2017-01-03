SET SERVEROUTPUT ON ; 
DECLARE 
vno NUMBER(4) ;
vname VARCHAR2(10) ;
BEGIN
SELECT empno , ename INTO vno , vname
FROM emp
WHERE empno=7900 ;
DBMS_OUTPUT.PUT_LINE(vno||' '||vname) ;
END ;

/*
professor 테이블에서 교수번호가 1001 번인 교수의 교수번호와 급여를
조회 한 후 변수에 저장해서 화면에 출력
*/
DECLARE
v_profno professor.profno%TYPE ;
v_pay professor.pay%TYPE ;
BEGIN
SELECT profno , pay INTO v_profno ,v_pay
FROM professor
WHERE profno=1001 ;
DBMS_OUTPUT.PUT_LINE(v_profno||' 번 교수의 급여는 '||v_pay||' 입니다') ;
END ;

/*
emp2 테이블을 사용하여 사원번호를 입력 받아서 사원의 사 번과 이름, 생일을출력
*/
DECLARE
v_empno emp2.empno%TYPE ;
v_name emp2.name%TYPE ;
v_birth emp2.birthday%TYPE;
BEGIN
SELECT empno, name, birthday
INTO v_empno ,v_name, v_birth
FROM emp2
WHERE empno = '&empno' ;
DBMS_OUTPUT.PUT_LINE(v_empno||' '||v_name||' '||v_birth);
END ;

/*
 교수번호를 입력 받은 후 professor 테이블을 조회하여 해당 교수의 교수번호와
교수이름, 부서번호, 입사일을 출력
*/

DECLARE
v_profno professor.profno%TYPE ;
v_name professor.name%TYPE ;
v_deptno professor.deptno%TYPE ;
v_hdate professor.hiredate%TYPE ;
BEGIN
SELECT profno, name, deptno , hiredate
INTO v_profno, v_name, v_deptno, v_hdate
FROM professor
WHERE profno = '&교수번호' ;
DBMS_OUTPUT.PUT_LINE(v_profno||' '||v_name||' '||v_deptno||' '||v_hdate);
END;

--INSERT 문장
CREATE TABLE pl_test
(no number ,
name varchar2(10)) ;
CREATE SEQUENCE pl_seq ;

 BEGIN
 INSERT INTO pl_test
 VALUES(pl_seq.NEXTVAL,'AAA');
 END ;
 
 SELECT * FROM pl_test ;
--------------------------------------
CREATE TABLE pl_test2
(no number ,
name varchar2(10),
addr varchar2(10) );

SET VERIFY OFF
DECLARE
v_no number := '&no';
v_name varchar2(10) := '&name' ;
v_addr varchar2(10) := '&addr' ;

BEGIN
INSERT INTO pl_test2
VALUES(v_no, v_name, v_addr) ;
 END ;
 
--update
BEGIN
 UPDATE pl_test
 SET name='BBB'
 WHERE no = 2 ;
 END ;

SELECT * FROM pl_test ;

--ORACLE PACKAGE (패키지)
/*
패키지는 연관성이 높은 함수나 프로시저를 하나의 그룹으로 묶어두는 개념.

-패키지 선언부(Spec)와 패키지 몸체부(body)로 구성. 
패키지 선언부
	패키지에 사용될 함수나 프로시저, 변수등에 대한 정의를 선언하는 부분 
┌─────────────────────────────────────────────┐
	CREATE [OR REPLACE] PACKAGE package_name
	IS | AS
	Public type and item declarations
	Subprogram specifications
	END package_name ;
└─────────────────────────────────────────────┘
*삭제 : DROP PACKAGE package_name ;

패키지 몸체부
	선언부에서 선언된 함수나 프로시저등이 실제 구현되는 부분. 
┌─────────────────────────────────────────────────┐	
	CREATE [OR REPLACE] PACKAGE BODY package_name
	IS | AS
	Private type and item declarations
	Subprogram bodies
	END package_name ;
└─────────────────────────────────────────────────┘	
*삭제 : DROP PACKAGE BODY package_name ;

-패키지 선언부에서 선언되지 않더라도 패키지 몸체부에서 사용될 수는 있지만 
별로 권장사항은 아니니 가급적 선언부에서 선언하신 후 몸체부에서 사용해야 함
*/

--Emp table 에서 총 급여합계와 평균 급여를 구하는 package
create or REPLACE  PACKAGE emp_total
as
	PROCEDURE emp_sum;
	PROCEDURE emp_avg;
end emp_total;
/

CREATE OR REPLACE PACKAGE BODY emp_total AS
	PROCEDURE emp_sum IS
	CURSOR emp_total_sum IS
		SELECT COUNT(*), SUM(NVL(sal,0)) FROM emp;
	total_num NUMBER ;
	total_sum NUMBER;
	BEGIN
	OPEN emp_total_sum ;
	FETCH emp_total_sum INTO total_num , total_sum ;
	DBMS_OUTPUT.PUT_LINE('총인원수: '||total_num||' , 급여합계: '||total_sum);
	CLOSE emp_total_sum;
	END emp_sum ; --emp_sum 프로시저 끝
PROCEDURE emp_avg -- emp_avg 프로시저 시작
IS
	CURSOR emp_total_avg IS
 		SELECT COUNT(*), AVG(NVL(sal,0)) FROM emp;
	total_num NUMBER ;
	total_avg NUMBER ;
BEGIN
 	OPEN emp_total_avg ;
 	FETCH emp_total_avg INTO total_num , total_avg;
 	DBMS_OUTPUT.PUT_LINE('총인원수: '||total_num||' , 급여평균: '||total_avg);
 	CLOSE emp_total_avg ;
END emp_avg; -- 프로시저 끝
END emp_total; -- 패키지 끝
/

--실행
--set serveroutput on;
--EXEC emp_total.emp_avg;
--총인원수: 16 , 급여평균: 2351.5625
--EXEC emp_total.emp_sum;
--총인원수: 16 , 급여합계: 37625

---------------------------------------------------------
--TRIGGER(트리거)
/*
서브 프로그램 단위의 하나인 TRIGGER는 
테이블, 뷰, 스키마 또는 데이터베이스에 관련된 
PL/SQL 블록(또는 프로시저)으로 관련된 특정 사건(Event)이 발생될 때마다 
묵시적(자동)으로 해당 PL/SQL 블록이 실행

주요 TRIGGER 유형
*단순 DML TRIGGER 
– BEFORE TRIGGER 
	테이블에서 DML 이벤트를 TRIGGER하기 전에 TRIGGER 본문을 실행 

– AFTER TRIGGER 
	테이블에서 DML 이벤트를 TRIGGER한 후에 TRIGGER 본문을 실행. 

- INSTEAD OF TRIGGER 
	TRIGGER 문 대신 TRIGGER 본문을 실행하며, 수정이 불가능한 뷰에 사용

-문장 TRIGGER / 행 TRIGGER 
TRIGGER가 무조건 한 번은 실행. 
문장 TRIGGER는 TRIGGER 작업이 영향을 받는 행의 데이터 또는
 TRIGGER 이벤트 자체에서 제공하는 데이터에 종속되지 않은 경우에 유용. 
행 TRIGGER는 테이블이 TRIGGER 이벤트의 영향을 받을 때마다 실행되고, 
 TRIGGER 이벤트의 영향을 받는 행이 없을 경우에는 실행되지 않음. 
행 TRIGGER는 영향을 받는 행의 데이터나 TRIGGER 이벤트 자체에서 
제공하는 데이터에 TRIGGER 작업이 종속될 경우에 유용. 
행 TRIGGER 로 생성하려면 FOR EACH ROW 라는 구절을 사용.
 
*혼합 TRIGGER (11g 부터 추가됨)
여러 가지 TRIGGER를 하나로 만든 것으로 마치 PL/SQL 의 패키지와 비슷

1. 혼합 TRIGGER는 DML TRIGGER여야 하며 테이블이나 뷰에 정의해야 함. 
2. 혼합 TRIGGER의 본문은 PL/SQL에서 작성한 혼합 TRIGGER 블록이어야 함.
3. 혼합 TRIGGER 본문에는 초기화 블록이 포함될 수 없으므로 예외 섹션x. 
4. 한 섹션에서 발생하는 예외는 해당 섹션에서 처리. 권한을 이전할 수 없음.
5. :OLD 및 :NEW는 선언, BEFORE STATEMENT 또는 
   AFTER STATEMENT 섹션에 나타날 수 없음. 
6. BEFORE EACH ROW 섹션만 :NEW 값을 변경할 수 있음.
7.FOLLOWS 절을 사용하지 않으면 혼합 TRIGGER의 실행 순서가 일정하지 않음.

*DML이 아닌 TRIGGER
DML TRIGGER와 거의 동일하지만 TRIGGER 를 활용하여 DDL 작업만 다름.

– 데이터베이스 이벤트 TRIGGER
데이터베이스 이벤트 TRIGGER란 데이터베이스 내에서 생기는 일들을 관리하기 
위해서 생성하는 TRIGGER . 
사용자 관련 이벤트가 있고 시스템 관련 이벤트가 있으며 아래와 같음.

- 유저 이벤트 TRIGGER:
	사용자가 발생시키는 작업에 TRIGGER를 생성.
	CREATE, ALTER 또는 DROP
	로그온 또는 로그오프
	
- 데이터베이스 또는 시스템 이벤트 TRIGGER:
	데이터베이스 전체에 영향을 주는 작업에 TRIGGER를 생성.
	데이터베이스 종료 또는 시작
	발생한 특정 오류 (또는 임의의 오류)
	
*TRIGGER 생성
┌───────────────────────────────────────────────┐	
	CREATE [OR REPLACE] TRIGGER trigger_name
	timing
	event1 [ OR event2 OR event3 … ]
	ON {table_name|view_name|SCHEMA|DATABASE}
	[REFERENCING OLD AS old | NEW AS new]
	[FOR EACH ROW [WHEN ( condition ) ] ]
	trigger_body
└───────────────────────────────────────────────┘

*TRIGGER 관리 
- 활성화/비활성화 하기 
	ALTER TRIGGER trigger_name DISABLE | ENABLE ; 
	
- 특정 테이블에 속한 TRIGGER의 활성화/비활성화 
	ALTER TABLE table_name DISABLE | ENABLE ALL TRIGGERS; 

- TRIGGER 수정 후 다시 컴파일하기
 	ALTER TRIGGER trigger_name COMPILE ; 
	
- TRIGGER 삭제 
	DROP TRIGGER trigger_name ; 
	
- TRIGGER 조회하기 USER_TRIGGERS 를 조회하면 됩니다.

*TRIGGER 관련 권한들(sys)
-스키마에서 TRIGGER를 생성, 변경 및 삭제할 수 있는 권한:
	GRANT CREATE TRIGGER TO SCOTT ;
	GRANT ALTER ANY TRIGGER TO SCOTT;
	GRANT DROP ANY TRIGGER TO SCOTT ;
	
-데이터베이스에서 TRIGGER를 생성할 수 있는 권한:
	GRANT ADMINISTER DATABASE TRIGGER TO SCOTT ;
	
-EXECUTE 권한 (TRIGGER가 실행하는 스키마에 포함되지 않은 객체를
참조하는 경우)
*/
--테이블에 데이터를 입력할 수 있는 시간 지정하기(문장 레벨 Trigger 사용)

--테이블 생성
create table t_order
(no number,
ord_code varchar2(10),
ord_date date);

create or replace trigger t_order
 before insert on t_order 
 begin if(to_char(sysdate,'HH24:MI') 
 not between '11:00' and '11:50') then 
 	raise_application_error(-20100,'허용시간이 아닙니다'); 
 end if; 
end; /

insert into t_order values(2, 'c200', sysdate);

--테이블에 데이터 값을 지정, 그 외의 값이 입력되면 에러를 발생시키는 TRIGGER
create or REPLACE TRIGGER t_order2
 BEFORE INSERT on t_order
 for EACH ROW 
 BEGIN 
  if(:new.ord_code) not in('c100','c200') then
   raise_application_error(-20200, '제품코드가 틀립니다.');
  end if;
 end;
/	

insert into t_order values(2, 'c200', sysdate);
insert into t_order values(3, 'c300', sysdate);
select * from t_order;

--다음예제를 위해 지움
DROP TRIGGER t_order;
DROP TRIGGER t_order2;

--TRIGGER 작동 조건을 when절로 정의
create or REPLACE TRIGGER t_order3
 BEFORE INSERT on T_ORDER
  for EACH ROW when(new.ord_code= 'c500')
 BEGIN 
 if(to_char(sysdate,'HH24:MI')
  not between '11:00' and '11:10') then
  raise_application_error(-20300,'c500 제품 입력시간이 아닙니다');
 end if;
end;

insert into t_order values(4, 'c500', sysdate);
select * from t_order;

--------------------------------------------------------
/*
기존 테이블(t_test1)의 내용을 업데이트할때 기존의 내용을 
백업용 테이블에(t_test2)로 옮겨 놓는 TRIGGER 작성
*/

create table t_test1 (no number, name varchar2(10)); 
insert into t_test1 values(1, 'AAA');
insert into t_test1 values(2, 'BBB');
insert into t_test1 values(3, 'CCC');

create table t_test2 as select * from t_test1;

create or REPLACE TRIGGER t_move
 before UPDATE on t_test1
 for each row
  BEGIN 
  	insert into t_test2 values(:old.no, :old.name);
 end;
/

update t_test1 set name='A1A2' where no=1; 
select * from t_test1; 
select * from t_test2; --전의 no,name가 들어가는걸 볼수 있음

--DROP table t_test2;
--DROP table t_test1;


/*
기본 테이블(t_test1)테이블의 데이터가 삭제될 때 
백업테이블(t_test3)로 이동시키며 백업테이블에 삭제한 시간 삭제 전 
데이터를 모두 기록하는 trigger 생성
*/

create table t_test3
(
no number, name varchar2(10), 
time date
);
create or replace trigger d_trigger
after delete on t_test1
for each row
begin
insert into t_test3 values(:old.no, :old.name, sysdate);
end;
/
delete from t_test1 where no=1;
select * from t_test1;
select * from t_test3;

-------------------------------------------------------
--연습문제
--테이블 생성

--상품테이블
create table pro(
pno NUMBER(3), pname VARCHAR2(10), pprice number
);

INSERT into pro VALUES(100, '새우깡', 900); 
INSERT into pro VALUES(200, '감자깡', 900); 
INSERT into pro VALUES(300, '맛동산', 1000); 

--입고테이블
create table pro_in(
ino NUMBER(3), inum NUMBER, iprice number
);
INSERT into pro_in VALUES(100, 10, 9000); 
INSERT into pro_in VALUES(200, 10, 9000); 
INSERT into pro_in VALUES(300, 10, 10000); 

--판매테이블
create table pro_out(
ono NUMBER(3), onum NUMBER, oprice number
);
INSERT into pro_out VALUES(100, 0, 0); 
INSERT into pro_out VALUES(200, 0, 0); 
INSERT into pro_out VALUES(300, 0, 0); 

--재고테이블
create table pro_sum(
sno NUMBER(3), snum NUMBER, sprice number
);
INSERT into pro_sum VALUES(100, 10, 9000); 
INSERT into pro_sum VALUES(200, 10, 9000); 
INSERT into pro_sum VALUES(300, 10, 10000); 

/*
입고 SQL 과 같이 새우깡이 입고되면 
재고 테이블에서 자동으로 새우깡의 재고 수량과 금액이 증가 되는 
TRIGGER를 작성하세요.
*/
create or replace TRIGGER p_test
 BEFORE INSERT on pro_in
 for each row
 BEGIN 
  update pro_sum set 
  snum=snum+:new.inum, 
  sprice=sprice+:new.iprice
  where sno=:new.ino;
end;
/
INSERT INTO pro_in VALUES (100,2,1800);

/*
위 테이블에서 새우깡이 판매되면 재고 테이블에서 새우깡의 재고 수량과 
금액에 반영되도록 감소하는 TRIGGER를 작성하세요.
*/
create or replace TRIGGER p_test2
 BEFORE INSERT on pro_out
 for each row
 BEGIN 
  update pro_sum set 
  snum=snum-:new.onum, 
  sprice=sprice-:new.oprice
  where sno=:new.ono;
end;
/

INSERT INTO pro_out VALUES (100,3,2700);
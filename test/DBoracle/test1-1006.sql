--INSERT 데이터 입력~~
/*단일행 
INSERT INTO table [(column1, column2,……)] 
VALUES (value 1 , value 2,….) ;

-- 칼럼명을 다 입력할거면 [(column1, column2,……)] 을 생략해도 됩니다
*/

desc dept2;
--한글을 더넣을려고 구조변경합니다
alter table dept2 MODIFY(pdept varchar2(20));

insert into dept2(dcode, dname, pdept, area)
VALUES (9000,'특판1팀','영업부','임시지역');
--칼럼 순서를 바꾸어 적으시면 밑에 valuse값도 맞게 넣어줍시다
insert into dept2(dname, dcode, pdept, area)
VALUES('특판2팀', 9001, '영업부','서울지사');

insert into dept2 VALUES(9002,'특판3팀', '영업부', '임시지역');
select * from dept2;

--특정칼럼만 입력합니다 : pdept,area는 null 값이 들어가도 되니...
insert into dept2(dcode, dname, area) VALUES(9003, '특판4팀', '서울지사');
--이렇게도 가능합니다(칼럼이 많으면..--;)
insert into dept2 VALUES(9004,'특판5팀', '영업부', null);

--날짜 데이터 입력하기 (운영체제마다 날짜포맷이 다르므로 주의해주세용 >_-)
insert into PROFESSOR(profno, NAME, id, position, pay, hiredate)
VALUES(5001,'김설희','Love_me','정교수',501,'2011-11-14');

select * from PROFESSOR;

--여러행을 입력합시다(as)
--구조만 복사할랍니다 ㅋㅋ
CREATE TABLE professor2 AS SELECT * FROM professor where 1=2;
--drop table professor2;
--professor테이블에  position='정교수' 인 사람만 PROFESSOR2테이블에 넣을랍니다.
insert into PROFESSOR2 select * from professor where position='정교수';
select * from PROFESSOR2;

--다른테이블의 데이터 가져와서 입력하기
/*
Professor 테이블에서 
교수번호가 1000 번 에서 1999번까지 인 교수의 번호와 
교수이름은 p_01 테이블에 입력하고 교수번호가 2000 번에서 2999 번까지
인 교수의 번호와 이름은 p_02 테이블에 입력하세요.
*/
INSERT ALL
 WHEN profno BETWEEN 1000 AND 1999 THEN
 INTO p_01 VALUES(profno,name)
 WHEN profno BETWEEN 2000 AND 2999 THEN
 INTO p_02 VALUES(profno,name)
 SELECT profno,name
 FROM professor ;
 
select * from p_02;

--연습
create table s_01 as select name, deptno1 from student where 1=2;
create table s_02 as select * from s_01;

insert all
 when deptno1 BETWEEN 100 and 199 then
 into s_01 VALUES(name, deptno1)
 when deptno1 BETWEEN 200 and 299 then
 into s_02 VALUES(name, deptno1)
 select name, deptno1 from student;
 
select * from s_01;
select * from s_02;

--다른 테이블에 동시에 같은 데이터 입력하기
insert all
 into P_01 VALUES(profno, name)
 into P_02 VALUES(profno, name)
 select profno, name from PROFESSOR
 where profno BETWEEN 3000 and 3999;
 
insert all
 into s_01 VALUES(name, deptno1)
 into s_02 VALUES(name, deptno1)
 select name, deptno1 from student
 where deptno1 BETWEEN 300 and 399;
 
--연습
create table e_01 as select ename, deptno from emp where 1=2;
create table e_02 as select * from e_01;

insert all
 when deptno BETWEEN 10 and 19 then
 into e_01 VALUES(ename, deptno) 
 when  deptno like 20 then
 into e_02 VALUES(ename, deptno) 
 select ename, deptno from emp;
 
insert all
 into e_01 VALUES(ename, deptno) 
 into e_02 VALUES(ename, deptno) 
 select ename, deptno from emp
 where deptno=30;
 
select * from e_02;

--UPDATE 수정
/*
UPDATE table
SET column = value
WHERE 조건 ;
*/
update PROFESSOR set BONUS=100 where POSITION='조교수';

--정교수만 있으니 이번에는 전임강사와 조교수를 PROFESSOR2테이블에 넣어봅시다
insert into PROFESSOR2 select * from PROFESSOR where position in('조교수','전임강사');
--update를 실행합니당
update PROFESSOR2 set BONUS=50 where POSITION='전임강사';

update PROFESSOR2 set pay=pay*(1+0.1),BONUS=BONUS*(1+0.1) where POSITION='정교수';
select * from PROFESSOR2;

--조건이 여러개일때~~ 서브쿼리를 사용합니다 나중에 자세하게 배웁니당
/*
Professor 테이블에서 차범철 교수의 직급과 동일한 직급을 가진 교수들 중 
현재 급여가 350 만원이 안 되는 교수들의 급여를 15% 인상
*/
update PROFESSOR set pay=pay*1.15
 where position=(
 select position from PROFESSOR where name='차범철')
 and pay<350;

select * from PROFESSOR;

--delete - 데이터삭제
DELETE FROM dept2
 WHERE dcode between 9000 and 9100 ;
delete from PROFESSOR2;
--보시면 데이터만 지워집니다 ㅋ
select * from PROFESSOR2;

--MERGE: 테이블 합치기 (백업용으로~~;)
/*
MERGE INTO Table1(합쳐질 최종테이블)
USING Table2(해당테이블)
ON ( 병합 조건절 )
WHEN MATCHED THEN
UPDATE SET 업데이트 내용
DELETE WHERE 조건
WHEN NOT MATCHED THEN
INSERT VALUES(컬럼 이름) ;
*/
--MERGE 작업 QUERY 1 (pt_01 테이블과 p_total 테이블 병합)
 --total, p01은 별칭입니다
merge into p_total total
 using pt_01 p01
 on(total.판매번호=p01.판매번호)
 when MATCHED then
 UPDATE set total.제품번호=p01.제품번호
 when not MATCHED then
 insert values(p01.판매번호, p01.제품번호, p01.수량, p01.금액);
 
--마찬가지로 pt_02도 해봅니다
merge into p_total total
 using pt_02 p02
 on(total.판매번호=p02.판매번호)
 when MATCHED then
 UPDATE set total.제품번호=p02.제품번호
 when not MATCHED then
 insert values(p02.판매번호, p02.제품번호, p02.수량, p02.금액);
 
 select * from p_total;
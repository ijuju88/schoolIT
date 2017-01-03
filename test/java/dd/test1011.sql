--index
/*
데이터베이스에서 테이블과 클러스터에 연관되어 독립적인 저장
공간을 보유하고 있는 객체(object), 더욱 빠르게 조회하기 위해 사용
*/

--ROWID ( 주소 ) 조회하기
SELECT ROWID, empno, ename FROM emp WHERE empno=7902 ;
/*
  ROWID                     EMPNO  ENAME
 ────────────────────────── ────── ─────
 oracle.sql.ROWID@43623121   7902  FORD
 */

--작동원리
SELECT * FROM 사원 WHERE 이름=’홍길동’ ;
/*
 3번 줄의 where 조건의 칼럼으로 인덱스 검색
          ↓
해당 데이터의 ROWID 를 찾음
          ↓
해당 블록을 복사하여 DB CACHE로 로딩함
*/

--종류 B-TREE / BITMAP

--------------------------------------------------------
--UNIQUE INDEX
/*
필드값에 중복값이 없을때 사용
CREATE UNIQUE INDEX 인덱스명
ON 테이블이름(컬럼명1 ASC | DESC , 컬럼명,……..);
*/

create unique index idx_dept2_dname on dept2(dname);

create unique index idx_name_index on student(name);

--그럼 있는 이름인 서진수 학생을 넣어봅니다
insert into student(studno, name, id, jumin) values
(9999, '서진수', 'shbss', 9512252548670);
/*
--에러 발생
ORA-00001: unique constraint (TEST1.IDX_NAME_INDEX) violated
(0 rows affected)
*/
select name from STUDENT; --정렬이 되었습니당 ㅋ

--중복값이 있는 칼럼에다가 만들어봅니다
create unique index emp_no_index on emp(deptno);
/*
ORA-01452: cannot CREATE UNIQUE INDEX; duplicate keys found
(0 rows affected)*/


--Non UNIQUE INDEX
/*
필드값에 중복값이 있을때 사용
CREATE INDEX 인덱스명
ON 테이블명(컬럼명1 ASC | DESC , 컬럼명2 , …….) ;
*/
--방금전에 중복값이 있어서 못만든걸 만듭니다 ㅋ
create index emp_no_index on emp(deptno);

--Function Based INDEX(FBI – 함수기반 인덱스)

--DESCENDING INDEX
/*
큰 값을 먼저 조회 해야 할 경우에 주로 사용함.
주로 날짜의 경우 최근 날짜를 먼저 조회하는 경우가 많기 때문에 날짜 컬
럼에 인덱스를 만들 경우에 자주 사용됨.
*/

--결합 인덱스 ( Composite INDEX )
--두 개 이상의 칼럼이 AND 조건으로 검색 될 경우 많이 사용됨

--카
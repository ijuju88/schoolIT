--테이블스페이스 생성하기
/*
테이블스페이스 : 오라클에서 데이터를 저장할 때 사용하는 논리적 저장
공간(하드디스크에서는 실제 여러 개의 물리적인 데이터 파일로 구성될
수 있음). 오라클 시스템 운영에 필요한 필수 정보를 담고 있음
CREATE TABLESPACE 테이블스페이스명
DATAFILE ‘저장될 경로 및 사용할 파일명’ SIZE 저장공간
*/

/*
(system 계정) 10M의 용량의 테이블스페이스 md_tbst를
폴더에 생성하고 이때 데이터 파일 이름은 md_tbs_data01.dbf로 한다(폴더가 없으면 생성 후 진행).
*/

CREATE TABLESPACE md_tbs
DATAFILE 'D:\ijuju\oradata\md_tbs_data01.dbf' SIZE 10M;

--테이블스페이스 삭제하기
/*
DROP TABLESPACE 테이블스페이스이름
[INCLUDING CONTENTS [AND DATAFILES] [CASCADE CONSTRAINTS]];
*/
drop tablespace md_tbs INCLUDING CONTENTS AND DATAFILES;

--------------------------------------------------------------------

--사용자 계정생성
create user test3 identified by 1234 default tablespace md_tbs;

--설정변경
alter user test3 identified by 1111;

--계정삭제
drop user test3 cascade;

------------------------------------------------------------------
--권한허가
/*
 GRANT 권한 [(컬럼[ ,...n ])] [ ,...n ]
[ON 객체] TO {사용자Ι롤ΙPUBLIC [ ,...n ]}
[WITH GRANT OPTION]
*/

grant SELECT on student to test3;
grant select on emp to test3 with grant option;

grant select, insert, update, delete on dept to test3;

--권한취소
/*
REVOKE 권한 [(컬럼[ ,...n ])] [ ,...n ]
[ON 객체] FROM { 사용자Ι롤ΙPUBLIC [ ,...n ]}
[CASCADE CONSTRAINTS]
*/

revoke select on emp from test3;

-----------------------------------------------------------------
-role 데이터베이스 객체에 대한 권한을 모아둔 집합
/*
역할 생성
CREATE ROLE 역할 이름

역할 제거
DROP ROLE 역할이름

역할에 권한 부여
GRANT 권한 [ON 객체] TO 역할이름

역할에 권한 회수
REVOKE 권한 [ON 객체] FROM 역할이름;

사용자에게 역할 부여
GRANT 역할이름 TO 사용자
*/
create role test3;
grant all on test1.emp2 to test3;
grant test3 to test2;

--PASSWORD PROFILE 관련 파라미터
/*
1)FAILED_LOGIN_ATTEMPTS : 로그인 실패 할 경우 계정이 잠기는데 허용될 횟수를 지정
2)PASSWORD_LOCK_TIME : 위 1번의 상황에서 계정이 잠길 기간 설정
3)PASSWORD_LIFE_TIME : 암호를 변경 없이 사용할 수 있는 기간 설정
4)(PASSWORD_REUSE_TIME : 동일한 암호를 쓸 수 없는 기간 설정
5) SWORD_GRACE_TIME : 암호 변경 추가 시간 설정
6)PASSWORD_REUSE_MAX : 동일한 암호를 쓸 수 없는 횟수 설정
7)PASSWORD_VERIFY_FUNCTION : 암호를 복잡하게 만드는 함수 사용
암호는 최소한 4글자 이상 되어야 합니다.
암호는 사용자 계정과 달라야 합니다.
암호는 하나의 특수문자나, 알파벳 , 숫자가 포함되어야 합니다.
암호는 이전 암호와 3글자 이상 달라야 합니다
*/

/*
•예제 1. Password 관련 PROFILE 생성하기
- 조건 1: 로그인 시도 3회 실패 시 계정을 5일 동안 사용 못하게 할 것 
- 조건 2: 계정의 암호는 15일에 한번씩 변경하게 할 것 
- 조건 3: 동일한 암호는 15일 동안 사용 못하게 할 것
CREATE PROFILE sample_prof LIMIT
 FAILED_LOGIN_ATTEMPTS 3
 PASSWORD_LOCK_TIME 54
 PASSWORD_LIFE_TIME 15
 PASSWORD_REUSE_TIME 15 ;
*/

/*
RESOURCE PROFILE 관련 파라미터
- RESOURCE_LIMIT = true
- ALTER SYSTEM SET RESOURCE_LIMIT = true;
- CPU_PER_SESSION : 1 세션당 CPU 를 쓸 수 있는 시간 지정(1/100 초)
- SESSIONS_PER_USER : 1 유저당 동시 접속 가능한 세션 수 지정
- CONNECT_TIME : 접속 가능한 시간 지정 ( 분 단위 )
- IDLE_TIME : 휴면 시간 지정 ( 분 단위 )
- LOGICAL_READS_PER_SESSION : 1 세션에서 사용 가능한 Block 수 지정
- PRIVATE_SGA : MTS / Shared Server 의 경우 세션당 SGA 사용 가능량 지정
- CPU_PER_CALL : 1 세션당 사용 가능한 CPU 시간 지정
- LOGICAL_READS_PER_CALL : 1 call 당 사용 가능한 Block 수 지정
*/

--RESOURCE 관련 PROFILE 만들기
ALTER SYSTEM SET RESOURCE_LIMIT=true ;

--사용자에게 PROFILE 할당하기
--현재 모든 사용자가 적용 받고 있는 PROFILE 확인하기
SELECT username "사용자명" , profile "적용 프로파일"
FROM dba_users
WHERE username=’SCOTT’ ;

--해당 PROFILE 에 어떤 내용이 있는지 확인하기
SELECT * FROM dba_profiles
WHERE PROFILE='SAMPLE_PROF' ;

SELECT * FROM dba_profiles
WHERE profile='RE_SAMPLE_PROF' ;

--사용자에게 PROFILE 적용시키고 확인하기
ALTER USER scott PROFILE sample_prof;
ALTER USER scott PROFILE re_sample_prof;

SELECT username, profile FROM dba_users WHERE username='SCOTT';

--사용 안 하는 PROFILE 삭제하기
DROP PROFILE re_sample_prof CASCADE;

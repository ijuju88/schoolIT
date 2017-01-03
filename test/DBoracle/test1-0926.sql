/*집합연산자*/
/*UNION / UNION ALL ( 두 집합을 더함 )*/
select studno, name, deptno1 from student WHERE deptno1 in(101,102) UNION
select studno, name, deptno1 from student WHERE deptno1 in(101,103);

select studno, name, deptno1 from student WHERE deptno1 in(101,102) UNION ALL
select studno, name, deptno1 from student WHERE deptno1 in(101,103);

/*Student 테이블에서 101번과 201번 학과를 전공하는 학생들의 이름을 출력*/
select name from STUDENT where deptno1=101 UNION ALL
select name from STUDENT where deptno1=201;

/*INTERSECT (교집합)*/
/*stduent 테이블로 101 번 학과와 201 번 학과를 복수전공하는 사람의 이름 출력*/
select name from STUDENT where deptno1 in(101,102) INTERSECT
select name from STUDENT where deptno2 in(101,102);

/*professor 테이블에서 전체 직원의 급여를 20 % 인상하기 위한 직원 명
단을 출력하려 합니다. 단 직급이 전임강사인 사람들은 명단에서 제외하기*/
select * from PROFESSOR MINUS 
select * from PROFESSOR where POSITION like'전임강사' ;

/*단일행 함수 - 문자*/
select LOWER(id), UPPER(id), initcap(id) from STUDENT where deptno1=201;

select name, LENGTH('name'), LENGTHB('name'), id, LENGTH(id), LENGTHB(id) 
from STUDENT;
/*연결 연산자||와 같음 - 그대신 두개만 들어감(여러개 넣으려면 겹쳐서해야함)*/
SELECT CONCAT(name, position) FROM professor WHERE deptno=101;
SELECT CONCAT(CONCAT(name, position), '입니다.') FROM professor WHERE deptno=101;

/*SUBSTR/SUBSTRB - java에서는 시작과 끝위치지만 여기서는 시작과 글자수를 나타냄*/
SELECT SUBSTR('ABCDE', 2,3) FROM dual; /*B부터 3자리*/
SELECT SUBSTR('ABCDE', -2,3)FROM dual; /*오른쪽에서부터2부터라서D부터 - DE만 나옴*/

/*Student 테이블에서 jumin 컬럼을 이용해 태어난 달이 8월인 사람의 이름, 생년월일 출력*/
select name, CONCAT(SUBSTR(JUMIN,1,2),'년') from STUDENT 
where SUBSTR(JUMIN,3,2)=08;

/*뒤에 년월일 붙이기도 합시당*/
select name, 19||SUBSTR(JUMIN,1,2)||'년' ||
SUBSTR(JUMIN,3,2)||'월 '||SUBSTR(JUMIN,5,2)||'일'
from STUDENT;

select name,studno,JUMIN from STUDENT where SUBSTR(JUMIN,7,1)=1;/*자동형변환 원래는 '1'*/

SELECT INSTR('A*B*C*', '*', 1,2) FROM dual;
SELECT INSTR('A*B*C*', '*', -4,1) FROM dual;
SELECT INSTR('A*B*C*', '*', -4,2) FROM dual;
SELECT INSTR('A*B*C*', '*', -2,2) FROM dual;
/*Student 테이블의 tel 컬럼을 사용하여 학생의 이름과 전화번호, ‘)‘ 가
나오는 위치를 출력하세요.*/
select name, tel, instr(tel,')') from STUDENT;

/*Student 테이블을 참조해서 학생의 이름과 전화번호와 지역번호와 (지역번호뺀)번호를를 출력*/
select name, tel, SUBSTR(tel,1,instr(tel,')')-1)지역번호 from STUDENT;
select name, tel, SUBSTR(tel,instr(tel,')')+1)번호 from STUDENT;

/*앞번호 ㅠㅠ*/
select name, tel, SUBSTR(tel,instr(tel,')')+1, 
instr(tel,'-')-(instr(tel,')')+1))국번 from STUDENT;
/*뒷번호 ㅋ*/
select name, tel, SUBSTR(tel,-4,4) from STUDENT;

/*PROFESSOR에서 이메일아이디, 서버만  나오게하기*/
select name, substr(email, 1, instr(email,'@')-1) 아이디 ,
substr(email, instr(email,'@')+1, instr(email,'.')-(instr(email,'@')+1)) 서버 
from PROFESSOR;

/*LPAD,RPAD 문자열 채우기 */
select id, LPAD(id, 10, '#') "LPAD" , RPAD(id, 10, '12345') "RPAD"
from STUDENT where deptno1=101;

select dname, LPAD(dname,10,'1234567890') "LPAD" from DEPT2;

/*LTRIM, RTRIM 문자열 제거*/
select LTRIM(dname,'영'), RTRIM(dname,'부') from dept2;

/*REPLACE 문자열치환 - 경품할때 김** , 010-****-1111 이런거 할때*/
SELECT REPLACE(name, substr(name,1,1),'#') FROM student WHERE deptno1=101;
select dname, TRANSLATE(dname,'팀','부') from dept2; /*문자치환, REPLACE도 됨*/

/*Student 테이블에서 전공(deptno1)이 101 번인 학생
의 이름, 주민등록번호는 주민등록번호의 뒤 7자리 '*’ 로 표시되게 출력*/
select name, jumin, replace(jumin,SUBSTR(jumin,-7,7),'*******')from STUDENT WHERE deptno1=101;
/*Student 테이블에서 전공이 102 번인 학생들의 이름과 전화번호, 전화번호에서 국번 부분만 ‘#’ 처리하여 출력(3자리) */
select name, tel , replace(tel,substr(tel, instr(tel,')')+1, 
instr(tel,'-')-(instr(tel,')')+1)),'###')
from STUDENT where deptno1=102 or deptno2=102;
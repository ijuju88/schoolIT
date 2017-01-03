/*���տ�����*/
/*UNION / UNION ALL ( �� ������ ���� )*/
select studno, name, deptno1 from student WHERE deptno1 in(101,102) UNION
select studno, name, deptno1 from student WHERE deptno1 in(101,103);

select studno, name, deptno1 from student WHERE deptno1 in(101,102) UNION ALL
select studno, name, deptno1 from student WHERE deptno1 in(101,103);

/*Student ���̺��� 101���� 201�� �а��� �����ϴ� �л����� �̸��� ���*/
select name from STUDENT where deptno1=101 UNION ALL
select name from STUDENT where deptno1=201;

/*INTERSECT (������)*/
/*stduent ���̺�� 101 �� �а��� 201 �� �а��� ���������ϴ� ����� �̸� ���*/
select name from STUDENT where deptno1 in(101,102) INTERSECT
select name from STUDENT where deptno2 in(101,102);

/*professor ���̺��� ��ü ������ �޿��� 20 % �λ��ϱ� ���� ���� ��
���� ����Ϸ� �մϴ�. �� ������ ���Ӱ����� ������� ��ܿ��� �����ϱ�*/
select * from PROFESSOR MINUS 
select * from PROFESSOR where POSITION like'���Ӱ���' ;

/*������ �Լ� - ����*/
select LOWER(id), UPPER(id), initcap(id) from STUDENT where deptno1=201;

select name, LENGTH('name'), LENGTHB('name'), id, LENGTH(id), LENGTHB(id) 
from STUDENT;
/*���� ������||�� ���� - �״�� �ΰ��� ��(������ �������� ���ļ��ؾ���)*/
SELECT CONCAT(name, position) FROM professor WHERE deptno=101;
SELECT CONCAT(CONCAT(name, position), '�Դϴ�.') FROM professor WHERE deptno=101;

/*SUBSTR/SUBSTRB - java������ ���۰� ����ġ���� ���⼭�� ���۰� ���ڼ��� ��Ÿ��*/
SELECT SUBSTR('ABCDE', 2,3) FROM dual; /*B���� 3�ڸ�*/
SELECT SUBSTR('ABCDE', -2,3)FROM dual; /*�����ʿ�������2���Ͷ�D���� - DE�� ����*/

/*Student ���̺��� jumin �÷��� �̿��� �¾ ���� 8���� ����� �̸�, ������� ���*/
select name, CONCAT(SUBSTR(JUMIN,1,2),'��') from STUDENT 
where SUBSTR(JUMIN,3,2)=08;

/*�ڿ� ����� ���̱⵵ �սô�*/
select name, 19||SUBSTR(JUMIN,1,2)||'��' ||
SUBSTR(JUMIN,3,2)||'�� '||SUBSTR(JUMIN,5,2)||'��'
from STUDENT;

select name,studno,JUMIN from STUDENT where SUBSTR(JUMIN,7,1)=1;/*�ڵ�����ȯ ������ '1'*/

SELECT INSTR('A*B*C*', '*', 1,2) FROM dual;
SELECT INSTR('A*B*C*', '*', -4,1) FROM dual;
SELECT INSTR('A*B*C*', '*', -4,2) FROM dual;
SELECT INSTR('A*B*C*', '*', -2,2) FROM dual;
/*Student ���̺��� tel �÷��� ����Ͽ� �л��� �̸��� ��ȭ��ȣ, ��)�� ��
������ ��ġ�� ����ϼ���.*/
select name, tel, instr(tel,')') from STUDENT;

/*Student ���̺��� �����ؼ� �л��� �̸��� ��ȭ��ȣ�� ������ȣ�� (������ȣ��)��ȣ���� ���*/
select name, tel, SUBSTR(tel,1,instr(tel,')')-1)������ȣ from STUDENT;
select name, tel, SUBSTR(tel,instr(tel,')')+1)��ȣ from STUDENT;

/*�չ�ȣ �Ф�*/
select name, tel, SUBSTR(tel,instr(tel,')')+1, 
instr(tel,'-')-(instr(tel,')')+1))���� from STUDENT;
/*�޹�ȣ ��*/
select name, tel, SUBSTR(tel,-4,4) from STUDENT;

/*PROFESSOR���� �̸��Ͼ��̵�, ������  �������ϱ�*/
select name, substr(email, 1, instr(email,'@')-1) ���̵� ,
substr(email, instr(email,'@')+1, instr(email,'.')-(instr(email,'@')+1)) ���� 
from PROFESSOR;

/*LPAD,RPAD ���ڿ� ä��� */
select id, LPAD(id, 10, '#') "LPAD" , RPAD(id, 10, '12345') "RPAD"
from STUDENT where deptno1=101;

select dname, LPAD(dname,10,'1234567890') "LPAD" from DEPT2;

/*LTRIM, RTRIM ���ڿ� ����*/
select LTRIM(dname,'��'), RTRIM(dname,'��') from dept2;

/*REPLACE ���ڿ�ġȯ - ��ǰ�Ҷ� ��** , 010-****-1111 �̷��� �Ҷ�*/
SELECT REPLACE(name, substr(name,1,1),'#') FROM student WHERE deptno1=101;
select dname, TRANSLATE(dname,'��','��') from dept2; /*����ġȯ, REPLACE�� ��*/

/*Student ���̺��� ����(deptno1)�� 101 ���� �л�
�� �̸�, �ֹε�Ϲ�ȣ�� �ֹε�Ϲ�ȣ�� �� 7�ڸ� '*�� �� ǥ�õǰ� ���*/
select name, jumin, replace(jumin,SUBSTR(jumin,-7,7),'*******')from STUDENT WHERE deptno1=101;
/*Student ���̺��� ������ 102 ���� �л����� �̸��� ��ȭ��ȣ, ��ȭ��ȣ���� ���� �κи� ��#�� ó���Ͽ� ���(3�ڸ�) */
select name, tel , replace(tel,substr(tel, instr(tel,')')+1, 
instr(tel,'-')-(instr(tel,')')+1)),'###')
from STUDENT where deptno1=102 or deptno2=102;
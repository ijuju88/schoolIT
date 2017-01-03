select deptno, job, count(*), sum(sal), round(avg(sal)) from emp 
GROUP BY deptno, job;
--GROUP BY cube(deptno, job) �Ұ�+��;
--GROUP BY ROLLUP(deptno, job) �Ұ�;
--GROUP BY DEPTNO HAVING avg(sal)>=2000;

select deptno1, LISTAGG(name, ', ') WITHIN GROUP (ORDER BY name)
from STUDENT GROUP BY DEPTNO1;

/*Professor ���̺��� ����Ͽ� ���� �߿��� �޿�(Pay)�� ���ʽ�(bonus)�� ��
ģ �ݾ��� ���� ���� ���� ���� ���� ��� , ��� �ݾ��� ���ϼ���. �� ���ʽ�
�� ���� ���� ���ʽ��� 0 ���� ����ϰ� ��� �ݾ��� ��� �Ҽ��� ù° �ڸ�
������ ������ �ϼ���.*/
select max(PAY+nvl(BONUS,0)) MAX, min(PAY+nvl(BONUS,0)) MIN, 
to_char(avg(PAY+nvl(BONUS,0)),'999.9') AVG from PROFESSOR;

/*Professor ���̺��� ����Ͽ� ���� �߿��� �޿�(Pay)�� ���ʽ�(bonus)��
��ģ �ݾ��� ���� ���� ���� ���� ���� ��� , ��� �ݾ��� ���ϼ���. �� ��
�ʽ��� ���� ���� �޿��� 0 ���� ����ϰ� ��� �ݾ��� ��� �Ҽ��� ù°
�ڸ������� ������ �ϼ���.*/
select max(NVL2(BONUS,pay+BONUS, pay*0)) MAX, 
min(NVL2(BONUS,pay+BONUS, pay*0)) MIN, 
ROUND(avg(NVL2(BONUS,pay+BONUS, 0)),1)AVG from PROFESSOR;

/*Student ���̺��� birthday Į���� ����Ͽ� �Ʒ� ȭ��ó�� ������ �¾
�ο����� ����ϼ���.*/

select count(*) �հ�, 
count(decode(SUBSTR(jumin,3,2),01,0)) "1��",
count(decode(SUBSTR(jumin,3,2),02,0)) "2��",
count(decode(SUBSTR(jumin,3,2),03,0)) "3��",
count(decode(SUBSTR(jumin,3,2),04,0)) "4��",
count(decode(SUBSTR(jumin,3,2),05,0)) "5��",
count(decode(SUBSTR(jumin,3,2),06,0)) "6��",
count(decode(SUBSTR(jumin,3,2),07,0)) "7��",
count(decode(SUBSTR(jumin,3,2),08,0)) "8��",
count(decode(SUBSTR(jumin,3,2),09,0)) "9��",
count(decode(SUBSTR(jumin,3,2),10,0)) "10��",
count(decode(SUBSTR(jumin,3,2),11,0)) "11��",
count(decode(SUBSTR(jumin,3,2),12,0)) "12��"
from STUDENT;

/*Student ���̺��� tel Į���� �����Ͽ� �Ʒ��� ���� ������ �ο����� ���.
(02 ?���� , 031 ? ��� , 051 ? �λ� , 052 ? ��� , 053 ? �뱸 , 055 ? �泲)
*/

select count(*) �հ�, 
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),02,0))"����",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),031,0))"���",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),051,0))"�λ�",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),052,0))"���",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),053,0))"�뱸",
count(DECODE(SUBSTR(tel,1,INSTR(tel, ')')-1 ),055,0))"�泲"
from STUDENT;

/*Emp ���̺��� ����Ͽ� �Ʒ��� ȭ��� ���� �μ����� ���޺��� �޿� �հ�
����� ����ϼ���. ���� �Ʒ��� �� ���� �����͸� �Է� �Ͻ� �� �۾��ϼ���.*/
insert into emp (empno , deptno , ename , sal)
values (1000,10,'ȫ�浿',3600) ;

insert into emp (empno , deptno , ename , sal)
values (2000,30,'������',3000);

select deptno, 
sum(DECODE(job,'CLERK',sal, 0)) CLERK,
sum(DECODE(job,'MANAGER',sal, 0)) MANAGER,
sum(DECODE(job,'PRESIDENT',sal, 0)) PRESIDENT,
sum(DECODE(job,'ANALYST',sal, 0)) ANALYST,
sum(DECODE(job,'SALESMAN',sal, 0)) SALESMAN,
sum(nvl2(job,sal, 0)) �հ�
from emp group by cube(deptno) order by 1;

--LAG �Լ�(�������� ���� �����ö�)
/*
LAG(����� �÷��� , OFFSET , �⺻ ��°�) 
OVER (Query_partition���� , ORDER BY ������ �÷�)
*/
select name,HIREDATE, pay, 
LAG(pay, 1, 0) OVER (ORDER BY HIREDATE) lag from PROFESSOR;

select name,HIREDATE, pay, 
LAG(pay, 3, 2) OVER (ORDER BY HIREDATE) lag from PROFESSOR;
--LEAD �Լ� (������ ���� �����ö�)
select name,HIREDATE, pay, 
LEAD(pay, 1, 0) OVER (ORDER BY HIREDATE) lag from PROFESSOR;

select name,HIREDATE, pay, 
LEAD(pay, 3, 2) OVER (ORDER BY HIREDATE) lag from PROFESSOR;

--RANK �Լ�
select profno, name, pay, 
RANK() OVER(ORDER BY pay) RANK, RANK() OVER(ORDER BY pay DESC) RANK_DESC
from PROFESSOR;

select CONCAT(name, POSITION) from PROFESSOR;
select name �̸�, SUBSTR( JUMIN,3,2) �� from STUDENT;
select name, tel from STUDENT where SUBSTR(tel, 1,INSTR(tel,')')-1)=055;

select name, SUBSTR(tel,-4,4) ��ȭ��ȣ,
SUBSTR(tel,INSTR(tel,')')+1, INSTR(tel,'-')-INSTR(tel,')')-1)����
from STUDENT;

select REPLACE(name,SUBSTR(name, 2,1),'#'),
REPLACE(tel,SUBSTR(tel,-4,4),'####')
from STUDENT;
--�����Լ�
select ROUND(12.345) ROUND1, ROUND(12.345,2) ROUND2, ROUND(12.345, -1) ROUND3
from dual; /*�ݿø�*/
select TRUNC(12.345) TRUNC1, TRUNC(12.345,2) TRUNC2, TRUNC(12.345, -1) TRUNC3
from dual;/*����*/
--MOD(������), CEIL(������ ū ����), FLOOR(������ ���� ����)
select MOD(12,10) MOD, CEIL(12.345) CEIL, FLOOR(12.345) FLOOR from dual;
SELECT POWER(3,2) FROM dual;/*3�� 2��*/

--��¥�Լ�
select SYSDATE from dual; --sysdate : ��ǻ�� ���糯¥

ALTER SESSION SET NLS_DATE_FORMAT='yyyy-mm-dd hh24:mi:ss'; --��¥ ���� �ٲٱ�
SELECT SYSDATE FROM dual;
--MONTHS_BETWEEN : ������ ��¥ ���ϱ� (��쿡 ���� �ٸ�)
SELECT MONTHS_BETWEEN('2012-03-01', '2012-01-01') FROM dual;
SELECT MONTHS_BETWEEN('2012-02-29', '2012-01-31') FROM dual;
SELECT MONTHS_BETWEEN('2012-01-31', '2012-01-01') FROM dual;
select MONTHS_BETWEEN(sysdate,'2016-01-01') from dual;

/*�������̺��� deptno=101�϶� hiredate�� SYSDATE�� �̿� �ٹ� ���� �� 
���ϱ� �Ҽ��� 2�ڸ����� �ݿø�*/
select hiredate, ROUND(MONTHS_BETWEEN(sysdate, HIREDATE),2) �ٹ������� from PROFESSOR where deptno=101;
       
-- ADD_MONTHS(��¥ ���ϱ�(��)), NEXT_DAY(�ش糯¥ ������ ���Ͽ� �ش��ϴ� ��¥ ���ϱ�)
-- LAST_DAY(�ش糯¥�� ������ ������ ��¥ ���ϱ�)
SELECT ADD_MONTHS(SYSDATE, 3)"ADD_MONTHS",
NEXT_DAY(SYSDATE,'��') ������, LAST_DAY(SYSDATE) ��������
from dual;
--ROUND(�ݿø�), TRUNC(����)
SELECT SYSDATE, ROUND(SYSDATE), TRUNC(SYSDATE) FROM dual;

--����ȯ
SELECT 1 + '1' FROM dual; --�ڵ����� �Ʒ��� ���� ����ȯ��
SELECT 1 + to_number('1') FROM dual ;
--SELECT 1 + 'A' FROM dual;--�ȵ�

--TO_CHAR �Լ�
SELECT TO_CHAR(SYSDATE, 'YYYY') "YYYY", TO_CHAR(SYSDATE, 'RRRR') "RRRR", 
TO_CHAR(SYSDATE, 'YY') "YY", TO_CHAR(SYSDATE, 'YEAR') "YEAR" FROM dual;

select TO_CHAR(SYSDATE, 'MM')MM,TO_CHAR(SYSDATE, 'MON')
MON, TO_CHAR(SYSDATE, 'MONTH') MONTH from dual;

SELECT TO_CHAR(SYSDATE, 'DD') DD,TO_CHAR(SYSDATE, 'DAY') DAY,
TO_CHAR(SYSDATE, 'DDTH') DDTH FROM dual;

select TO_CHAR(SYSDATE, 'YYYY-MM-DD:HH24:MI:SS') from dual;

/*Student ���̺��� birthday Į���� ����, ������ 3���� �л��� �̸��� birthday ���*/
select name, TO_CHAR(BIRTHDAY, 'YYYY-MM-DD:HH24:MI:SS') birthday 
from STUDENT where to_char(BIRTHDAY, 'MM')=03;

/*professor ���̺��� 101�� �а� �������� �̸��� ������ ����ϼ���. 
�� ������ (pay *12)+bonus �� ����Ͻð� õ ���� ���б�ȣ�� ǥ���ϼ���.*/
select TO_CHAR((pay*12)+NVL(BONUS,0),'99,999') from PROFESSOR
where BONUS is not null and deptno=101; --NVL ���ִ� �մϴ�, null���� �ش簪����~

--TO_NUMBER
select to_number('1') from dual;
--TO_DATE
select to_date('2014-01-01', 'yyyy-mm-dd') from dual;

/*Professor ���̺��� ����Ͽ� 1990�� ������ �Ի��� ������ �� �Ի���,
���� ������ 10% �λ� �� ������ ����ϼ���. ������ �󿩱�(bonus)��
������ (pay*12) �� ����ϰ� ������ �λ� �� ������ õ ���� ���� ��ȣ��
�߰��Ͽ� ����ϼ���.*/
select name, TO_CHAR(HIREDATE, 'YYYY-MM-DD')�Ի��� , 
TO_CHAR(pay*12, '99,999') ����, TO_CHAR((pay*12)*(1+0.1), '99,999') �λ���
from PROFESSOR where HIREDATE<'1990-01-01';


--�Ϲ��Լ�
--NUL�� ���� ������ ������
Select TO_CHAR(NVL2(BONUS,(pay*12)+BONUS,(pay*12)),'99,999') from PROFESSOR
where deptno=101;

select ename, sal, nvl(comm,0), sal+nvl(comm,0) ����, 
(sal+nvl(comm,0))*0.1 ����  from emp;
select ename, sal, nvl(comm,0), nvl2(comm,sal+comm, sal) ����, 
nvl2(comm,sal+comm, sal*0.1) ����  from emp;

--DECODE if���� DECODE (A, B, ��1��, null) - A=B�̸� 1, �ƴϸ� null(��������)
/*professor ���̺��� ������� �а���ȣ , �а����� ����ϵ� 
deptno �� 101 ���� ������ ��ǻ�� ���а��� ����ϰ� 101���� �ƴ� 
�������� �а��� �ƹ��͵� ������� ������*/
select name, DECODE(deptno,101,'��ǻ�� ���а�', '��Ÿ')deptno from PROFESSOR;

/*Professor ���̺��� ������ �̸��� �а����� ����ϵ� 
�а� ��ȣ�� 101 �� �̸� ����ǻ�� ���а��� , 102 ���̸� ����Ƽ�̵�� ���а��� , 
103 ���̸� ������Ʈ������а� �� �������� ����Ÿ�а��� �� ����ϼ���.*/
select name, DECODE
(deptno,101,'��ǻ�� ���а�',102,'��Ƽ�̵�� ���а�',103,'����Ʈ������а�', '��Ÿ')
deptno from PROFESSOR;

select ename, decode(deptno,10,'����',20,'��ȹ',30 ,'ȫ��') �μ� from emp;

--DECODE�Լ��� ��ø if DECODE ( A , B , DECODE( A , C , ��1�� , ��2�� ) ��2�� )
/*professor ���̺��� ������ �̸��� �μ���ȣ�� ����ϰ� 101 �� �μ� �߿��� 
�̸��� ������ �������� ���±��� �ĺ���� ���. �������� NULL ���� ���*/
select name, deptno, decode(deptno, 101, decode(name, '������','���±���', '�ٸ�����'),'��Ÿ')���
from PROFESSOR;
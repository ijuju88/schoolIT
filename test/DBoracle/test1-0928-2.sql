--count �Լ�
select count(*), count(hpage) from PROFESSOR;

--sum �Լ�
select count(bonus), sum(bonus) from PROFESSOR;

--avg �Լ�
select count(bonus), sum(bonus), avg(bonus), avg(nvl(bonus,0)) 
from PROFESSOR;

--max/ min �Լ� (�ӵ��� ���ɹ����� �ɼ� �־� �ε����� Ȱ���� ����� ���� ����)
select max(pay), min(pay) from PROFESSOR;

--stddev/variance �Լ� (ǥ������/ �л�)
select stddev(pay), VARIANCE(pay) from PROFESSOR; 

----------------------------------------------------------------------------

--GROUP BY �� (Ư���������� �׷�ȭ�ϱ�)
SELECT deptno,count(deptno), to_char(AVG(NVL(pay,0)),'999.99')"��ձ޿�" 
FROM professor GROUP BY deptno order by deptno;

--�׷��Լ��� ������ �ʵ�� �ü� �ֽ��ϴ�.
--SELECT deptno,count(deptno), to_char(AVG(NVL(pay,0)),'999.99')"��ձ޿�", name  
--FROM professor GROUP BY deptno order by deptno;
--������ ���� �����ϸ� �����մϴ�.
--���⼭�� �׷������ deptno, name���� �Ǿ��ֽ��ϴ�
SELECT deptno,count(deptno), to_char(AVG(NVL(pay,0)),'999.99')"��ձ޿�", name  
FROM professor GROUP BY deptno, name order by deptno;

--�׷���� : deptno, job
--GROUP BY ���� ���� Į���� SELECT ���� ������ �ʾƵ� �˴ϴ�. deptno, job
select deptno, job, count(deptno), round(avg(sal)) from emp 
GROUP by deptno, job;

select count(deptno), round(avg(sal)) from emp 
GROUP by deptno, job;
----------------------------------------------------------------------------

--having ��(GROUP BY ������ ���ǳֱ� where�� �ƴ�!!)
/*SELECT deptno, AVG(NVL(pay,0)) FROM professor 
WHERE AVG(pay)>450 GROUP BY deptno;*/

--������ GROUP BY�� ������ ���ϴ�.
--avg(pay)�� 450 �̻��� �͸� deptno�� �������� ������ ���
SELECT deptno, AVG(NVL(pay,0)) FROM professor
GROUP BY deptno HAVING AVG(pay)>450;

SELECT deptno dno, count(deptno), round(avg(sal)) from emp
group by deptno having avg(sal)>2000 order by deptno;

select grade, avg(height) from STUDENT GROUP BY grade HAVING avg(height)>175;

--�׷��ٰ� where���� �ȵ��°� �ƴմϴٸ�....
select position, round(avg(pay)) from emp2 where EMP_TYPE='������'
GROUP BY POSITION HAVING avg(pay)>50000000;

----------------------------------------------------------------------------
--�̴��� ���ʹ� �߻����մϴ�.
----------------------------------------------------------------------------

--rollup�Լ�(�Ұ谪���ϱ�-���ƿ� ����)
select deptno, job, count(*) from emp GROUP BY deptno, job;

--deptno���� job�� ���~~~
select deptno, job, count(*) from emp GROUP BY ROLLUP(deptno, job);

--�Ұ�� deptno���� �ϰ� position�� �������� ���
SELECT deptno, position, SUM(pay) FROM professor 
GROUP BY position, ROLLUP(deptno);

--�Ұ�� position���� �ϰ� deptno�� �������� ���
SELECT deptno, position, SUM(pay) FROM professor
GROUP BY deptno, ROLLUP(position);

----------------------------------------------------------------------------

--cube �Լ� (�Ұ�+�Ѱ�)
select deptno, job, count(*) from emp GROUP BY cube(deptno, job);

--grouping �Լ� (�׷��� �۾��� ��� ���� Ȯ���ϱ� 1=���x 0=���o)
--�Ʒ��� ��� �ǹؿ� ������ �Ұ踦 ������ ���̶� �׷����� �Ǿ����� ����
SELECT deptno, SUM(pay), GROUPING(deptno) g_deptno FROM professor
GROUP BY ROLLUP(deptno);

SELECT deptno, position, SUM(pay),
GROUPING(deptno) g_deptno, GROUPING(position)g_position from PROFESSOR
GROUP BY ROLLUP(deptno, POSITION);

--group_id �Լ� 
/*
  (GROUPING �÷�)(���)
      A, B         0  --��Į�� �� ���
        A          1  --AĮ���� ���
        B          2  --BĮ���� ���
        -          3  --��Į�� �� ��� x
*/
SELECT deptno, position, SUM(pay), 
GROUPING_ID(deptno, position) g_dp, GROUPING_ID(position, deptno) g_pd
from PROFESSOR GROUP BY ROLLUP(deptno, POSITION);

----------------------------------------------------------------------------

--grouping sets

--����
SELECT grade, COUNT(*) FROM student 
GROUP BY(grade) UNION SELECT deptno1, COUNT(*) 
FROM student GROUP BY(deptno1);

--���
SELECT grade, COUNT(*) FROM student
GROUP BY GROUPING SETS(grade,deptno1);

----------------------------------------------------------------------------

--LISTAGG �Լ�(11g���� �߰���)
--���� : LISTAGG(list_column, [�������ڡ�]) WITHIN GROUP(ORDER BY column)
SELECT deptno, LISTAGG(name, '**') WITHIN GROUP(ORDER BY hiredate)
"LISTAGG" FROM professor GROUP BY deptno;

----------------------------------------------------------------------------

select max(PAY+nvl(BONUS,0)), min(PAY+nvl(BONUS,0)), 
to_char(avg(PAY+nvl(BONUS,0)),'999.9')from PROFESSOR;

select max(PAY+nvl(BONUS,0)), min(PAY+nvl(BONUS,0)), 
to_char(avg(PAY+nvl(BONUS,0)),'999.9')from PROFESSOR;
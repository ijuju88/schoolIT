--Cartesian Product - �� ���̺� ����� ��� ���� ���� ����� ����� ��
/*
���̺�1  ���̺�2   ���
------- -------  ---------
  A 1    1 ��     A 1 1 ��
  B 2    2 ��     A 1 2 ��
                 B 2 1 ��
                 B 2 2 ��

Oracle Join ����
��--------------------------��
��SELECT e.ename , d.dname  ��
��FROM emp e, dept d ;      ��
��--------------------------��
ANSI Join ���� --ǥ�������� (��� sql���� ��밡��)
��--------------------------------��
��SELECT e.ename , d.dname        ��
��FROM emp e CROSS JOIN dept d ;  ��
��--------------------------------��
*/
select e.ename, e.deptno ,d.deptno, d.dname
from emp e, dept d;

select e.ename, e.deptno ,d.deptno, d.dname
from emp e CROSS JOIN dept d;

--EQUI Join (� Join) - ���� ���̺� ���� ������ ������ ����� ���� ���� ��
/*
Oracle Join ����
��-------------------------------------------------------------��
��SELECT s.name "�л��̸�", s.deptno1 "�а���ȣ", d.dname "�а���" ��
��FROM student s, department d                                 ��
��WHERE s.deptno1=d.deptno;                                    ��
��-------------------------------------------------------------��
ANSI Join ����
��-------------------------------------------------------------��
��SELECT s.name "�л��̸�", s.deptno1 "�а���ȣ", d.dname "�а���" ��
��FROM student s JOIN department d                             ��
��ON(s.deptno1=d.deptno);                                      ��
��-------------------------------------------------------------��
*/
select s.name, s.profno, p.name
from student s, professor p where s.PROFNO=p.PROFNO;

select s.name, s.profno, p.name
from student s JOIN professor p on(s.PROFNO=p.PROFNO);

--�ǽ��ϱ�
select s.name, p.name
from student s JOIN PROFESSOR p on(s.PROFNO=p.PROFNO);

--3���� ���̺� �����ϱ�
/*
�л� ���̺�(student)�� �а� ���̺�(department) , ���� ���̺�(professor) 
�� Join�Ͽ� �л��� �̸��� �а��̸�, �������� �̸��� ���
*/
select s.name �л��̸�, d.dname �а��̸�, p.name �����̸�
 from student s, DEPARTMENT d, PROFESSOR p
 where s.DEPTNO1=d.DEPTNO and d.DEPTNO=p.DEPTNO;
 
select s.name �л��̸�, d.dname �а��̸�, p.name �����̸�
 from student s JOIN DEPARTMENT d on(s.DEPTNO1=d.DEPTNO)
 JOIN PROFESSOR p on(d.DEPTNO=p.DEPTNO);
 
/*
emp2 ���̺�� p_grade ���̺��� ��ȸ�Ͽ� ����� �̸��� 
����, ���� ����, �ش� ������ ������ ���ѱݾװ� ���� �ݾ��� ���
*/
select e.NAME ����̸�, e.POSITION ��������, e.PAY ���翬��,
 pg.s_PAY ���ѱݾ�, pg.E_PAY ���ѱݾ�
from emp2 e, p_grade pg 
where e.POSITION=pg.POSITION;

select e.NAME ����̸�, e.POSITION ��������, e.PAY ���翬��,
 pg.s_PAY ���ѱݾ�, pg.E_PAY ���ѱݾ�
 from emp2 e JOIN P_GRADE pg on(e.POSITION=pg.POSITION);

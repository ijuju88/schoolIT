DESC EMP;
SELECT * FROM tabs;
SELECT * FROM emp;
/*emp���̺� �߿��� name, job, sal �ʵ常 ��ȸ�˴ϴ�*/
SELECT ename, job, sal FROM emp;
/*job�߿� CLERK�� ��ġ�ϴ°� ã���ϴ�*/
SELECT * FROM emp WHERE job='CLERK';
/*������ ��+�ؼ� ��� - ���տ�����||*/
SELECT ename||'����� �޿���' ||sal|| '�Դϴ�' FROM emp;
SELECT * FROM student;
SELECT name||'�л��� Ű��'||HEIGHT ||'�̰� �����Դ�' || weight ||'�Դϴ�.' "�̸�_Ű_������" FROM student;
/*��Ī����ϱ�*/
SELECT studno AS "�й�", name "�̸�", height Ű FROM student;
SELECT empno �����ȣ, ename �����, job ���� FROM emp;
SELECT DEPTNO AS "�μ�#", dname AS "�μ���", loc AS "��ġ" FROM dept;
SELECT DISTINCT deptno FROM emp;
/*�̸�+(~����)�� ����ϱ�*/
select name|| '('||position||')' from professor;
/*����*/
select ename, sal, sal+100, sal+100/2, (sal+100)/2 from emp;
select ename, sal, sal*12+comm from emp;
 /*emp���̺��� ename, sal, sal*12+comm�� �����
   �̷� ��� comm���� null�� ���� ���ص� null�� ��µǴ� ������ ���ɴϴ�
   �׷��� �Ʒ��� ���� �����մϴ�
*/

/*���ǰ˻� where*/
select ename, sal, sal*12+comm from emp where comm is not NULL; /*���߿� comm���� null�� �ƴѰ��� �����*/
select ename, job, deptno from emp where deptno=10;
select name, position from professor where POSITION='������';
/*��¥ �˻��ϱ� - �Ի����� 2000-01-01������ ����� ���*/
select * from PROFESSOR where HIREDATE<'2000-01-01';

select name, height from STUDENT where HEIGHT>=180;
select name, height from STUDENT where HEIGHT BETWEEN 175 and 180; /*HEIGHT>=175 and HEIGHT<=180*/
select name, deptno1 from STUDENT where deptno1 in(101,201);/*deptno1=101 or deptno1=201*/
select name, height, weight from student where  height>=180 and weight<=70;
select name, height, weight from student where height<170 or weight>75;

select name, deptno1 from student where name Like '��%';
select name, position form from professor where POSITION Like'%����';

select name,grade, height from STUDENT where grade=4 and height>170;
select name, HEIGHT, GRADE, WEIGHT from student where WEIGHT>=80 or GRADE=1;
select name, GRADE, HEIGHT, WEIGHT from student 
where grade=2 and (HEIGHT>180 and WEIGHT>170);

select name, GRADE, HEIGHT, WEIGHT from student
where grade=2 and (HEIGHT>180 or WEIGHT>170);

select * from Professor where name BETWEEN '��'and '��';

/*�����ϱ� order by*/
select name from student order by name;
select ename, deptno, sal from emp order by deptno,sal desc;

/*��������*/
select name, pay, position from emp2 where pay>=50000000;

select name"�̸�", pay"�޿�", pay*0.5 as "���ʽ�", pay*0.1 as "����" from emp2;

select * from emp2 where hobby in('�', '������Ÿ��', '������','���');

select name, hpage from PROFESSOR where id like 's%';

select name, HPAGE from PROFESSOR where HPAGE is not null;

select name, POSITION, HIREDATE from PROFESSOR 
where HIREDATE>'1990-01-01' and POSITION in('������','������');

select name, pay from emp2 where pay between 30000000 and 50000000;

select name, id, POSITION from PROFESSOR 
order by Position, id desc;

select name,HEIGHT, WEIGHT from student where HEIGHT>=180 and WEIGHT<=70 order by name asc;

select ename, job, sal from emp where job='SALESMAN' order by sal desc;
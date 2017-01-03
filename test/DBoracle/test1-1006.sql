--INSERT ������ �Է�~~
/*������ 
INSERT INTO table [(column1, column2,����)] 
VALUES (value 1 , value 2,��.) ;

-- Į������ �� �Է��ҰŸ� [(column1, column2,����)] �� �����ص� �˴ϴ�
*/

desc dept2;
--�ѱ��� ���������� ���������մϴ�
alter table dept2 MODIFY(pdept varchar2(20));

insert into dept2(dcode, dname, pdept, area)
VALUES (9000,'Ư��1��','������','�ӽ�����');
--Į�� ������ �ٲپ� �����ø� �ؿ� valuse���� �°� �־��ݽô�
insert into dept2(dname, dcode, pdept, area)
VALUES('Ư��2��', 9001, '������','��������');

insert into dept2 VALUES(9002,'Ư��3��', '������', '�ӽ�����');
select * from dept2;

--Ư��Į���� �Է��մϴ� : pdept,area�� null ���� ���� �Ǵ�...
insert into dept2(dcode, dname, area) VALUES(9003, 'Ư��4��', '��������');
--�̷��Ե� �����մϴ�(Į���� ������..--;)
insert into dept2 VALUES(9004,'Ư��5��', '������', null);

--��¥ ������ �Է��ϱ� (�ü������ ��¥������ �ٸ��Ƿ� �������ּ��� >_-)
insert into PROFESSOR(profno, NAME, id, position, pay, hiredate)
VALUES(5001,'�輳��','Love_me','������',501,'2011-11-14');

select * from PROFESSOR;

--�������� �Է��սô�(as)
--������ �����Ҷ��ϴ� ����
CREATE TABLE professor2 AS SELECT * FROM professor where 1=2;
--drop table professor2;
--professor���̺�  position='������' �� ����� PROFESSOR2���̺� �������ϴ�.
insert into PROFESSOR2 select * from professor where position='������';
select * from PROFESSOR2;

--�ٸ����̺��� ������ �����ͼ� �Է��ϱ�
/*
Professor ���̺��� 
������ȣ�� 1000 �� ���� 1999������ �� ������ ��ȣ�� 
�����̸��� p_01 ���̺� �Է��ϰ� ������ȣ�� 2000 ������ 2999 ������
�� ������ ��ȣ�� �̸��� p_02 ���̺� �Է��ϼ���.
*/
INSERT ALL
 WHEN profno BETWEEN 1000 AND 1999 THEN
 INTO p_01 VALUES(profno,name)
 WHEN profno BETWEEN 2000 AND 2999 THEN
 INTO p_02 VALUES(profno,name)
 SELECT profno,name
 FROM professor ;
 
select * from p_02;

--����
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

--�ٸ� ���̺� ���ÿ� ���� ������ �Է��ϱ�
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
 
--����
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

--UPDATE ����
/*
UPDATE table
SET column = value
WHERE ���� ;
*/
update PROFESSOR set BONUS=100 where POSITION='������';

--�������� ������ �̹����� ���Ӱ���� �������� PROFESSOR2���̺� �־�ô�
insert into PROFESSOR2 select * from PROFESSOR where position in('������','���Ӱ���');
--update�� �����մϴ�
update PROFESSOR2 set BONUS=50 where POSITION='���Ӱ���';

update PROFESSOR2 set pay=pay*(1+0.1),BONUS=BONUS*(1+0.1) where POSITION='������';
select * from PROFESSOR2;

--������ �������϶�~~ ���������� ����մϴ� ���߿� �ڼ��ϰ� ���ϴ�
/*
Professor ���̺��� ����ö ������ ���ް� ������ ������ ���� ������ �� 
���� �޿��� 350 ������ �� �Ǵ� �������� �޿��� 15% �λ�
*/
update PROFESSOR set pay=pay*1.15
 where position=(
 select position from PROFESSOR where name='����ö')
 and pay<350;

select * from PROFESSOR;

--delete - �����ͻ���
DELETE FROM dept2
 WHERE dcode between 9000 and 9100 ;
delete from PROFESSOR2;
--���ø� �����͸� �������ϴ� ��
select * from PROFESSOR2;

--MERGE: ���̺� ��ġ�� (���������~~;)
/*
MERGE INTO Table1(������ �������̺�)
USING Table2(�ش����̺�)
ON ( ���� ������ )
WHEN MATCHED THEN
UPDATE SET ������Ʈ ����
DELETE WHERE ����
WHEN NOT MATCHED THEN
INSERT VALUES(�÷� �̸�) ;
*/
--MERGE �۾� QUERY 1 (pt_01 ���̺�� p_total ���̺� ����)
 --total, p01�� ��Ī�Դϴ�
merge into p_total total
 using pt_01 p01
 on(total.�ǸŹ�ȣ=p01.�ǸŹ�ȣ)
 when MATCHED then
 UPDATE set total.��ǰ��ȣ=p01.��ǰ��ȣ
 when not MATCHED then
 insert values(p01.�ǸŹ�ȣ, p01.��ǰ��ȣ, p01.����, p01.�ݾ�);
 
--���������� pt_02�� �غ��ϴ�
merge into p_total total
 using pt_02 p02
 on(total.�ǸŹ�ȣ=p02.�ǸŹ�ȣ)
 when MATCHED then
 UPDATE set total.��ǰ��ȣ=p02.��ǰ��ȣ
 when not MATCHED then
 insert values(p02.�ǸŹ�ȣ, p02.��ǰ��ȣ, p02.����, p02.�ݾ�);
 
 select * from p_total;
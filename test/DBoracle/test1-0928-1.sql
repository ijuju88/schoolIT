select name �̸�, TO_CHAR(HIREDATE, 'YYYY-MM-DD') ����� from PROFESSOR;

select name �̸�, TO_CHAR(PAY, '999,999,999') ���� from emp2;

select name, pay, nvl(bonus,0) ���ʽ�, TO_CHAR(pay*12+nvl(bonus,0)) ���� from PROFESSOR;
select name, pay, nvl(bonus,0) ���ʽ�, nvl2(bonus,pay*12+BONUS, pay*12) ���� from PROFESSOR;

select name, height, weight, case 
when height-weight>120 then '��ü��'
when height-weight>=110 then '����'
when height-weight>=100 then '��ü��'
else'��' end as �񸸵�
from STUDENT;

select name, height, weight, case 
when height-weight BETWEEN 0 and 100 then '��'
when height-weight BETWEEN 101 and 110 then '��ü��'
when height-weight BETWEEN 111 and 120 then '����'
else '��ü��' end as �񸸵� from STUDENT;

select name, deptno1, decode(deptno1, 101,'�İ�', 102,'�ĸ�', 103,'����Ʈ�������', '��Ÿ') �а��� 
from STUDENT;

select name, deptno1, case
when deptno1 in (101,102,103) then '�İ�'
when deptno1 in (201,202,203) then '������'
else '�ڿ�����' end �а��� from STUDENT;

--select substr(jumin, 7,1) from STUDENT;
--select substr(tel, 1, instr(tel, ')')-1) from STUDENT;

select name, jumin, decode(substr(jumin, 7,1),1,'��',2,'��',3,'��',4,'��') �� from STUDENT;
select name, tel, decode(substr(tel, 1, instr(tel, ')')-1)
,02,'����',051, '�λ�', 052, '���', 055, '�泲','��Ÿ') ���� from STUDENT ;
--���� ���� �䳪��
select name, tel, case(substr(tel,1, instr(tel, ')')-1))
when '02' then '����' when '031' then '���' when '051' then '�λ�'
when '052' then '���' when '055' then '�泲' else '��Ÿ'end ����
from student;

/*�������̺� (professor)�� ������ �޿��׼��� �������� 
200 �̸��� 4��, 201 ? 300 ������ 3��, 
301 ? 400 ������ 2��, 401 �̻��� 1������ ǥ��
������ ��ȣ, �����̸�, �޿�, ����� ���. 
(�� pay �÷��� ������������ �����ϼ���)*/
select PROFNO, name, pay, case
when pay>=400 then '1��'
when pay>=300 then '2��'
when pay>=200 then '3��'
else '4��' end ��
from PROFESSOR order by pay desc;

select PROFNO, name, pay, case
when pay BETWEEN 0 and 200 then '4��'
when pay BETWEEN 201 and 300 then '3��'
when pay BETWEEN 301 and 400 then '2��'
else '4��' end ��
from PROFESSOR order by pay desc;


select name, substr(jumin,3,2) "�����",
case
when(substr(jumin,3,2)) between '01' and '03' then '1/4 �б�'
when(substr(jumin,3,2)) between '04' and '06' then '2/4 �б�'
when(substr(jumin,3,2)) between '07' and '09' then '3/4 �б�'
when(substr(jumin,3,2)) between '10' and '12' then '4/4 �б�'
else '���¾� ��'
end "�б⺰"
from student;

select name, to_char(pay,'999,999,999') ����, case
when pay BETWEEN 0 and 30000000 then to_char(pay*0.03,'999,999,999')
when pay BETWEEN 30000001 and 50000000 then to_char(pay*0.05,'999,999,999')
when pay BETWEEN 50000001 and 70000000 then to_char(pay*0.07,'999,999,999')
else to_char(pay*0.1,'999,999,999') end ����
from emp2;


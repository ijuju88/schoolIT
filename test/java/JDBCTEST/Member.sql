select * from tabs;
drop table member;
create table member(
	name VARCHAR2(20),
	age number(4),
	gender VARCHAR2(3));
	
select * from MEMBER;

insert into member values('김영희',27,'여');
commit;

delete from member where name='김영희';
-- KIM, LEE ����� �����ϱ�
CREATE USER KIM IDENTIFIED BY bluesky
  DEFAULT TABLESPACE users
  TEMPORARY TABLESPACE temp;

CREATE USER LEE IDENTIFIED BY redsun
  DEFAULT TABLESPACE users
  TEMPORARY TABLESPACE temp;

-- Grant ������� ����, ��� ���� �ֱ�
grant connect, resource, create session, create view to KIM;
grant connect, resource, create session, create view to LEE;

create table message(
	id number(10) primary key,
	password varchar2(50) not null,
	name varchar2(30) default '�̸�����',
	message varchar2(500)
)
������ ����� 
message_seq
create sequence message_seq start with 1
      increment by 1 maxvalue 9999999 cycle;

insert into message 
   values(message_seq.nextval,'�̸�','123','message');
      
      
      






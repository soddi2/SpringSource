create table spring_board(
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate, --default 값은 자동으로 갱신
	updatedate date default sysdate
);

alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

select * from spring_board;
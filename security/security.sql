create table spring_member(
	userid varchar2(50) not null primary key,
	userpw varchar2(100) not null,
	username varchar2(100) not null,
	regdate date default sysdate,
	updatedate date default sysdate,
	enabled char(1) default '1'
);

create table spring_member_auth(
	userid varchar2(50) not null,
	auth varchar2(50) not null, -- 유저 정보를 넣어 놓장 여기있는 정보로 관리자인지 사용자인지 확인
	constraint fk_member_auth foreign key(userid) references spring_member(userid)
);

-- admin90 => 2개의 권한 부여
insert into SPRING_MEMBER_AUTH values('admin90','ROLE_MEMBER');

select * from SPRING_MEMBER_AUTH where userid='admin90';

drop table persistent_login;

-- Remember Me 테이블
create table persistent_logins(
	username varchar2(64) not null,
	series varchar2(64) primary key,
	token varchar2(64) not null,
	last_used timestamp not null
);







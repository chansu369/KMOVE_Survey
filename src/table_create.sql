drop table admin;
drop sequence admin_seq;

drop table userinfo;
drop sequence userinfo_seq;

drop table person;
drop sequence person_seq;


create table person (
	num		number		primary key,
	name	varchar2(30)		not null,
	age		number		not null,
	phone	varchar2(50),
	address	varchar2(200)
);

create sequence person_seq;



create table admin (
	admin_num	number		primary key,
	num		number		not null,
	admin_id		varchar2(50) not null
	,admin_pwd	varchar2(50)	not null
	,constraint admin_fk foreign key(num)
	references person(num) on delete cascade
);

create sequence admin_seq;



create table userinfo (
	user_num	number		primary key,
	num		number		not null,
	user_id		varchar2(50) not null,
	user_pwd	varchar2(50)	not null,
	card		number		not null,
	constraint user_fk foreign key(num)
	references person(num) on delete cascade
);

create sequence userinfo_seq;








drop table reply;
drop sequence reply_seq;

drop table board;
drop sequence board_seq;

create table board (
	board_num number	 primary key,
	board_title  varchar2(20)  not null,	
	board_content	varchar(2000) not null,		
	board_name	varchar2(30) not null,			
	board_date	date default SYSDATE,			
	board_hit	number default 0
);


create sequence board_seq;


create table reply(
	reply_num		number		primary key
	,board_num	number		not null
	,reply_name	varchar2(30)	not null
	,reply_text		varchar2(2000)	not null
	,constraint reply_fk foreign key(board_num)
	references board(board_num) on delete cascade
);


create sequence reply_seq;



--설문테이블 초기화 --

drop table answer;
drop sequence answer_seq;

drop table choice;
drop sequence choice_seq;


drop table q_sheet;
drop sequence q_sheet_seq;


create table q_sheet(
	 q_code    number   primary key		
    ,q_type   varchar2(50)    not null	
	,q_num   number      unique		
	,q_text    varchar2(3000)   not null	
    ,a_type   number    not null  		
);

create sequence q_sheet_seq;


create table choice (
	answer_num	number	primary key
	,q_num	number	not null	
	,card		varchar2(30) not null
	,choice_num	number not null	
    ,answer_text  varchar2(2000)	not null
    ,constraint choice_q_code_fk foreign key(q_num) references q_sheet(q_num) on delete cascade
);
    
create sequence choice_seq;


create table answer (
	reply_number number primary key
    ,q_code number not null
	,answer_num number not null
    ,user_num number not null
    ,constraint answer_q_code_fk foreign key(q_code) references q_sheet(q_code)
    ,constraint answer_user_num_fk foreign key(user_num) references userinfo(user_num)
	,constraint answer_answer_num_fk foreign key(answer_num) references choice(answer_num) on delete cascade    
);

create sequence answer_seq;



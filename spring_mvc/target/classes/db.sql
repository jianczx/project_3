create table person(
	pid int primary key auto_increment,
	pname varchar(100)
)

insert into person(pname) value("a");
insert into person(pname) value("b");
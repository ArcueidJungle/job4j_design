create table races(
	id serial primary key,
	plane_name varchar(255),
	plane_number integer,
	passangers smallint
);
insert into races(plane_name, plane_number, passangers)
values('Boeing_737',321232,124);
update races set plane_number = 12435;
delete from races;

create table part (
  part varchar(100) not null,
  partId int not null primary key,
  partDate date not null,
  brand varchar(100) not null,
  car varchar(100) not null
);
insert into Part(part,partId,partDate,brand,car)values("ovo",345,2001-10-10,"radi","sad");


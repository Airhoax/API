create database partData;
use partData;
create table part
(
ID int not null primary key,
brand varchar(100) not null,
car varchar(100) not null,
pdate date not null,
paction int,
pvalue int,
pvisible int,
discount int
);

create table paction
(
ID int not null primary key,
pstart date not null,
pend date not null,
discount int not null
);
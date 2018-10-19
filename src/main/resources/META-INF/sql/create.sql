create sequence hibernate_sequence start with 10 increment by 1
create table Employee (id integer not null, codeMelli varchar(255), firstName varchar(255), lastName varchar(255), melliat varchar(255), location_id integer not null, primary key (id))
create table Kharid (id integer not null, jamMablagh double, jamMablaghNahayee double, jamTakhfif double, sharh varchar(255), tarikhSabt timestamp, primary key (id))
create table Location (id integer not null, address varchar(255), codePosti varchar(255), primary key (id))
create table RizKharid (id integer not null, darsadTakhfif double, fi double, mablaghKol double, mablaghNahayee double, mablaghTakhfif double, naam varchar(255), tedad integer, kharid_id integer, primary key (id))
alter table Employee add constraint UK_ncou30smc78sxu09jygrv7xa3 unique (location_id)
alter table Employee add constraint FK42j910116bv1agf21wckmkvvf foreign key (location_id) references Location
alter table RizKharid add constraint FK8cj1pc887ek924nr8pt57vcct foreign key (kharid_id) references Kharid
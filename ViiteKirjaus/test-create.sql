create table attribuutti (
  id                        integer primary key AUTOINCREMENT,
  nimi                      varchar(255),
  arvo                      varchar(255),
  viite_id                  integer)
;

create table viite (
  id                        integer primary key AUTOINCREMENT,
  tyyppi                    varchar(255))
;

create index ix_attribuutti_viite_1 on attribuutti (viite_id);



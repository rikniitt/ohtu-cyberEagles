create table attribuutti (
  id                        integer not null,
  nimi                      varchar(255),
  arvo                      varchar(255),
  viite_id                  integer,
  constraint pk_attribuutti primary key (id))
;

create table viite (
  id                        integer not null,
  tyyppi                    varchar(255),
  constraint pk_viite primary key (id))
;

create sequence attribuutti_seq;

create sequence viite_seq;

alter table attribuutti add constraint fk_attribuutti_viite_1 foreign key (viite_id) references viite (id) on delete restrict on update restrict;
create index ix_attribuutti_viite_1 on attribuutti (viite_id);



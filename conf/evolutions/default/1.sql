# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table image (
  id                        bigint not null,
  tag                       varchar(255) not null,
  image_name                varchar(255) not null,
  constraint pk_image primary key (id))
;

create sequence image_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists image;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists image_seq;


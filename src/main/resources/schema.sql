create table my_users (
  id integer not null primary key,
  first_nm varchar(20),
  last_nm varchar(20),
  parent_id integer not null,
  birth_dt date not null,
  death_dt date
);
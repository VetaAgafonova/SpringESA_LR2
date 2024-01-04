create table students(
  id            bigint primary key auto_increment,
  first_name    varchar(50) not null,
  last_name     varchar(50) not null,
  department_id bigint not null,
  FOREIGN KEY(department_id) REFERENCES departments(id)
);

create table departments(
  id            bigint primary key auto_increment,
  title         varchar(50) not null,
  leader        varchar(50) not null
);
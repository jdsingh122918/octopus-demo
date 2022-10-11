/*
  create address and appuser tables
 */

create table address
(
    id      bigserial primary key not null,
    zipcode varchar(255)          not null,
    city    varchar(255)
);

create table appuser
(
    id         bigserial primary key not null,
    surname    varchar(255)          not null,
    firstname  varchar(255),
    address_id bigint references address (id)
);
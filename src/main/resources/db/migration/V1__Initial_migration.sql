create table public.violations
(
    id                 serial
        constraint violations_pk
            primary key,
    drone_id           uuid                      not null,
    owner_id           uuid                      not null,
    timestamp          timestamptz default now() not null,
    position_x         double precision          not null,
    position_y         double precision          not null,
    position_z         double precision          not null,
    owner_first_name   varchar(100)              not null,
    owner_last_name    varchar(100)              not null,
    owner_ssn          varchar(50)               not null,
    owner_phone_number varchar(50)               not null
);

create index violations_timestamp_index
    on public.violations (timestamp);
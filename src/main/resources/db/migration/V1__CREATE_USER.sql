create table "user" (
    id serial constraint user_pk primary key,
    email varchar(255),
    password bigint,
    file varchar(255),
    theme varchar(255),
    font varchar(50),
    language varchar(10)
)

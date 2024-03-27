create table "user" (
    id serial constraint user_pk primary key,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    file varchar(255),
    theme varchar(255),
    font varchar(50),
    language varchar(10)
)

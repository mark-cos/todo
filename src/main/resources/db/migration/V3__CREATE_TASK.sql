create table "task" (
    id serial constraint task_pk primary key,
    user_id integer,
    title varchar(255),
    description varchar(255),
    priority integer,
    is_completed boolean,
    task_date timestamp,
    task_time timestamp,
    category_id integer
)

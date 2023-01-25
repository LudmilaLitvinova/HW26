CREATE SCHEMA IF NOT EXISTS my_university;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_university.my_university_id_seq;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_university.student
(
    id integer NOT NULL DEFAULT nextval('my_university.my_university_id_seq'),
    name             text NOT NULL,
    email            text NOT NULL,
--     fk_mark_id       integer,
    CONSTRAINT pk_my_university_student PRIMARY KEY (id)
    );

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_university.mark
(
    id integer NOT NULL DEFAULT nextval('my_university.my_university_id_seq'),
    fk_student_id    integer NOT NULL constraint fk_mark_id_fkey references my_university.student,
    discipline       text NOT NULL,
    value            integer NOT NULL
    );
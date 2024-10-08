-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

create database qcard_furry_friends_db;

use qcard_furryfriends_db;

create table if not exists pet
(
    id   BIGINT(19) auto_increment
    primary key,
    name VARCHAR(255) not null,
    age  INT(10)      not null,
    type VARCHAR(255) not null
    );

create table if not exists cat
(
    id     BIGINT(19)   not null
    primary key,
    color  VARCHAR(255) null,
    indoor TINYINT(3)   null,
    constraint cat_ibfk_1
    foreign key (id) references pet (id)
    on delete cascade
    );

create table if not exists dog
(
    id      BIGINT(19)   not null
    primary key,
    breed   VARCHAR(255) null,
    trained TINYINT(3)   null,
    constraint dog_ibfk_1
    foreign key (id) references pet (id)
    on delete cascade
    );

create table if not exists bird
(
    id      BIGINT(19)   not null
        primary key,
    color   VARCHAR(255) null,
    species VARCHAR(255) null,
    flying TINYINT(3)   null,
    constraint bird_ibfk_1
        foreign key (id) references pet (id)
            on delete cascade
);

create table if not exists ferret
(
    id      BIGINT(19)   not null
        primary key,
    size   VARCHAR(255) null,
    trained TINYINT(3)   null,
    constraint ferret_ibfk_1
        foreign key (id) references pet (id)
            on delete cascade
);
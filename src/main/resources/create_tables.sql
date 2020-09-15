show databases;

use jpa_example;
insert into foo values(1, 2, 3);
insert into food_child values(1, "Hola", 1);
insert into bar values(2, "hello", 1);
insert into bar_child values(1, 2);

CREATE TABLE FOO(
    id INTEGER NOT NULL PRIMARY KEY,
    bar_id INTEGER NULL,
    foo_child_id INTEGER NULL
)ENGINE=InnoDB;

CREATE TABLE FOO_CHILD(
    id INTEGER NOT NULL PRIMARY KEY,
    foo_field VARCHAR(64) NULL,
    foo_id INTEGER NULL
)ENGINE=InnoDB;

CREATE TABLE BAR(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(64) NULL,
    bar_child_id INTEGER NULL
)ENGINE=InnoDB;

CREATE TABLE BAR_CHILD(
    id INTEGER NOT NULL PRIMARY KEY,
    bar_id INTEGER NULL
)ENGINE=InnoDB;

drop table BAR_CHILD;

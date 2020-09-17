show databases;

use jpa_example;
insert into foo values(1, "Foo Name", 1, 1);
insert into foo_child values(1, "Foo Child name", 1);
insert into bar values(1, "Bar Name", 1, 1);
insert into bar_child values(1, 2);

delete from foo where id='1';

select * from foo;

CREATE TABLE FOO(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) NULL,
    bar_id INTEGER NULL,
    foo_child_id INTEGER NULL
)ENGINE=InnoDB;

CREATE TABLE FOO_CHILD(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(64) NULL,
    foo_id INTEGER NULL
)ENGINE=InnoDB;

CREATE TABLE BAR(
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(64) NULL,
    bar_child_id INTEGER NULL,
    food_id INTEGER NULL
)ENGINE=InnoDB;

CREATE TABLE BAR_CHILD(
    id INTEGER NOT NULL PRIMARY KEY,
    bar_id INTEGER NULL
)ENGINE=InnoDB;

drop table FOO;

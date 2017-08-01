-- DATABASE creation

DROP DATABASE IF EXISTS community;
CREATE DATABASE community;

use community;


-- STRUCTURE creation

CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(70) NOT NULL,
    email varchar(70) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE article (
    id int NOT NULL AUTO_INCREMENT,
    title text NOT NULL,
    text text NOT NULL,
    creationDate timestamp NOT NULL,
    authorId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (authorId) REFERENCES user (id)
);

CREATE TABLE comment (
    id int NOT NULL AUTO_INCREMENT,
    text text NOT NULL,
    date timestamp NOT NULL,
    authorId int NOT NULL,
    articleId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (authorId) REFERENCES user (id),
    FOREIGN KEY (articleId) REFERENCES article (id)
);


-- INDEX CREATION

CREATE INDEX email ON user (email);
CREATE INDEX name ON user (name);
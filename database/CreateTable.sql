-- DROP DATABASE DemoServlet;

CREATE DATABASE DemoServlet;

USE DemoServlet;

CREATE TABLE role
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    code VARCHAR(50) NOT NULL,
    createdAt TIMESTAMP,
    modifiedAt TIMESTAMP, 
    createdBy VARCHAR(50),
    modifiedBy VARCHAR(50),
    
    PRIMARY KEY (id)
);

CREATE TABLE user
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    fullName VARCHAR(255) NOT NULL,
    status INT NOT NULL,
    roleId BIGINT NOT NULL,
    createdAt TIMESTAMP,
    modifiedAt TIMESTAMP, 
    createdBy VARCHAR(50),
    modifiedBy VARCHAR(50),
    
    PRIMARY KEY (id)
);

CREATE TABLE category
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    code VARCHAR(50) NOT NULL,
    createdAt TIMESTAMP,
    modifiedAt TIMESTAMP, 
    createdBy VARCHAR(50),
    modifiedBy VARCHAR(50),
    
    PRIMARY KEY (id)
);

CREATE TABLE news
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    thumbnail VARCHAR(255) NOT NULL,
    shortDescription TEXT NOT NULL,
    content TEXT NOT NULL,
    categoryId BIGINT NOT NULL,
    createdAt TIMESTAMP,
    modifiedAt TIMESTAMP, 
    createdBy VARCHAR(50),
    modifiedBy VARCHAR(50),
    
    PRIMARY KEY (id)
);

CREATE TABLE comment
(
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
    content TEXT NOT NULL,
    userId BIGINT NOT NULL,
    newsId BIGINT NOT NULL,
    createdAt TIMESTAMP,
    modifiedAt TIMESTAMP, 
    createdBy VARCHAR(50),
    modifiedBy VARCHAR(50),
    
    PRIMARY KEY (id)
);

ALTER TABLE user 
ADD CONSTRAINT fk_userRole FOREIGN KEY (roleId) REFERENCES role(id);

ALTER TABLE news 
ADD CONSTRAINT fk_newsCategory FOREIGN KEY (categoryId) REFERENCES category(id);

ALTER TABLE comment 
ADD CONSTRAINT fk_commentUser FOREIGN KEY (userId) REFERENCES user(id);

ALTER TABLE comment 
ADD CONSTRAINT fk_commentNews FOREIGN KEY (newsId) REFERENCES news(id);

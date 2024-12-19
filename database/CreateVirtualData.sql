USE DemoServlet;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM user;
DELETE FROM role;
DELETE FROM comment;
DELETE FROM category;
DELETE FROM news;

INSERT INTO role(name, code)
VALUES
('Quản trị viên', 'ADMIN'),
('Người dùng hệ thống', 'USER');

INSERT INTO user(username, password, fullName, status, roleId)
VALUES
('admin', 'abc', 'Le Hong Phuc', 1, 1),
('nva', 'abc', 'Nguyen Van A', 1, 2),
('ltb', 'abc', 'Le Thi B', 1, 2);

INSERT INTO category(name, code)
VALUES
('Thể thao', 'SPORT'),
('Thế giới', 'WORLD'),
('Chính trị', 'POLITICS'),
('Thời sự', 'NEWS'),
('Góc nhìn', 'PERSPECTIVE');

INSERT INTO news(title, thumbnail, shortDescription, content, categoryId)
VALUES
('Bài viết 1', 'abc', 'xyz', 'abcdefgh', 1),
('Bài viết 2', 'abc', 'xyz', 'abcdefgh', 2),
('Bài viết 3', 'abc', 'xyz', 'abcdefgh', 3),
('Bài viết 4', 'abc', 'xyz', 'abcdefgh', 2),
('Bài viết 5', 'abc', 'xyz', 'abcdefgh', 1);

INSERT INTO comment(content, userId, newsId)
VALUES
('so good!', 1, 1),
('amazing!', 2, 2);


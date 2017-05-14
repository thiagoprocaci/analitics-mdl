CREATE TABLE mdl_user (
   id INT NOT NULL,
   username VARCHAR(200),
   firstname VARCHAR(200) ,
   lastname VARCHAR(200),
   creation DATE
);

CREATE TABLE mdl_forum_posts (
   id INT NOT NULL,
   parent INT,
   discussion INT,
   userid INT ,
   creation DATE,
   message CLOB
);

CREATE TABLE mdl_forum (
   id INT NOT NULL,
   course INT,
   name VARCHAR(200),
   type VARCHAR(200)
);

CREATE TABLE mdl_forum_discussions (
   id INT NOT NULL,
   name VARCHAR(200),
   forum INT,
   userId INT
);

CREATE TABLE mdl_course (
   id INT NOT NULL,
   shortname VARCHAR(200),
   fullname VARCHAR(200)
);
commit;
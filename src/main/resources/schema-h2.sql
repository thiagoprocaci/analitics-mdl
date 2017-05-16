CREATE TABLE users (
   id INT NOT NULL,
   username VARCHAR(400),
   firstname VARCHAR(400) ,
   lastname VARCHAR(400),
   creation DATE
);

CREATE TABLE post (
   id INT NOT NULL,
   parentpostid INT,
   discussionid INT,
   userid INT ,
   creation DATE,
   message CLOB
);

CREATE TABLE forum (
   id INT NOT NULL,
   courseid INT,
   name VARCHAR(400)
);

CREATE TABLE discussion (
   id INT NOT NULL,
   name VARCHAR(400),
   forumid INT,
   userid INT
);

CREATE TABLE course (
   id INT NOT NULL,
   shortname VARCHAR(400),
   fullname VARCHAR(400)
);

CREATE TABLE course_grade (
    id INT NOT NULL,
    userid INT NOT NULL,
    courseid INT NOT NULL,
    grade DOUBLE
);
commit;
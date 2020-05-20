DROP TABLE IF EXISTS timetable;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS period;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS daysofweek;
DROP TABLE IF EXISTS teaching;
DROP TABLE IF EXISTS leave;
DROP TABLE IF EXISTS leavestatus;
DROP TABLE IF EXISTS attendance;
DROP TABLE IF EXISTS school;
DROP TABLE IF EXISTS announcement;
DROP TABLE IF EXISTS chapter;
DROP TABLE IF EXISTS archivedclasses;
DROP TABLE IF EXISTS holiday;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS materialtypes;

CREATE TABLE materialtypes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  material_type VARCHAR(20)
);

INSERT INTO materialtypes (material_type) VALUES 
  ('Study'), 
  ('Assignment')
  ;

CREATE TABLE holiday (
  id INT AUTO_INCREMENT PRIMARY KEY,
  dated DATE,
  reason VARCHAR(100)
);

INSERT INTO holiday (dated, reason) VALUES 
  (parsedatetime('02-10-2020', 'dd-MM-yyyy'), 'Gandhi Jayanti'), 
  (parsedatetime('26-01-2020', 'dd-MM-yyyy'), 'Republic Day')
  ; 

CREATE TABLE school (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  phone VARCHAR(20),
  address VARCHAR(300)
);

INSERT INTO school (name, phone, address) VALUES 
  ('VET', '9901057180', 'JP Nagar')
  ;

CREATE TABLE daysofweek (
  id INT AUTO_INCREMENT PRIMARY KEY,
  day VARCHAR(20)
);

INSERT INTO daysofweek (day) VALUES 
  (Monday),
  (Tuesday),
  (Wednesday),
  (Thursday),
  (Friday),
  (Saturday),
  (Sunday)
  ; 

CREATE TABLE period (
  id INT AUTO_INCREMENT PRIMARY KEY,
  start_time TIME,
  end_time TIME
);

INSERT INTO period (start_time, end_time) VALUES 
  (PARSEDATETIME('09:00', 'HH:MM'), PARSEDATETIME('09:30', 'HH:MM')),
  (PARSEDATETIME('09:30', 'HH:MM'), PARSEDATETIME('10:00', 'HH:MM')),
  (PARSEDATETIME('10:15', 'HH:MM'), PARSEDATETIME('10:45', 'HH:MM'))
  (PARSEDATETIME('10:45', 'HH:MM'), PARSEDATETIME('11:15', 'HH:MM'))
  (PARSEDATETIME('11:45', 'HH:MM'), PARSEDATETIME('12:15', 'HH:MM'))
  (PARSEDATETIME('12:15', 'HH:MM'), PARSEDATETIME('12:45', 'HH:MM'))
  (PARSEDATETIME('01:00', 'HH:MM'), PARSEDATETIME('01:30', 'HH:MM'))
  (PARSEDATETIME('01:30', 'HH:MM'), PARSEDATETIME('02:00', 'HH:MM'))
  ;

CREATE TABLE role (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO role (name) VALUES 
  ('Teacher')
  ('Student')
  ('Parent')
  ('Principal')
  ('Admin')
  ;

CREATE TABLE classes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  classes_no INT,
  section_name VARCHAR(10)
);

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  full_name VARCHAR(300),
  dob date,
  gender VARCHAR(10),
  classes_id INT,
  role_id INT,
  email VARCHAR(300),
  phone VARCHAR(10),
  password VARCHAR(50),
  reference_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (role_id) references role(id)
);

CREATE TABLE subject (
  id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(50),
  classes_id INT,
  foreign key (classes_id) references classes(id)
);

CREATE TABLE timetable (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  classes_id INT,
  subject_id INT,
  period_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (subject_id) references subject(id),
  foreign key (period_id) references period(id)
);

CREATE TABLE teaching (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  teacher_id INT,
  subject_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (teacher_id) references subject(id),
  foreign key (subject_id) references period(id)
);

CREATE TABLE leavestatus (
  id INT AUTO_INCREMENT PRIMARY KEY,
  status VARCHAR(20)
);

CREATE TABLE leave (
  id INT AUTO_INCREMENT PRIMARY KEY,
  start_date DATE,
  end_date DATE,
  status_id INT,
  reference_id INT,
  reason VARCHAR(500),
  approved_date DATE,
  approver_id INT,
  foreign key (status_id) references leavestatus(id),
  foreign key (reference_id, approver_id) references users(id)
);

CREATE TABLE attendance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  dated DATE,
  period_id INT,
  duration INT,
  foreign key (user_id) references users(id),
  foreign key (period_id) references period(id)
);

CREATE TABLE announcement (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  dated DATE,
  timed TIME,
  subject_id INT,
  topic VARCHAR(50),
  data VARCHAR(500),
  author_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (author_id) references users(id),
  foreign key (subject_id) references subject(id)
);

CREATE TABLE chapter (
  id INT AUTO_INCREMENT PRIMARY KEY,
  subject_id INT,
  chapter_no INT,
  chapter_name VARCHAR(100),
  foreign key (subject_id) references subject(id)
);

CREATE TABLE archivedclasses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  dated DATE,
  period_id INT,
  subject_id INT,
  teacher_id INT,
  videourl VARCHAR(50);
  type VARCHAR(50);
  chapter_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (period_id) references period(id),
  foreign key (subject_id) references subject(id),
  foreign key (chapter_id) references chapter(id),
  foreign key (teacher_id) references users(id)
);

CREATE TABLE material (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  subject_id INT,
  chapter_id INT,
  material_type INT,
  file_type VARCHAR(20),
  file_size INT,
  author_id INT,
  material_data BLOB,
  foreign key (classes_id) references classes(id),
  foreign key (subject_id) references subject(id),
  foreign key (chapter_id) references chapter(id),
  foreign key (material_type) references materialtypes(id)
);

INSERT INTO daysofweek (day) VALUES
  ('Monday'),
  ('Tuesday'),
  ('Wednesday'),
  ('Thursday'),
  ('Friday'),
  ('Saturday'),
  ('Sunday')
;

INSERT INTO role (name) VALUES
  ('Teacher'),
  ('Student'),
  ('Parent'),
  ('Principal'),
  ('Admin')
;

INSERT INTO classes (classes_no, section_name) VALUES
  (5,'A'),
  (5,'B'),
  (6,'A'),
  (6,'B'),
  (6,'C')
  ;

INSERT INTO timetable (classes_id, subject_id, period_id) VALUES
  (1,12,1),
  (1,11,2),
  (1,9,3),
  (1,8,4),
  (1,7,5),
  (1,6,6),
  (1,10,7),
  (1,13,8),
  (1,12,1),
  (1,8,2),
  (1,7,3),
  (1,13,4),
  (1,6,5),
  (1,9,6),
  (1,11,7),
  (1,10,8),
  (1,12,1),
  (1,6,2),
  (1,11,3),
  (1,7,4),
  (1,10,5),
  (1,8,6),
  (1,13,7),
  (1,9,8),
  (1,12,1),
  (1,10,2),
  (1,8,3),
  (1,6,4),
  (1,13,5),
  (1,7,6),
  (1,9,7),
  (1,11,8),
  (1,12,1),
  (1,9,2),
  (1,10,3),
  (1,11,4),
  (1,8,5),
  (1,13,6),
  (1,6,7),
  (1,7,8),
  (1,12,1),
  (1,7,2),
  (1,13,3),
  (1,10,4),
  (1,6,5),
  (1,11,6),
  (1,8,7),
  (1,9,8)
  ;
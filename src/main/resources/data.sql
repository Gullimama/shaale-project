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
  ('Monday'),
  ('Tuesday'),
  ('Wednesday'),
  ('Thursday'),
  ('Friday'),
  ('Saturday'),
  ('Sunday')
  ;

CREATE TABLE role (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO role (name) VALUES 
  ('Teacher'),
  ('Student'),
  ('Parent'),
  ('Principal'),
  ('Admin')
  ;

CREATE TABLE classes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  classes_no INT,
  section_name VARCHAR(10)
);

INSERT INTO classes (classes_no, section_name) VALUES
  (5, 'A'),
  (5, 'B'),
  (6, 'A'),
  (6, 'B'),
  (6, 'C')
  ;

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

INSERT INTO users (full_name, dob, gender, classes_id, role_id, email, phone, password, reference_id) VALUES
  ('Guru Prasad', parsedatetime('08-05-1993', 'dd-MM-yyyy'), 'Male', 1, 2, 'hrgprasad@gmail.com', '9901057180', 'asdf', null),
  ('Hemanth Kumar', parsedatetime('08-06-1993', 'dd-MM-yyyy'), 'Male', 1, 2, 'hemanth@gmail.com', '9901057181', 'asdf', null),
  ('Nithin Anand', parsedatetime('08-07-1993', 'dd-MM-yyyy'), 'Male', 1, 2, 'nithin@gmail.com', '9901057182', 'asdf', null),
  ('Rajeev Chandrashekar', parsedatetime('08-08-1993', 'dd-MM-yyyy'), 'Male', 1, 2, 'rajeev@gmail.com', '9901057183', 'asdf', null),
  ('Amogh Raj', parsedatetime('08-09-1993', 'dd-MM-yyyy'), 'Male', 1, 2, 'amogh@gmail.com', '9901057184', 'asdf', null),
  ('Raghavendra Rao', parsedatetime('02-11-1960', 'dd-MM-yyyy'), 'Male', null, 3, 'raghavendra.rao@gmail.com', '9986482753', 'asdf', 1),
  ('Shashikala', parsedatetime('02-11-1980', 'dd-MM-yyyy'), 'Female', 1, 1, 'shashikala@gmail.com', '9986482754', 'asdf', null),
  ('Hema Malini', parsedatetime('02-11-1983', 'dd-MM-yyyy'), 'Female', null, 1, 'hema.malini@gmail.com', '9986482755', 'asdf', null)
  ;

CREATE TABLE period (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  start_time TIME,
  end_time TIME,
  foreign key (classes_id) references classes(id)
);

INSERT INTO period (classes_id, start_time, end_time) VALUES
  (1, PARSEDATETIME('09:00', 'HH:mm'), PARSEDATETIME('09:30', 'HH:mm')),
  (1, PARSEDATETIME('09:30', 'HH:mm'), PARSEDATETIME('10:00', 'HH:mm')),
  (null, PARSEDATETIME('10:00', 'HH:mm'), PARSEDATETIME('10:15', 'HH:mm')),
  (1, PARSEDATETIME('10:15', 'HH:mm'), PARSEDATETIME('10:45', 'HH:mm')),
  (1, PARSEDATETIME('10:45', 'HH:mm'), PARSEDATETIME('11:15', 'HH:mm')),
  (1, PARSEDATETIME('11:15', 'HH:mm'), PARSEDATETIME('11:45', 'HH:mm')),
  (null, PARSEDATETIME('11:45', 'HH:mm'), PARSEDATETIME('12:30', 'HH:mm')),
  (1, PARSEDATETIME('12:30', 'HH:mm'), PARSEDATETIME('01:00', 'HH:mm')),
  (1, PARSEDATETIME('01:00', 'HH:mm'), PARSEDATETIME('01:30', 'HH:mm')),
  (1, PARSEDATETIME('01:30', 'HH:mm'), PARSEDATETIME('02:00', 'HH:mm'))
  ;

CREATE TABLE subject (
  id INT AUTO_INCREMENT PRIMARY KEY,
  subject_name VARCHAR(50),
  classes_id INT,
  foreign key (classes_id) references classes(id)
);

INSERT INTO subject (subject_name, classes_id) VALUES
  ('English-2',1),
  ('Kannada-1',1),
  ('Hindi-3',1),
  ('Sanskrit-1',1),
  ('Kannada-3',1),
  ('Socials',1),
  ('Maths',1),
  ('Physics',1),
  ('Chemistry',1),
  ('Biology',1),
  ('Elective-1',1),
  ('Elective-2',1),
  ('Elective-3',1)
  ;

CREATE TABLE teaching (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  teacher_id INT,
  subject_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (teacher_id) references subject(id),
  foreign key (subject_id) references period(id)
);

INSERT INTO teaching (classes_id, teacher_id, subject_id) VALUES
  (1, 7, 1),
  (1, 7, 6),
  (1, 8, 7),
  (1, 8, 9)
  ;

CREATE TABLE timetable (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  day_id INT,
  classes_id INT,
  subject_id INT,
  period_id INT,
  teaching_id INT,
  foreign key (day_id) references daysofweek(id),
  foreign key (classes_id) references classes(id),
  foreign key (subject_id) references subject(id),
  foreign key (period_id) references period(id),
  foreign key (teaching_id) references teaching(id)
);

INSERT INTO timetable (day_id, classes_id, subject_id, teaching_id, period_id) VALUES
  (1, 1, 1, 1, 1),
  (1, 1, 6, 2, 2),
  (1, 1, 7, 3, 4),
  (1, 1, 9, 4, 5),
  (1, 1, 1, 1, 6),
  (1, 1, 6, 2, 8),
  (1, 1, 7, 3, 9),
  (1, 1, 9, 4, 10),

  (2, 1, 1, 1, 1),
  (2, 1, 6, 2, 2),
  (2, 1, 7, 3, 4),
  (2, 1, 9, 4, 5),
  (2, 1, 1, 1, 6),
  (2, 1, 6, 2, 8),
  (2, 1, 7, 3, 9),
  (2, 1, 9, 4, 10),

  (3, 1, 1, 1, 1),
  (3, 1, 6, 2, 2),
  (3, 1, 7, 3, 4),
  (3, 1, 9, 4, 5),
  (3, 1, 1, 1, 6),
  (3, 1, 6, 2, 8),
  (3, 1, 7, 3, 9),
  (3, 1, 9, 4, 10),

  (4, 1, 1, 1, 1),
  (4, 1, 6, 2, 2),
  (4, 1, 7, 3, 4),
  (4, 1, 9, 4, 5),
  (4, 1, 1, 1, 6),
  (4, 1, 6, 2, 8),
  (4, 1, 7, 3, 9),
  (4, 1, 9, 4, 10),

  (5, 1, 1, 1, 1),
  (5, 1, 6, 2, 2),
  (5, 1, 7, 3, 4),
  (5, 1, 9, 4, 5),
  (5, 1, 1, 1, 6),
  (5, 1, 6, 2, 8),
  (5, 1, 7, 3, 9),
  (5, 1, 9, 4, 10),

  (6, 1, 1, 1, 1),
  (6, 1, 6, 2, 2),
  (6, 1, 7, 3, 4),
  (6, 1, 9, 4, 5),
  (6, 1, 1, 1, 6),
  (6, 1, 6, 2, 8),
  (6, 1, 7, 3, 9),
  (6, 1, 9, 4, 10)
  ;



CREATE TABLE leavestatus (
  id INT AUTO_INCREMENT PRIMARY KEY,
  status VARCHAR(20)
);

INSERT INTO leavestatus (status) VALUES
  ('PENDING'),
  ('APPROVED'),
  ('REJECTED')
  ;

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
  foreign key (reference_id) references users(id),
  foreign key (approver_id) references users(id)
);

INSERT INTO leave (start_date, end_date, status_id, reference_id, reason, approved_date, approver_id) VALUES
  (parsedatetime('08-05-2020', 'dd-MM-yyyy'), parsedatetime('09-05-1993', 'dd-MM-yyyy'), 1, 1, 'out of station', null, null),
  (parsedatetime('18-05-2020', 'dd-MM-yyyy'), parsedatetime('19-05-1993', 'dd-MM-yyyy'), 2, 1, 'fever', parsedatetime('20-05-1993', 'dd-MM-yyyy'), 7)
  ;

CREATE TABLE attendance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  dated DATE,
  period_id INT,
  duration INT,
  teaching_id INT,
  foreign key (user_id) references users(id),
  foreign key (period_id) references period(id),
  foreign key (teaching_id) references teaching(id)
);

CREATE TABLE announcement (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  dated DATE,
  timed TIME,
  subject_id INT,
  topic VARCHAR(50),
  datum VARCHAR(500),
  author_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (author_id) references users(id),
  foreign key (subject_id) references subject(id)
);

INSERT INTO announcement (classes_id, dated, timed, subject_id, topic, datum, author_id) VALUES
  (1, parsedatetime('05-05-2020', 'dd-MM-yyyy'), PARSEDATETIME('09:00', 'HH:mm'), null, 'Excursion', 'Picnic to Santanur', 7),
  (1, parsedatetime('15-05-2020', 'dd-MM-yyyy'), PARSEDATETIME('13:00', 'HH:mm'), 1, 'Grammar-Video', 'Video published for last class on Grammar', 7)
  ;

CREATE TABLE chapter (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  subject_id INT,
  chapter_no INT,
  chapter_name VARCHAR(100),
  foreign key (subject_id) references subject(id),
  foreign key (classes_id) references classes(id)
);

INSERT INTO chapter (classes_id, subject_id, chapter_no, chapter_name) VALUES
  (1, 1, 1, 'Rabbit and the Hole'),
  (1, 1, 2, 'Sudarshini - A whole life'),
  (1, 1, 3, 'Grammar - Verbs'),
  (1, 1, 4, 'Vikram and Betal'),
  (1, 1, 5, 'Tenali Raman'),
  (1, 1, 6, 'Grammar - Nouns')
  ;

CREATE TABLE archivedclasses (
  id INT AUTO_INCREMENT PRIMARY KEY,
  classes_id INT,
  dated DATE,
  period_id INT,
  subject_id INT,
  teacher_id INT,
  videourl VARCHAR(50),
  type_of_class VARCHAR(50),
  chapter_id INT,
  foreign key (classes_id) references classes(id),
  foreign key (period_id) references period(id),
  foreign key (subject_id) references subject(id),
  foreign key (chapter_id) references chapter(id),
  foreign key (teacher_id) references users(id)
);

INSERT INTO archivedclasses (classes_id, dated, period_id, subject_id, teacher_id, videourl, type_of_class, chapter_id) VALUES
  (1, parsedatetime('05-05-2020', 'dd-MM-yyyy'), 1, 1, 7, 'https://youtu.be/Y1mx7cx6ckI', 'class', 1),
  (1, parsedatetime('06-05-2020', 'dd-MM-yyyy'), 1, 1, 7, 'https://youtu.be/_GhdFOZTWTw', 'class', 1)
  ;

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


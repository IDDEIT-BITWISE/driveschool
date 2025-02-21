-- Вставка данных в таблицу car
INSERT INTO car (license_plate, name) VALUES
('А123ВС77', 'Toyota Corolla'),
('В456ОР78', 'Hyundai Solaris'),
('С789ТУ79', 'Kia Rio'),
('Е012КХ80', 'Lada Vesta'),
('М345АВ81', 'Volkswagen Polo');

-- Вставка данных в таблицу instructor
INSERT INTO instructor (first_name, second_name, third_name, bio, car_id) VALUES
('Иван', 'Иванов', 'Иванович', 'Опытный инструктор с 10-летним стажем.',1),
('Петр', 'Петров', 'Петрович', 'Специалист по экстремальному вождению.',2),
('Сергей', 'Сергеев', 'Сергеевич', 'Инструктор по вождению в городе.',3),
('Алексей', 'Алексеев', 'Алексеевич', 'Эксперт по парковке.',4),
('Дмитрий', 'Дмитриев', 'Дмитриевич', 'Инструктор для начинающих.',5);

-- Вставка данных в таблицу student

INSERT INTO student (username, password, balance, user_role) VALUES
('student1', '{noop}123', 1000, 'STUDENT_ROLE'),
('student2', '{noop}123', 1500, 'STUDENT_ROLE'),
('student3', '{noop}123', 2000, 'STUDENT_ROLE'),
('student4', '{noop}123', 2500, 'STUDENT_ROLE'),
('admin', '{noop}123', 3000, 'ADMIN_ROLE');

-- Вставка данных в таблицу lesson
INSERT INTO lesson (date, student_id, instructor_id, price) VALUES
('2023-10-01', 1, 1, 1000),
('2023-10-02', 2, 2, 1000),
('2023-10-03', 3, 3, 1000),
('2023-10-04', 4, 4, 1000);

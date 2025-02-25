-- Вставка данных в таблицу cars
INSERT INTO cars (license_plate, name) VALUES
('А123ВС77', 'Toyota Corolla'),
('В456ОР78', 'Hyundai Solaris'),
('С789ТУ79', 'Kia Rio'),
('Е012КХ80', 'Lada Vesta'),
('М345АВ81', 'Volkswagen Polo');

-- Вставка данных в таблицу instructors
INSERT INTO instructors (first_name, second_name, third_name, bio, car_id) VALUES
('Иван', 'Иванов', 'Иванович', 'Опытный инструктор с 10-летним стажем.', 1),
('Петр', 'Петров', 'Петрович', 'Специалист по экстремальному вождению.', 2),
('Сергей', 'Сергеев', 'Сергеевич', 'Инструктор по вождению в городе.', 3),
('Алексей', 'Алексеев', 'Алексеевич', 'Эксперт по парковке.', 4),
('Дмитрий', 'Дмитриев', 'Дмитриевич', 'Инструктор для начинающих.', 5);

-- Вставка данных в таблицу users
INSERT INTO users (username, password, balance, user_role) VALUES
('student1', '{noop}123', 1000, 'STUDENT_ROLE'),
('student2', '{noop}123', 1500, 'STUDENT_ROLE'),
('student3', '{noop}123', 2000, 'STUDENT_ROLE'),
('student4', '{noop}123', 2500, 'STUDENT_ROLE'),
('admin', '{noop}123', 3000, 'ADMIN_ROLE');

-- Вставка данных в таблицу lessons
INSERT INTO lessons (date, start_time, price, instructor_id, user_id) VALUES
('2023-10-02', '10:00', 1000, 1, 1),  -- Занятие 1, записан student1
('2023-10-02', '12:00', 1000, 2, NULL), -- Занятие 2, свободно
('2023-10-03', '14:00', 1000, 3, 2),  -- Занятие 3, записан student2
('2023-10-24', '16:00', 1000, 4, NULL), -- Занятие 4, свободно
('2023-10-05', '18:00', 1000, 5, 3),
('2025-02-17', '18:00', 1000, 4, 3),
('2025-02-24', '18:00' 1000, 5, 1),
('2025-02-24', '18:00' 1000, 1, 1);
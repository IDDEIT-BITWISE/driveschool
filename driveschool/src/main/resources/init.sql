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

INSERT INTO lessons (date, time, price, instructor_id, user_id) VALUES
-- 2025-03-05
('2025-03-05', '9:00', 1000, 1, NULL),
('2025-03-05', '11:00', 1000, 1, NULL),
('2025-03-05', '13:00', 1000, 1, NULL),
('2025-03-05', '9:00', 1000, 2, NULL),
('2025-03-05', '13:00', 1000, 2, NULL),
('2025-03-05', '17:00', 1000, 2, NULL),
('2025-03-05', '11:00', 1000, 3, NULL),
('2025-03-05', '15:00', 1000, 3, NULL),
('2025-03-05', '17:00', 1000, 3, NULL),
('2025-03-05', '9:00', 1000, 4, NULL),
('2025-03-05', '15:00', 1000, 4, NULL),
('2025-03-05', '17:00', 1000, 4, NULL),
('2025-03-05', '11:00', 1000, 5, NULL),
('2025-03-05', '13:00', 1000, 5, NULL),
('2025-03-05', '15:00', 1000, 5, NULL),

-- 2025-03-06
('2025-03-06', '9:00', 1000, 1, NULL),
('2025-03-06', '11:00', 1000, 1, NULL),
('2025-03-06', '13:00', 1000, 1, NULL),
('2025-03-06', '9:00', 1000, 2, NULL),
('2025-03-06', '13:00', 1000, 2, NULL),
('2025-03-06', '17:00', 1000, 2, NULL),
('2025-03-06', '11:00', 1000, 3, NULL),
('2025-03-06', '15:00', 1000, 3, NULL),
('2025-03-06', '17:00', 1000, 3, NULL),
('2025-03-06', '9:00', 1000, 4, NULL),
('2025-03-06', '15:00', 1000, 4, NULL),
('2025-03-06', '17:00', 1000, 4, NULL),
('2025-03-06', '11:00', 1000, 5, NULL),
('2025-03-06', '13:00', 1000, 5, NULL),
('2025-03-06', '15:00', 1000, 5, NULL),

-- 2025-03-07
('2025-03-07', '9:00', 1000, 1, NULL),
('2025-03-07', '11:00', 1000, 1, NULL),
('2025-03-07', '13:00', 1000, 1, NULL),
('2025-03-07', '9:00', 1000, 2, NULL),
('2025-03-07', '13:00', 1000, 2, NULL),
('2025-03-07', '17:00', 1000, 2, NULL),
('2025-03-07', '11:00', 1000, 3, NULL),
('2025-03-07', '15:00', 1000, 3, NULL),
('2025-03-07', '17:00', 1000, 3, NULL),
('2025-03-07', '9:00', 1000, 4, NULL),
('2025-03-07', '15:00', 1000, 4, NULL),
('2025-03-07', '17:00', 1000, 4, NULL),
('2025-03-07', '11:00', 1000, 5, NULL),
('2025-03-07', '13:00', 1000, 5, NULL),
('2025-03-07', '15:00', 1000, 5, NULL);

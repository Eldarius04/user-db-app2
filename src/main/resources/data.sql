CREATE TABLE IF NOT EXISTS persons (
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    phone_number VARCHAR(20),
    city_of_living VARCHAR(50),
    PRIMARY KEY (name, surname, age)
);

INSERT INTO persons (name, surname, age, phone_number, city_of_living) VALUES
('Иван', 'Иванов', 25, '1234567', 'Moscow'),
('Петр', 'Петров', 30, '7654321', 'Saint-Petersburg'),
('Анна', 'Сидорова', 28, '5555555', 'Moscow'),
('Мария', 'Смирнова', 35, '9876543', 'Kazan');